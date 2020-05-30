package dd.sample.swat.s03;

import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HelloTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    private String actual;

    @BeforeEach
    void getActual() {
        String url = "http://localhost:" + port + "/s02/hello";
        actual = template.getForObject(url, String.class);
    }

    @Test
    void helloHamcrest() {
        MatcherAssert.assertThat(actual, is("Hello"));
    }

    @Test
    void helloAssertJ() {
        Assertions.assertThat(actual).isEqualTo("Hello");
    }
}
