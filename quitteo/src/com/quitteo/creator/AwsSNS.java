package com.quitteo.creator;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.simpleemail.*;
import com.amazonaws.services.simpleemail.model.*;

public class AwsSNS {

	public static void sendEmail(String from, String to, String title, String content) {
		SendEmailRequest request = new SendEmailRequest().withSource(from);

		List<String> toAddresses = new ArrayList<String>();
		toAddresses.add(to);
		Destination dest = new Destination().withToAddresses(toAddresses);
		request.setDestination(dest);

		Content subjContent = new Content().withData(title);
		Message msg = new Message().withSubject(subjContent);

		// Include a body in both text and HTML formats
		Content textContent = new Content().withData(content);
		Content htmlContent = new Content().withData(content);
		Body body = new Body().withHtml(htmlContent).withText(textContent);
		msg.setBody(body);

		request.setMessage(msg);

		// Set AWS access credentials
		AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient(AwsCredentials.getCredentials());

		// Call Amazon SES to send the message
		try {
			client.sendEmail(request);
		} catch (AmazonClientException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws AmazonClientException {

		String from = "aws@quitteo.com";
		String to = "aws@quitteo.com";
		String title = "Test";
		String content = "Hello - I hope you're having a good day.";
		
		sendEmail(from, to, title, content);
	}
}
