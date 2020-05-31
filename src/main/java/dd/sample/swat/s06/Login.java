package dd.sample.swat.s06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PropertySource("login.properties")
public class Login {
    private static final Logger logger = LoggerFactory.getLogger(Login.class);

    @Value("${admin}")
    private String admin;

    @Value("${admin.password}")
    private String adminPwd;

    @Value("${guest}")
    private String guest;

    @Value("${guest.password}")
    private String guestPwd;

    @PostMapping("/s06/login")
    public String login( //
            @RequestParam String user, //
            @RequestParam String password, //
            Model model) {
        logger.debug("Login attempt for user: " + user);

        model.addAttribute("user", user);
        if (user.equals(admin)) {
            if (password.equals(adminPwd)) {
                return "/s06/admin";
            }
        } else if (user.equals(guest) && password.equals(guestPwd)) {
            return "/s06/guest";
        }
        return "/s06/checkPassword";
    }
}
