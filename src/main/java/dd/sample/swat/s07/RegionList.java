package dd.sample.swat.s07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegionList {
    @Autowired
    private RegionRepository repo;

    private static final Logger LOG = LoggerFactory.getLogger(RegionList.class);

    @GetMapping("/s07/regions")
    public String list(Model model) {
        LOG.trace("listing all regions");

        Iterable<Region> regions = repo.findAll();
        model.addAttribute("regions", regions);

        return "/s07/regions";
    }

}
