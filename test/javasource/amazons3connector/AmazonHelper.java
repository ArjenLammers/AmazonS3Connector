package amazons3connector;

import amazons3connector.proxies.AwsConfig;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

public class AmazonHelper
{
	public static AmazonS3 GetS3Client(AwsConfig config) {
		BasicAWSCredentials credentials = new BasicAWSCredentials(
				config.getAccessKey(), config.getSecretKey());
		
		return new AmazonS3Client(credentials);
	}
}