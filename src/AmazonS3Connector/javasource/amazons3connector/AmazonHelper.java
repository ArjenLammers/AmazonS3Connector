package amazons3connector;

import java.util.Date;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;

import amazons3connector.proxies.AwsConfig;
import amazons3connector.proxies.S3Object;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sts.StsClient;

public class AmazonHelper
{
	
	public final static ILogNode LOGGER = Core.getLogger("S3");
	
	public static StsClient GetStsClient(AwsConfig config) throws CoreException {
		
		AwsBasicCredentials credentials = AwsBasicCredentials.create(
				config.getAccessKey(), config.getSecretKey());
		Region region = Region.of(config.getSelectedRegion().getName());
		return StsClient.builder().credentialsProvider(
				StaticCredentialsProvider.create(credentials))
				.httpClientBuilder(ApacheHttpClient.builder())
				.region(region)
				.build();
	}
	
	public static S3Client GetS3Client(AwsConfig config, amazons3connector.proxies.Region mxRegion) throws CoreException {
		AwsBasicCredentials credentials = AwsBasicCredentials.create(
				config.getAccessKey(), config.getSecretKey());
		Region region = Region.of(mxRegion.getName());
		
		return S3Client.builder().credentialsProvider(
				StaticCredentialsProvider.create(credentials))
				.region(region)
				.build();
	}
	
	public static S3Client GetS3Client(AwsConfig config) throws CoreException {
		return GetS3Client(config, config.getSelectedRegion());
	}
	
	public static S3Object getMxS3Object(IContext context, software.amazon.awssdk.services.s3.model.S3Object obj, String bucket) {
		S3Object mxObj = new S3Object(context);
		mxObj.setKey(obj.key());
		mxObj.setLastChanged(new Date(obj.lastModified().toEpochMilli()));
		mxObj.setStorageClass(obj.storageClass().toString());
		mxObj.setSize(obj.size());
		mxObj.setBucket(bucket);
		return mxObj;
	}
	
	public static String getFilenameFromKey(String key) {
		int lastIndex = key.lastIndexOf('/');
		if (lastIndex != -1) {
			return key.substring(key.lastIndexOf('/'));
		} else {
			return key;
		}
	}
}