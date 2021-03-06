# Infra

The contents is originally generated with `cdk init app --language java`

The `cdk.json` file tells the CDK Toolkit how to execute your app.

## Prerequisites

* yarn (used to install aws-cdk in the current directory)
* JDK 11

## Build

To build this app, you need to be in this example's root folder. Then run the following:

```sh
yarn install
```

Create resources for AWS CDK to store assets (replace `<account-id>` and `<region>`)

```sh
yarn cdk bootstrap aws://<account-id>/<region>
```

## Deploy

```sh
yarn cdk deploy
```

This will deploy / redeploy your Stack to your AWS Account.

After the deployment you will see the API's URL, which represents the url you can then use.

## Synthesize Cloudformation Template

To see the Cloudformation template generated by the CDK, run:

```sh
yarn cdk synth
```

then check the output file in the "cdk.out" directory.

## Other useful commands

* `./gradlew test`  Run tests
* `cdk ls`          list all stacks in the app
* `cdk deploy`      deploy this stack to your default AWS account/region
* `cdk diff`        compare deployed stack with current state
* `cdk docs`        open CDK documentation

## References

* [AWS Cloud Development Kit (AWS CDK) - Getting Started](https://docs.aws.amazon.com/cdk/latest/guide/getting_started.html)
* [CDK Java Example](https://github.com/aws-samples/aws-cdk-examples/tree/aaffc895592d41981f1c2817d0a6c1912333ad52/java/lambda-cron)
* [Packaging and deploying AWS Lambda functions written in Java with AWS Cloud Development Kit](https://aws.amazon.com/blogs/opensource/packaging-and-deploying-aws-lambda-functions-written-in-java-with-aws-cloud-development-kit/)
