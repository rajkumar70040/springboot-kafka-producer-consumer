package com.nit.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.nit.model.IndianFestival;

@Component
public class KafkaMessageSender {
	@Autowired
	private KafkaTemplate<String, IndianFestival> template;
	@Value("${app.tpc.name}")
	private String topicName;
	
	public String sendMessage(IndianFestival festival) {
		template.send(topicName, "festival Info" , festival);
		return "message sent";
	}

}
