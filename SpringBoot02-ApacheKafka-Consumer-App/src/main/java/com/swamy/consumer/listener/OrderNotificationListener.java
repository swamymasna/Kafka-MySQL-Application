package com.swamy.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swamy.model.Order;
import com.swamy.repository.OrderRepository;

@Service
public class OrderNotificationListener {

	@Value("${order.topic.name}")
	private String topicName;

	@Autowired
	OrderRepository orderRepository;

	@KafkaListener(topics = "order-topic1", groupId = "order-group1")
	public void listenGroupFoo(String message) throws Exception{
		
		System.out.println("Received Message in group foo: " + message);
		
		ObjectMapper object = new ObjectMapper();
		
		Order order = null;
		order = object.readValue(message, Order.class);
		
		
		
		System.out.println("###################################");
		System.out.println(order);
		System.out.println("###################################");
		
		orderRepository.save(order);

	}
}
