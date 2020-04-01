# Amazon S3 Connector

Provides access to Amazon S3 buckets and objects.

## Typical usage scenario

File transfer between systems using S3.

## Upgrade to v.4 instructions

Remove aws-java-sdk- files from your userlib directory.
Make backups and test!

## Using the connector

Attach the AfterStartup microflow to your startup logic.
Attach the Administration snippet to your application.
Configure your S3 account using AWS API credentials.

Use the explorer to explore what's there (if you have the proper rights in your API account).
Use the connector actions to perform the actions required.

Important Note: when running locally, the module will fail with a Java security error unless you disable the "emulate cloud security" option in your project settings. This module _does_ work on Mendix Cloud v4 without any additional modifications to the app or cloud node.

## Dependencies

Depending on the Library Logging module.
This module provides the Amazon SDK for Java libraries.
All libraries are suffixed with AWSS3Connector.RequiredLib.
