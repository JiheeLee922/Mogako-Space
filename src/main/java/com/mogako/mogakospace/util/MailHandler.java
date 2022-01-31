package com.mogako.mogakospace.util;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailHandler {
	
	private JavaMailSender sender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;	// spring���� �����ϴ� ���� ��ü. HTML���̾ƿ�, �̹�������, ÷������ �� MIME �޼��� �ۼ�����
	
	//������
	public MailHandler(JavaMailSender jsender) throws MessagingException {
		this.sender = jsender;
		message = jsender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	}
	
	//�̸��� ���� set
	public void setFrom(String fromAddress) throws MessagingException {
		messageHelper.setFrom(fromAddress);
	}
	public void setTo(String email) throws MessagingException {
		messageHelper.setTo(email);
	}
	public void setSubject(String subject) throws MessagingException {
		messageHelper.setSubject(subject);
	}
	public void setText(String text, boolean useHtml) throws MessagingException {
		messageHelper.setText(text, useHtml);
	}
	
	//÷������
	public void setAttach(String displayFileName , String pathToAttachment) //���Ͽ� ����� ���, ���� ���� ��ġ 
			throws MessagingException, IOException {
		File file = new ClassPathResource(pathToAttachment).getFile();
		FileSystemResource fsr = new FileSystemResource(file);
		
		messageHelper.addAttachment(displayFileName, fsr); 
	}
	
	//�̹�������
	public void setInline(String contentId, String pathToInline) throws MessagingException, IOException {
		File file = new ClassPathResource(pathToInline).getFile();
		FileSystemResource fsr = new FileSystemResource(file);
		
		messageHelper.addInline(contentId, fsr);
	}
	
	//�߼�
	public void send() {
		try {
			sender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
