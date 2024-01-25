package com.zxj.springframwork;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 赵晓军
 * @since 2024/1/18
 */
@Slf4j
@RestController
public class TestController {
    @Resource
    ApplicationContext applicationContext;

    public void publishEvent() {
        Person person = new Person("why");
        applicationContext.publishEvent(new PersonEvent(person, "add"));
    }
}
