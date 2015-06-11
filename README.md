# Amazon S3 Connector

Provides access to Amazon S3 buckets and objects, including downloading and uploading objects.

## Contributing

For more information on contributing to this repository visit [Contributing to a GitHub repository](https://world.mendix.com/display/howto50/Contributing+to+a+GitHub+repository)!

## Typical usage scenario

Use the connector to integrate into S3 to interact with S3 files in your application.
 
## Using the connector

To use the connector, use the microflows that allow you to list the buckets, list the objects, download objects, and upload a S3FileDocument.

Note that when interacting with S3 objects, the attribute 'key' is the object name, corresponding to the S3FileDocument attribute 'Name'.

Example flow:

1. Configure AccessKey and SecretKey.
2. Use DS_GetBuckets to list the available buckets.
3. Use DS_GetObjects to list the available objects.
4. Use DS_GetObject_FileContents to download a file.
5. Use IVK_PutObject to upload a S3FileDocument, a generalization of the Mendix FileDocument.
