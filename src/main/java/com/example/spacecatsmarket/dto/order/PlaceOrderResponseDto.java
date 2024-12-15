package com.example.spacecatsmarket.dto.order;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class PlaceOrderResponseDto {

    String orderId;
    UUID transactionId;
}
