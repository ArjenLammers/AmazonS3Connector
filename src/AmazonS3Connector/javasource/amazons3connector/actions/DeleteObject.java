// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package amazons3connector.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import amazons3connector.AmazonHelper;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;

public class DeleteObject extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject __awsConfig;
	private amazons3connector.proxies.AwsConfig awsConfig;
	private IMendixObject __region;
	private amazons3connector.proxies.Region region;
	private java.lang.String bucket;
	private java.lang.String key;

	public DeleteObject(IContext context, IMendixObject awsConfig, IMendixObject region, java.lang.String bucket, java.lang.String key)
	{
		super(context);
		this.__awsConfig = awsConfig;
		this.__region = region;
		this.bucket = bucket;
		this.key = key;
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.awsConfig = __awsConfig == null ? null : amazons3connector.proxies.AwsConfig.initialize(getContext(), __awsConfig);

		this.region = __region == null ? null : amazons3connector.proxies.Region.initialize(getContext(), __region);

		// BEGIN USER CODE
		S3Client client = AmazonHelper.GetS3Client(awsConfig, region);
		DeleteObjectRequest req = DeleteObjectRequest.builder()
				.bucket(bucket)
				.key(key)
				.build();
		client.deleteObject(req);
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "DeleteObject";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}