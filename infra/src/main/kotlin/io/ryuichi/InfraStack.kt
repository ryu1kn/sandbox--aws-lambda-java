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
        val homeDirectory = System.getProperty("user.home")

        val packageInstructions = listOf("/bin/sh", "-c",
            "./gradlew fatJar && cp build/libs/app-fat.jar /asset-output/"
        )

        val builderOptions = BundlingOptions.builder()
            .command(packageInstructions)
            .image(Runtime.JAVA_11.bundlingImage)
            .volumes(mapOf(
                "$homeDirectory/.m2/" to "/root/.m2/",
                "$homeDirectory/.gradle/" to "/root/.gradle/"
            ).toDockerVolumes())
            .user("root")
            .outputType(BundlingOutput.ARCHIVED)
            .build()

        Function(this, "cdk-lambda-cron", FunctionProps.builder()
            .functionName("cdk-lambda-cron")
            .code(Code.fromAsset("../app/", AssetOptions.builder().bundling(builderOptions).build()))
            .runtime(Runtime.JAVA_11)
            .handler("io.ryuichi.Handler")
            .memorySize(512)
            .timeout(Duration.seconds(300))
            .build())
    }

    private fun Map<String, String>.toDockerVolumes() =
        this.toList().map { DockerVolume.builder().hostPath(it.first).containerPath(it.second).build() }
}
