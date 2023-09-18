package com.vedha.order.producer;

import com.vedha.common.dto.OrderEventDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaOrderProducer {

    private final KafkaTemplate<String, OrderEventDTO> kafkaTemplate;

    @Value("${kafka.topic.json.order.name}")
    private String orderTopicName;

    @Value("${kafka.topic.json.email.name}")
    private String emailTopicName;

    public void sendStockMessage(OrderEventDTO orderEventDTO) {

        log.debug("Order Event To Kafka Order Topic Stock Service : " + orderEventDTO);

        Message<OrderEventDTO> message = MessageBuilder.withPayload(orderEventDTO).setHeader(KafkaHeaders.TOPIC, orderTopicName).build();

        kafkaTemplate.send(message);
    }

    public void sendEmailMessage(OrderEventDTO orderEventDTO) {

        log.debug("Order Event To Kafka Email Topic Email Service : " + orderEventDTO);

        Message<OrderEventDTO> message = MessageBuilder.withPayload(orderEventDTO).setHeader(KafkaHeaders.TOPIC, emailTopicName).build();

        kafkaTemplate.send(message);

    }
}
