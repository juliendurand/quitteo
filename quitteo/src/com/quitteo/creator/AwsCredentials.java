package com.quitteo.creator;

import java.io.IOException;
import java.util.Properties;

import com.amazonaws.auth.BasicAWSCredentials;

public class AwsCredentials {

	private static BasicAWSCredentials _awsCredentials;
	
	static {
		try {
			Properties properties = new Properties();
		    properties.load(AwsCredentials.class.getClassLoader().getResourceAsStream("AwsCredentials.properties"));
		    String accessKey = (String) properties.get("accessKey");
		    String secretKey = (String) properties.get("secretKey");
		    _awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private AwsCredentials(){
	}
	
	public static BasicAWSCredentials getCredentials(){
		return _awsCredentials;
	}

}
