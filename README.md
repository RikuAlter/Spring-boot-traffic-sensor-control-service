# S3 Upload Event Handler Using Java and AWS Lambda
Dscribed here is a template java program whose purpose is to read contents of a S3 Object when an event is detected by AWS Lambda Trigger.

The code does not perform the detection of the event, that functionality is made available in AWS. Through the code we can accept the event "payload" that is generated on occurance of a PUT event in a specific bucket in S3 that is tied to our Lambda function.

I have opted to give a brief run down of the process of implemention of a Java program to do the above here. Starting from IAM role creation to viewing logs in Cloudwatch for our program.

# Pre-requisites
1. A bucket created in S3
2. IDE to write the Java code 

**Note: If you are uploading Jar/zip, make sure you are using Java 11, if you are using a docker container then there are no restrictions  on the version to my knowledge.**

# Create a Lambda Function
