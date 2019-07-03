package com.app.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Message {

	private String mailTo;	
	private String mailCcc;
	private String mailBccc;
	private String mailSubject;
	private String mailText;
	private List<MultipartFile> mailFile;
	public Message() {
		super();
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	public String getMailCcc() {
		return mailCcc;
	}
	public void setMailCcc(String mailCcc) {
		this.mailCcc = mailCcc;
	}
	public String getMailBccc() {
		return mailBccc;
	}
	public void setMailBccc(String mailBccc) {
		this.mailBccc = mailBccc;
	}
	public String getMailSubject() {
		return mailSubject;
	}
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	public String getMailText() {
		return mailText;
	}
	public void setMailText(String mailText) {
		this.mailText = mailText;
	}
	public List<MultipartFile> getMailFile() {
		return mailFile;
	}
	public void setMailFile(List<MultipartFile> mailFile) {
		this.mailFile = mailFile;
	}
	@Override
	public String toString() {
		return "Message [mailTo=" + mailTo + ", mailCcc=" + mailCcc + ", mailBccc=" + mailBccc + ", mailSubject="
				+ mailSubject + ", mailText=" + mailText + ", mailFile=" + mailFile + "]";
	}
	
}
