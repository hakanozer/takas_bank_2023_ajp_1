package com.works.configs;

import com.works.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Configuration
@RequiredArgsConstructor
public class AppBeans {

    final HttpServletRequest req;

    //@Bean
    public Customer customer() {
        Object customerObj = req.getSession().getAttribute("user");
        boolean status = customerObj == null;
        if (status) {
            return null;
        }
        Customer customer = (Customer) customerObj;
        return customer;
    }

}
