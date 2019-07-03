package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.Message;
@Component
public class MessageValidator implements Validator {

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Message.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Message ms=(Message)target;
		//to email validation
		if(!Pattern.matches(EMAIL_PATTERN, ms.getMailTo())) {
			errors.rejectValue("mailTo",null,"Please Enter Valid Email Address");
		}
		//cc email validation
		
		if(StringUtils.hasText(ms.getMailCcc())) {
		String[] cc=ms.getMailCcc().split(",");
		
		for(String cs:cc) {
			if(!Pattern.matches(EMAIL_PATTERN, cs)) {
				errors.rejectValue("mailCcc",null,"Please Enter Valid Email Address");
			}
		
			}
		}else {
			errors.rejectValue("mailCcc",null,"Please Enter Valid Email Address");
		}
		//bcc email validation
		if(StringUtils.hasText(ms.getMailBccc())) {
			String[] cc=ms.getMailCcc().split(",");
			
			for(String cs:cc) {
				if(!Pattern.matches(EMAIL_PATTERN, cs)) {
					errors.rejectValue("mailBccc",null,"Please Enter Valid Email Address");
				}
			
				}
			}else {
				errors.rejectValue("mailBccc",null,"Please Enter Valid Email Address");
			}
		// Subject validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mailSubject",null, "Please Enter Subject Here(min 10 char, max 255 car");
		
		if(!ms.getMailSubject().isEmpty()) {
		if(ms.getMailSubject().length()<10 || ms.getMailSubject().length()> 255) {
		errors.rejectValue("mailSubject",null, "Please Enter Subject Here(min 10 char, max 255 car");
		}
		}
			//https://examples.javacodegeeks.com/enterprise-java/spring/mvc/spring-mvc-textarea-example/
		
		// text validation
ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mailText",null, "Please Enter Subject Here(min 10 char, max 255 car");
		
		if(!ms.getMailText().isEmpty()) {
		if(ms.getMailText().length()<10 || ms.getMailText().length()> 500) {
		errors.rejectValue("mailText",null, "Please Enter Text Here(min 10 char, max 500 char");
		}
		}
		/*if(!Pattern.matches("[A-Z a-z 0-9\\s]{10,250}", ms.getMailText())) {
		errors.rejectValue("mailText",null,"Please Enter Text Here");
		}*/
	}

}
