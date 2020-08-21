package com.kmit.Gmail_skill;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Hello world!
 *
 */
public class App 
{
   
    public static void sendMail(String str) {
        //Setting up configurations for the email connection to the Google SMTP server using TLS
        Properties props = new Properties();
        System.out.println("TSLEmail Start");

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
        //Establishing a session with required user details
        Session session = Session.getInstance(props, new javax.mail.Authenticator() 
        {	
        	String userName="senders mail",password="senders passwrod";
        	  protected PasswordAuthentication getPasswordAuthentication() {
        	        return new PasswordAuthentication(userName, password);
        	    }
        });
        try {
            //Creating a Message object to set the email content
            MimeMessage msg = new MimeMessage(session);
            //Storing the coma seperated values to email addresses
            String to = "senders gmail,recievers gmail ";
            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
            addresses in an array of InternetAddress objects*/
            InternetAddress[] address = InternetAddress.parse(to, true);
            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
            msg.setSubject("Sample Mail : " + timeStamp);
          
            msg.setText("Sample System Generated mail");
           
            Transport.send(msg);
            System.out.println("Mail has been sent successfully");
        	}
        catch (MessagingException mex) 
        {
            System.out.println("Unable to send an email");
        }
    }

}


