package io.ryuichi

import software.amazon.awscdk.core.*
import software.amazon.awscdk.services.lambda.Code
import software.amazon.awscdk.services.lambda.Function
import software.amazon.awscdk.services.lambda.FunctionProps
import software.amazon.awscdk.services.lambda.Runtime
import software.amazon.awscdk.services.s3.assets.AssetOptions

class InfraStack(scope: Construct, id: String, props: StackProps?) : Stack(scope, id, props) {
    constructor(scope: Construct, id: String): this(scope, id, null)

    init {
        val packageInstructions = listOf("/bin/sh", "-c",
            "./gradlew fatJar && cp build/libs/app-fat.jar /asset-output/"
        )

        val builderOptions = BundlingOptions.builder()
            .command(packageInstructions)
            .image(Runtime.JAVA_11.bundlingImage)
            .volumes(listOf(
                DockerVolume.builder()
                    .hostPath("${System.getProperty("user.home")}/.m2/")
                    .containerPath("/root/.m2/")
                    .build(),
                DockerVolume.builder()
                    .hostPath("${System.getProperty("user.home")}/.gradle/")
                    .containerPath("/root/.gradle/")
                    .build()
            ))
            .user("root")
            .outputType(BundlingOutput.ARCHIVED)
            .build()

        Function(this, "cdk-lambda-cron", FunctionProps.builder()
            .functionName("cdk-lambda-cron")
            .description("Lambda which prints \"I'm running\"")
            .code(Code.fromAsset("../app/", AssetOptions.builder().bundling(builderOptions).build()))
            .runtime(Runtime.JAVA_11)
            .handler("io.ryuichi.Handler")
            .memorySize(1024)
            .timeout(Duration.seconds(300))
            .build())
    }
}
