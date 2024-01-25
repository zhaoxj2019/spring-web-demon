package com.example.payt;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 赵晓军
 * @since 2024/1/25
 */
@Data
@AllArgsConstructor
public class StateMachineException extends RuntimeException {
    PaymentStatus paymentStatus;
    PaymentEvent paymentEvent;
    String msg;

}
