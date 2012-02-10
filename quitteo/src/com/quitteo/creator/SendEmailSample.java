package com.quitteo.creator;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.*;
import com.amazonaws.services.simpleemail.model.*;

public class SendEmailSample {

	public static void main(String[] args) throws AmazonClientException {

		SendEmailRequest request = new SendEmailRequest().withSource("aws@quitteo.com");

		List<String> toAddresses = new ArrayList<String>();
		toAddresses.add("aws@quitteo.com");
		Destination dest = new Destination().withToAddresses(toAddresses);
		request.setDestination(dest);

		Content subjContent = new Content().withData("Test of Amazon SES");
		Message msg = new Message().withSubject(subjContent);

		// Include a body in both text and HTML formats
		Content textContent = new Content().withData("Hello - I hope you're having a good day.");
		Content htmlContent = new Content().withData("<h1>Hello - I hope you're having a good day.</h1>");
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
}
