package com.netmusic.common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NaverMail {

	public void naverMail(	String mailSubject,
							String sendMail,
							String sendPw,
							String reciveMail,
							String sendMsg) {
		
		String host = "smtp.naver.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정 
		String user = "netmusic93@naver.com"; 
		String password = "sptabwlr93"; 
		
		// SMTP 서버 정보를 설정한다. 
		Properties props = new Properties(); 
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", 587); 
		props.put("mail.smtp.auth", "true"); 
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() { 
			protected PasswordAuthentication getPasswordAuthentication() { 
				return new PasswordAuthentication(user, password); 
			} 
		}); 
		
		try { 
			MimeMessage message = new MimeMessage(session); 
			message.setFrom(new InternetAddress(user));
			message.addRecipient(
					Message.RecipientType.TO, 
					new InternetAddress(reciveMail)
			); 
			// 메일 제목 
			message.setSubject(mailSubject); 
			// 메일 내용
			message.setText(sendMsg); 
			
			// send the message
			Transport.send(message); 
			System.out.println("Success Message Send"); 
			
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
	}
}
