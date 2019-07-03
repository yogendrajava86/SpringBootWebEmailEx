package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Message;
import com.app.util.EmailUtil;
import com.app.validator.MessageValidator;

@Controller
@RequestMapping("/emails")
public class MessageController {
	
	@Autowired
	private EmailUtil util;
	
	@Autowired
	private MessageValidator validator;

	//1. show Email Template
	@RequestMapping("/compose")
	public String showTempl(ModelMap map) {
		map.addAttribute("message",new Message());
		map.addAttribute("msg","");
		return "EmailUi";
	}
	
	//2. Send Message 
	@RequestMapping(value="/sendmsg",method=RequestMethod.POST)
	public String sendMessage(@ModelAttribute Message message,@RequestParam("mailFile") MultipartFile file, Errors errors,ModelMap map) {
		
		validator.validate(message,errors);
		if(errors.hasErrors()) {
			map.addAttribute("msg","Please enter valid details!");
			map.addAttribute("message",message);
			return "EmailUi";
		}else {
			String[] cc=message.getMailCcc().split(",");
			String[] bcc=message.getMailBccc().split(",");
			//FileSystemResource file=new FileSystemResource("abcd.txt");
			boolean flag=util.send(message.getMailTo(), cc, bcc, message.getMailSubject(), message.getMailText(), file);
			if(flag) {map.addAttribute("msg","Email Sent Successfully!!!");
			map.addAttribute("message",new Message());
			}
			else { map.addAttribute("msg","Sorry, some issue occur. Please check!");}
			return "EmailUi";
		}
		
	}
}
