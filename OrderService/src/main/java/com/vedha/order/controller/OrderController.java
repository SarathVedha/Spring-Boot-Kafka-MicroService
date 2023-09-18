package com.vedha.order.controller;

import com.vedha.common.dto.OrderDTO;
import com.vedha.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
@Tag(name = "OrderController", description = "OrderController Handles Orders")
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Place Order", description = "Places Orders")
    @ApiResponse(responseCode = "200",description = "Http Status 200 Ok")
    @PostMapping(value = { "/place" }, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.ALL_VALUE })
    public ResponseEntity<String> makeOrder(@RequestBody OrderDTO orderDTO) {

        String result = orderService.makeOrder(orderDTO);

        return ResponseEntity.ok(result);
    }
}
