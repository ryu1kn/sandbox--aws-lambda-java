package io.ryuichi

import com.amazonaws.services.lambda.runtime.Context

class TestContext : Context {

    override fun getAwsRequestId() = "495b12a8-xmpl-4eca-8168-160484189f99"

    override fun getLogGroupName() = "/aws/lambda/my-function"

    override fun getLogStreamName() = "2020/02/26/[\$LATEST]704f8dxmpla04097b9134246b8438f1a"

    override fun getFunctionName() = "my-function"

    override fun getFunctionVersion() = "\$LATEST"

    override fun getInvokedFunctionArn() = "arn:aws:lambda:us-east-2:123456789012:function:my-function"

    override fun getIdentity() = null

    override fun getClientContext() = null

    override fun getRemainingTimeInMillis() = 300000

    override fun getMemoryLimitInMB() = 512

    override fun getLogger() = TestLogger()
}
