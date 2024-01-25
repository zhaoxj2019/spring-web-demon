package com.example.payt;

import lombok.Data;

/**
 * @author 赵晓军
 * @since 2024/1/25
 */
@Data
public class PaymentNotifyMessage {
    Long paymentId;
    PaymentEvent paymentEvent;

    public String getEvent() {
        return paymentEvent.getEvent();
    }

}
