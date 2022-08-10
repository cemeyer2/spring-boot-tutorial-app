package com.example.springboottutorial.resource;

import com.example.springboottutorial.configuration.SpringBootTutorialConfiguration;
import com.example.springboottutorial.model.Saying;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    private final SpringBootTutorialConfiguration configuration;
    private final AtomicLong counter;

    @Autowired
    public HelloWorldResource(SpringBootTutorialConfiguration configuration) {
        this.configuration = configuration;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(configuration.getTemplate(), name.orElse(configuration.getDefaultName()));
        return new Saying(counter.incrementAndGet(), value);
    }
}
