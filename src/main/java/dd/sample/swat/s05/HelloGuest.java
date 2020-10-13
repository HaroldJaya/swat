package dd.sample.swat.s05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloGuest {
    private static Logger LOG = LoggerFactory.getLogger(HelloGuest.class);

    @GetMapping("/s05/guest")
    public String guest( //
            @RequestParam(name = "user") String user, //
            Model model) {
        if (user.isEmpty() || user.isBlank()) {
            user = "Anonymous";
        }
        LOG.trace("hello guest named " + user);
        model.addAttribute("user", user);
        return "/s05/guest";
    }

    @GetMapping("/s05/guest2")
    public String guest2( //
            @RequestParam(required = false) String user, //
            Model model) {
        if (user == null || user.isBlank()) {
            LOG.debug("no name passed for user, using default instead");
            user = "Anonymous";
        }
        LOG.trace("hello guest named " + user);
        model.addAttribute("user", user);
        return "/s05/guest";
    }

    @GetMapping("/s05/guest3")
    public String guest3( //
            @RequestParam(defaultValue = "Anonymous") String user, //
            Model model) {
        LOG.trace("hello guest named " + user);
        model.addAttribute("user", user);
        return "/s05/guest";
    }

}
