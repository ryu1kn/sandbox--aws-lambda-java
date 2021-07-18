package io.ryuichi

import software.amazon.awscdk.core.Construct
import software.amazon.awscdk.core.Stack
import software.amazon.awscdk.core.StackProps

class InfraStack(scope: Construct, id: String, props: StackProps?) : Stack(scope, id, props) {
    constructor(scope: Construct, id: String): this(scope, id, null)
}
