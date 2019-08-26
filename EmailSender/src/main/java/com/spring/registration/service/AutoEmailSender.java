package com.spring.registration.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.spring.registration.model.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AutoEmailSender {

	private final JavaMailSender mailSender;

	@Async
	public void sendMail(User user) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(user.getEmail());
		msg.setFrom("a@a");
		msg.setSubject("AutoSender test");
		msg.setText("");
		mailSender.send(msg);
	}
}