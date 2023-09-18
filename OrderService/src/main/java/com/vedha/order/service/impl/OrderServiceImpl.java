package com.vedha.order.service.impl;

import com.vedha.common.dto.OrderDTO;
import com.vedha.common.dto.OrderEventDTO;
import com.vedha.order.producer.KafkaOrderProducer;
import com.vedha.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final KafkaOrderProducer orderProducer;

    @Override
    public String makeOrder(OrderDTO orderDTO) {

        orderDTO.setId(UUID.randomUUID().toString());

        OrderEventDTO build = OrderEventDTO.builder().status("PENDING").message("Order Placed SuccessFully").orderDTO(orderDTO).build();

        orderProducer.sendStockMessage(build);

        orderProducer.sendEmailMessage(build);

        return "Order Placed SuccessFully";
    }
}
