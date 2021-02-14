package com.ebi.personhandler.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @SuppressWarnings("rawtypes")
    ServletRegistrationBean h2servletRegistration(){
		ServletRegistrationBean registration = new ServletRegistrationBean( new org.h2.server.web.WebServlet());
        registration.addUrlMappings("/console/*");
        registration.addInitParameter("webAllowOthers", "true");
        registration.addInitParameter("webPort", "8080");

        return registration;
    }
}
