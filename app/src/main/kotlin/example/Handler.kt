package example;

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

class Handler : RequestHandler<Map<String, String>, String> {

    override fun handleRequest(event: Map<String, String>, context: Context): String {
        val logger = context.logger
        val response = "200 OK";

        // log execution details
        logger.log("ENVIRONMENT VARIABLES: " + System.getenv().toString());
        logger.log("CONTEXT: $context");
        logger.log("EVENT: $event");
        logger.log("EVENT TYPE: " + event::class.java);
        return response;
    }
}
