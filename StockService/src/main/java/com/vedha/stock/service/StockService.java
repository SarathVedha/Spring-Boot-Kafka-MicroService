package com.vedha.stock.service;

import com.vedha.common.dto.OrderEventDTO;

public interface StockService {

    void processOrder(OrderEventDTO orderEventDTO);
}
