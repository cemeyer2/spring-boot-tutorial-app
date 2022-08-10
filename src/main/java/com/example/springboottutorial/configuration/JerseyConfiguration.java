package com.example.springboottutorial.configuration;

import com.example.springboottutorial.resource.HelloWorldResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api/v1")
@Configuration
public class JerseyConfiguration  extends ResourceConfig {

    public JerseyConfiguration() {
        super(HelloWorldResource.class);
    }


    //so you can configure it here if you want to
    @Bean
    public ObjectMapper getObjectMapper() {
        return new Jackson2ObjectMapperBuilder().build();
    }
}
