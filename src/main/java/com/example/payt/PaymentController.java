package com.example.payt;

import com.example.springwebdemon.RestResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵晓军
 * @since 2024/1/25
 */
@RestController
public class PaymentController {
    @Resource
    PaymentDomainServiceImpl paymentDomainService;

    @GetMapping("/pay")
    public RestResponse pay(@RequestParam("orderId") Long orderId) {
        paymentDomainService.pay(orderId);

        return RestResponse.success();
    }
}
