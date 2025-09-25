package com.nit.subscriber;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nit.model.IndianFestival;

@Component
public class KafkaMessageSubscriber {
	
	private IndianFestival festival;
	
	@KafkaListener(topics = "${app.tpc.name}" , groupId = "grp1")
	public void readMessage(IndianFestival festivel) {
		this.festival=festivel;
		System.out.println("message is ::"+festivel);
				
	}
	public IndianFestival getCurrentMessage() {
		return festival;
	}

}
