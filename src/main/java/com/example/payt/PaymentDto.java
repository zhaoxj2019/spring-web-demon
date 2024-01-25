package com.example.payt;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 赵晓军
 * @since 2024/1/25
 */
@Data
public class PaymentDto {
    String tradeNo;
    String payNo;
    BigDecimal payAmount;

    boolean success;
}
