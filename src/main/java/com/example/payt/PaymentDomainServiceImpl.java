package com.example.payt;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 支付领域域服务
 * @author 赵晓军
 */
@Slf4j
@Component
public class PaymentDomainServiceImpl {
    public void pay(Long orderId) {
        // 幂等性校验
        if (evenIs(orderId)) {
            return;
        }
        log.info("通过幂等校验");

        // 查找订单信息
        final String tradeNo = DateUtil.today() + "_" + orderId;
        BigDecimal payAmount = new BigDecimal("10");

        // 用业务信息 -> 模拟调用3方支付系统，产生付款信息
        PaymentDto paymentDto = this.call3Pay(tradeNo, payAmount);

        // 构建支付对象
        PaymentCmd cmd  = BeanUtil.copyProperties(paymentDto, PaymentCmd.class);
        if (paymentDto.success) {
            cmd.setCurrentStatus(PaymentStatus.PAYING);
            cmd.setTargetEvent(PaymentEvent.PAY_SUCCESS);
        } else {
            cmd.setCurrentStatus(PaymentStatus.PAYING);
            cmd.setTargetEvent(PaymentEvent.PAY_FAIL);
        }

        // 保存支付信息
        PaymentModel paymentModel = new PaymentModel(cmd);

        // 支付信息落库
        savePaymentModel(paymentModel);
    }

    private boolean evenIs(Long number) {
        return number % 2 == 0;
    }

    private PaymentDto call3Pay(String tradeNo, BigDecimal payAmount) {
        PaymentDto paymentDto = new PaymentDto();
        // 第三调用逻辑
        paymentDto.setTradeNo(tradeNo);
        paymentDto.setPayNo(UUID.randomUUID().toString());
        paymentDto.setPayAmount(payAmount);

        return paymentDto;
    }

    /**
     * 支付结果通知
     */
    public void notify(PaymentNotifyMessage message) {

    }

    private void savePaymentModel(PaymentModel paymentModel) {
        log.info("{}, 保存成功", paymentModel.getPaymentId());
    }


}
