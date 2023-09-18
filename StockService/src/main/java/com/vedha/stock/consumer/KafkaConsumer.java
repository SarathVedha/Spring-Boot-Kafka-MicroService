package com.vedha.stock.consumer;

import com.vedha.common.dto.OrderEventDTO;
import com.vedha.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final StockService stockService;

    @KafkaListener(topics = "${kafka.topic.json.order.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrder(OrderEventDTO orderEventDTO) {

        log.debug("Consumed Message From Kafka Order : " + orderEventDTO);

        stockService.processOrder(orderEventDTO);

    }
}
