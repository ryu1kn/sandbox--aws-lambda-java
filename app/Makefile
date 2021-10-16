
invoke:
	aws lambda invoke --function-name cdk-lambda-cron \
		--cli-binary-format raw-in-base64-out \
		--payload file://event.json \
		lambda-output.txt \
		--region ap-southeast-2

local-run:
	sam local invoke MyFunction --event event.json
