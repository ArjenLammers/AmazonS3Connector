// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package amazons3connector.actions;

import amazons3connector.AmazonHelper;
import amazons3connector.proxies.S3CommonPrefix;
import amazons3connector.proxies.S3SummaryObject;
import amazons3connector.proxies.constants.Constants;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class JAV_GetObjects extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject __AwsConfigParam;
	private amazons3connector.proxies.AwsConfig AwsConfigParam;
	private IMendixObject __S3BucketParam;
	private amazons3connector.proxies.S3Bucket S3BucketParam;
	private java.util.List<IMendixObject> __S3Objects;
	private java.util.List<amazons3connector.proxies.S3SummaryObject> S3Objects;
	private java.util.List<IMendixObject> __S3CommonPrefixes;
	private java.util.List<amazons3connector.proxies.S3CommonPrefix> S3CommonPrefixes;
	private IMendixObject __S3CommonPrefixParam;
	private amazons3connector.proxies.S3CommonPrefix S3CommonPrefixParam;

	public JAV_GetObjects(IContext context, IMendixObject AwsConfigParam, IMendixObject S3BucketParam, java.util.List<IMendixObject> S3Objects, java.util.List<IMendixObject> S3CommonPrefixes, IMendixObject S3CommonPrefixParam)
	{
		super(context);
		this.__AwsConfigParam = AwsConfigParam;
		this.__S3BucketParam = S3BucketParam;
		this.__S3Objects = S3Objects;
		this.__S3CommonPrefixes = S3CommonPrefixes;
		this.__S3CommonPrefixParam = S3CommonPrefixParam;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.AwsConfigParam = __AwsConfigParam == null ? null : amazons3connector.proxies.AwsConfig.initialize(getContext(), __AwsConfigParam);

		this.S3BucketParam = __S3BucketParam == null ? null : amazons3connector.proxies.S3Bucket.initialize(getContext(), __S3BucketParam);

		this.S3Objects = new java.util.ArrayList<amazons3connector.proxies.S3SummaryObject>();
		if (__S3Objects != null)
			for (IMendixObject __S3ObjectsElement : __S3Objects)
				this.S3Objects.add(amazons3connector.proxies.S3SummaryObject.initialize(getContext(), __S3ObjectsElement));

		this.S3CommonPrefixes = new java.util.ArrayList<amazons3connector.proxies.S3CommonPrefix>();
		if (__S3CommonPrefixes != null)
			for (IMendixObject __S3CommonPrefixesElement : __S3CommonPrefixes)
				this.S3CommonPrefixes.add(amazons3connector.proxies.S3CommonPrefix.initialize(getContext(), __S3CommonPrefixesElement));

		this.S3CommonPrefixParam = __S3CommonPrefixParam == null ? null : amazons3connector.proxies.S3CommonPrefix.initialize(getContext(), __S3CommonPrefixParam);

		// BEGIN USER CODE
		AmazonS3 s3client = AmazonHelper.GetS3Client(AwsConfigParam);

		ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
			.withBucketName(S3BucketParam.getName())
			.withDelimiter(Constants.getHierarchyDelimiter());
		
		if (S3CommonPrefixParam != null) {
			listObjectsRequest.withPrefix(S3CommonPrefixParam.getPrefix());
			
			AmazonHelper.enhancePrefix(S3CommonPrefixParam);
		}
		ObjectListing objectListing;
		
		do {
			objectListing = s3client.listObjects(listObjectsRequest);
			for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
				// create the objects
				S3SummaryObject o = new S3SummaryObject(getContext());
				o.setKey(os.getKey());
				o.setS3Object_S3Bucket(S3BucketParam);
				S3Objects.add(o);
				
				AmazonHelper.enhanceObject(o);
			}
			for (String commonPrefix : objectListing.getCommonPrefixes()) {
				// create the common prefixes
				S3CommonPrefix p = new S3CommonPrefix(getContext());
				p.setPrefix(commonPrefix);
				p.setS3CommonPrefix_S3Bucket(S3BucketParam);
				S3CommonPrefixes.add(p);
				
				AmazonHelper.enhancePrefix(p);
			}
			
			listObjectsRequest.setMarker(objectListing.getNextMarker());
		} while (objectListing.isTruncated());

		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "JAV_GetObjects";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
