package com.vedha.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "OrderDTO", description = "Order")
public class OrderDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;

    private String name;

    private int quantity;

    private double price;
}
