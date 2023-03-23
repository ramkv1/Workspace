package com.rk.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	@Autowired
	private MessageStore store;
	
	@KafkaListener(topics = "${app.topic.name}",groupId = "grp1")
	public void readMessage(String message) {
		//add message to store
		store.addMessage(message);
	}
}
