package com.rk.consumer;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.common.protocol.types.Field.Str;
import org.springframework.stereotype.Component;

@Component
public class MessageStore {
	private List<String> listMessages=new ArrayList<String>();
	
	public void addMessage(String message) {
		listMessages.add(message);
	}
	
	public String getAllMessages() {
		return listMessages.toString();
	}
}
