import example.Handler
import example.TestContext
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class InvokeTest {
    private val logger = LoggerFactory.getLogger(InvokeTest::class.java)

    @Test
    fun invokeTest() {
        logger.info("Invoke TEST");
        val event = emptyMap<String, String>()
        val context = TestContext()
        val handler = Handler()
        val result = handler.handleRequest(event, context)
        assertTrue(result.contains("200 OK"));
    }
}
