package io.ryuichi

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.junit.Test
import software.amazon.awscdk.core.App

class InfraTest {
    private val JSON = ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true)

    @Test
    fun testStack() {
        val app = App()
        val stack = InfraStack(app, "test")

        // synthesize the stack to a CloudFormation template
        val actual: JsonNode = JSON.valueToTree(app.synth().getStackArtifact(stack.getArtifactId()).getTemplate());

        // Update once resources have been added to the stack
        assert(actual.get("Resources") == null)
    }
}
