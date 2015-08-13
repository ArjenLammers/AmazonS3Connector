# Amazon S3 Connector

Provides access to Amazon S3 buckets and objects, including downloading and uploading objects.

## Contributing

For more information on contributing to this repository visit [Contributing to a GitHub repository](https://world.mendix.com/display/howto50/Contributing+to+a+GitHub+repository)!

## Typical usage scenario

Use the connector to integrate with S3 to interact with S3 objects in your application.
 
## Using the connector

To use the connector, use the microflows that allow you to list the buckets, list the objects, download objects, and upload a S3FileDocument. 

Example flow:

1. Configure AccessKey and SecretKey in the Config page.
2. Integrate Buckets_Overview page to access objects by bucket.

## Finding Specific Objects

Amazon S3 uses the Object's Key as the unique identifier. This means that if you want to keep a reference to a specific object, you should use the S3SummaryObject.Key attribute. The Key includes all prefixes, similar to a UNC path to a file.

## Dependencies

This module provides the Amazon SDK for Java libraries. Those required are:

* aws-java-sdk-1.9.39.jar
* commons-logging-1.1.jar
* httpclient-4.3.jar
* httpcore-4.3.jar
* jackson-annotations-2.3.0.jar
* jackson-core-2.3.2.jar
* jackson-databind-2.3.2.jar
