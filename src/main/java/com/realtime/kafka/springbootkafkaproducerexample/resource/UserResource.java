package com.realtime.kafka.springbootkafkaproducerexample.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realtime.kafka.springbootkafkaproducerexample.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {
	
	@Autowired
	private KafkaTemplate<String, User> KafkaTemplate;
	private static final String TOPIC = "Kafka_Example";
	
	@GetMapping("/publish/{id}")
	public String post(@PathVariable("id") final int id) {
		
		KafkaTemplate.send(TOPIC, new User(id, "Naveen", "Technology"));
		
		return "Published Successfully";
	}

}
