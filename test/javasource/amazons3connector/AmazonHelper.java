package amazons3connector;

import org.apache.commons.lang.StringUtils;

import amazons3connector.proxies.AwsConfig;
import amazons3connector.proxies.S3CommonPrefix;
import amazons3connector.proxies.S3SummaryObject;

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
	
	public static void enhanceObject(S3SummaryObject o)
	{
		// create the folder structure
		String[] parts = o.getKey().split("/");
		// last item is the filename
		o.setFileName(parts[parts.length - 1]);
		int max = parts.length - 1; // excludes the final item
		if (parts.length > 1)
			o.setFolderPath(StringUtils.join(parts, "/", 0, max));
	}
	
	public static void enhancePrefix(S3CommonPrefix p)
	{
		// create the folder structure
		if (p.getPrefix() != null) {
			String[] parts = p.getPrefix().split("/");
			// last item is the foldername
			p.setFolderName(parts[parts.length - 1]);
			int max = parts.length - 1; // excludes the final item
			if (parts.length > 1) {
				p.setParentPrefix(StringUtils.join(parts, "/", 0, max));
				p.setParentFolderName(parts[max]);
			}
		}
	}
}