package io.ryuichi

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import org.slf4j.LoggerFactory
import org.slf4j.MDC

class Handler : RequestHandler<Map<String, String>, String> {

    override fun handleRequest(event: Map<String, String>, context: Context): String {
        try {
            MDC.put("region", System.getenv("AWS_REGION"))

            logger.info("ENVIRONMENT VARIABLES: " + System.getenv().toString())
            logger.info("CONTEXT: $context")
            logger.info("EVENT: $event")
            logger.info("EVENT TYPE: " + event::class.java)

            return "200 OK"
        } finally {
            MDC.remove("region")
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(Handler::class.java)
    }
}
