package com.vedha.email.consumer;

import com.vedha.common.dto.OrderEventDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.topic.json.email.name}", groupId = "${spring.kafka.consumer.group-id}")
    private void consumerMessage(OrderEventDTO orderEventDTO) {

        log.debug("Message From Kafka Email Topic : " + orderEventDTO);
    }
}
