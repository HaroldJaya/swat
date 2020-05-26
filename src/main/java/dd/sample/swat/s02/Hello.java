package dd.sample.swat.s02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    private static Logger LOG = LoggerFactory.getLogger(Hello.class);

    @GetMapping("/s02/hello")
    public String hello() {
        LOG.trace("hello");
        return "Hello";
    }
}
