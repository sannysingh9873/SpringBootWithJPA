package com.jpa.example.SpringBootWithJPA.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

        @Bean
        ServletRegistrationBean h2servletRegistration(){
            ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
            registrationBean.addUrlMappings("/console/*");
            return registrationBean;
        }
    }

