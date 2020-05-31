package dd.sample.swat.s04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloThymeleaf {
    private static Logger LOG = LoggerFactory.getLogger(HelloThymeleaf.class);

    @GetMapping("/s04/hello")
    public String hello() {
        LOG.trace("hello thymeleaf");
        return "/s04/hello";
    }
}
