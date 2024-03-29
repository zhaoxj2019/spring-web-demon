package com.example.springwebdemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 赵晓军
 */
@SpringBootApplication(
        scanBasePackages = {"com.example"}
)
public class SpringWebDemonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebDemonApplication.class, args);
    }

}
