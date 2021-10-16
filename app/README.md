# Basic function with minimal dependencies (Java)

![Architecture](./images/sample-java-basic.png)

The project source includes function code and supporting resources:

## Requirements

* JDK 11
* [The AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html)
* [AWS SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html)

## Deploy & Undeploy

Go to [`../infra`](../infra) directory and follow its instructions.

## Locally run the lambda

```sh
make local-run
```

## Test

To invoke the function, run:

```sh
make invoke
```

## References

* [Kotlin and Groovy JVM Languages with AWS Lambda](https://aws.amazon.com/blogs/compute/kotlin-and-groovy-jvm-languages-with-aws-lambda/)
