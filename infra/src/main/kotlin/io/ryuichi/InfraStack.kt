package io.ryuichi

import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.core.Duration
import software.amazon.awscdk.core.Stack
import software.amazon.awscdk.core.StackProps
import software.amazon.awscdk.services.lambda.Code
import software.amazon.awscdk.services.lambda.Runtime
import software.amazon.awscdk.services.lambda.SingletonFunction
import java.util.*

class InfraStack(scope: Construct, id: String, props: StackProps?) : Stack(scope, id, props) {
    constructor(scope: Construct, id: String): this(scope, id, null)

    init {
        SingletonFunction.Builder.create(this, "cdk-lambda-cron")
            .functionName("cdk-lambda-cron")
            .description("Lambda which prints \"I'm running\"")
            .code(Code.fromInline("def main(event, context):\n" + "    print(\"I'm running!\")\n"))
            .handler("index.main")
            .timeout(Duration.seconds(300))
            .runtime(Runtime.PYTHON_2_7)
            .uuid(UUID.randomUUID().toString())
            .build();
    }
}
