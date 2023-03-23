package com.rk.sender;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReciver  {

	@JmsListener(destination = "mq1")
	public void showMessage(String text) {
		System.out.println("Message::"+text);
	}
}
