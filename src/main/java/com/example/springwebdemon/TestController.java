package com.example.springwebdemon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵晓军
 * @since 2024/1/18
 */
@Slf4j
@RestController
public class TestController {
    @GetMapping("/publishEvent")
    public void publishEvent() {
        log.info("ok");
    }

}
