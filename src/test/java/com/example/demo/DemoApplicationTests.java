package com.example.demo;

import com.example.demo.jpa.User;
import com.example.demo.jpa.UserRepository;
import com.example.demo.mongodb.Customer;
import com.example.demo.mongodb.CustomerRepository;
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
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void contextLoads() {
        log.info("==============={}===============", "contextLoads");
    }

    @Test
    public void testJPA(){
        User user = new User();
        user.setUsername("lixiao");
        User saveUser = userRepository.save(user);
        log.info("{}", saveUser);
    }

    @Test
    public void testAMQP(){
        amqpTemplate.convertAndSend("hello","Hello World!") ;
    }

    @Test
    public void testMongoDB(){
        Customer customer = customerRepository.save(new Customer("Lance", "X"));
        log.info("{}", customer);
    }
}
