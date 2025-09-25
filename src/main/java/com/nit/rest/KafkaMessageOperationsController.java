package com.nit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.IndianFestival;
import com.nit.publisher.KafkaMessageSender;
import com.nit.subscriber.KafkaMessageSubscriber;

@RestController
@RequestMapping("/message-api")
public class KafkaMessageOperationsController {
	
	@Autowired
	private KafkaMessageSender sender;
	@Autowired
	private KafkaMessageSubscriber subscriber;
	
	//end points
	@PostMapping("/send")
	public ResponseEntity<String> pushMessage(@RequestBody IndianFestival festival){
		//send the message
		String msg=sender.sendMessage(festival);
		//return ResponseEntity obj
		return new ResponseEntity<String>(msg , HttpStatus.OK);
		
	}
	@GetMapping("/read")
	public ResponseEntity<IndianFestival> readMessage(){
		//read message
		IndianFestival festival = subscriber.getCurrentMessage();
		//return ResponseEntity obj
		return new ResponseEntity<IndianFestival>(festival , HttpStatus.OK);
	}
	

}
