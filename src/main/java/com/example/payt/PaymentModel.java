package com.example.payt;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 支付单模型
 * @author 赵晓军
 */
@Data
public class PaymentModel {
    /**
     * 其它所有字段省略
     */
    String tradeNo;
    String payNo;
    BigDecimal payAmount;
    Long paymentId;

    /**
     * 上次状态
     */
    private PaymentStatus lastStatus;

    /**
     * 当前状态
     */
    private PaymentStatus currentStatus;

    private PaymentModel() {
    }

    public PaymentModel(PaymentCmd cmd) {
        BeanUtil.copyProperties(cmd, this);
        // 状态流转
        this.transferStatusByEvent(PaymentEvent.valueOf(cmd.targetEvent.getEvent()));

        // 生成id
        this.paymentId = new Random().nextLong(1000L);
    }

    /**
     * 根据事件推进状态
     */
    public void transferStatusByEvent(PaymentEvent event) {
        // 根据当前状态和事件，去获取目标状态
        PaymentStatus targetStatus = PaymentStatus.getTargetStatus(currentStatus, event);
        // 如果目标状态不为空，说明是可以推进的
        if (targetStatus != null) {
            lastStatus = currentStatus;
            currentStatus = targetStatus;
        } else {
            // 目标状态为空，说明是非法推进，进入异常处理，这里只是抛出去，由调用者去具体处理
            throw new StateMachineException(currentStatus, event, "状态转换失败");
        }
    }
}
