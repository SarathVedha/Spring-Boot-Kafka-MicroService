package com.vedha.stock.service.impl;

import com.vedha.common.dto.OrderEventDTO;
import com.vedha.stock.producer.KafkaProducer;
import com.vedha.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final KafkaProducer kafkaProducer;

    @Override
    public void processOrder(OrderEventDTO orderEventDTO) {

        orderEventDTO.setStatus("PROCESSED");
        orderEventDTO.setMessage("Order Processed SuccessFully");

        kafkaProducer.sendEmailMessage(orderEventDTO);

    }
}
