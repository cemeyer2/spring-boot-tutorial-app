package com.example.springboottutorial.service;

import com.example.springboottutorial.configuration.SpringBootTutorialConfiguration;
import com.example.springboottutorial.model.Saying;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/hello-world")
@Service
public class HelloWorldService {

    private final SpringBootTutorialConfiguration configuration;
    private final AtomicLong counter;

    @Autowired
    public HelloWorldService(SpringBootTutorialConfiguration configuration) {
        this.configuration = configuration;
        this.counter = new AtomicLong();
    }

    @GetMapping
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(configuration.getTemplate(), name.orElse(configuration.getDefaultName()));
        return new Saying(counter.incrementAndGet(), value);
    }
}
