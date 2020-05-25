package dd.sample.swat.s02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/s02/hello")
    public String hello() {
        return "Hello";
    }
}
