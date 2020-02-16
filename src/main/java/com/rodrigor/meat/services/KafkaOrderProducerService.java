package com.rodrigor.meat.services;

import org.apache.kafka.clients.producer.internals.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rodrigor.meat.domain.OrderPurchase;

@Service
public class KafkaOrderProducerService {

	@Value("${spring.kafka.order.request.topic}")
	private String orderRequestTopic;
	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	public void sendMessage(OrderPurchase payload) {
		String orderJsonRequest;
		try {
			orderJsonRequest = mapper.writeValueAsString(payload);
			ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(orderRequestTopic, orderJsonRequest);
			
			future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

				@Override
				public void onSuccess(SendResult<String, String> result) {
					LOGGER.info("sent message='{}' with offset={}", orderJsonRequest, result.getRecordMetadata().offset());
				}

				@Override
				public void onFailure(Throwable ex) {
					LOGGER.error("unable to send message='{}'", orderJsonRequest, ex);
				}
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

}
