package com.swamy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swamy.model.Order;
import com.swamy.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Value("${order.topic.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	ObjectMapper om=new ObjectMapper();

	public Order createOrder(Order order) {

		order =orderRepository.save(order);

		String message = null;
		try {
			message = om.writeValueAsString(order);
		} catch (Exception e) {
			e.printStackTrace();
		}

		kafkaTemplate.send(topicName,message);

		return order;
	}

	public List<Order> getAllOrders() {
		return (List<Order>) orderRepository.findAll();

	}
}
