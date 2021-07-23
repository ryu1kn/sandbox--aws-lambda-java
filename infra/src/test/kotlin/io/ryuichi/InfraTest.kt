package io.ryuichi

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.junit.Test
import software.amazon.awscdk.core.App
import kotlin.test.assertEquals

class InfraTest {
    private val JSON = ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true)

    @Test
    fun testStack() {
        val app = App()
        val stack = InfraStack(app, "test")

        // synthesize the stack to a CloudFormation template
        val actual = JSON.valueToTree<JsonNode>(app.synth().getStackArtifact(stack.artifactId).template);

        assertEquals(2, actual.get("Resources").size())
    }
}
