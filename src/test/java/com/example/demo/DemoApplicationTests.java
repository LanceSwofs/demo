package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUsername("lixiao");
        User save = userRepository.save(user);
        log.info("=============================={}", save);
        amqpTemplate.convertAndSend("Hello World!") ;
    }

}
