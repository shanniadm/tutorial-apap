package apap.tutorial.traveloke.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import apap.tutorial.traveloke.service.RoleService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/")
    public String home(Model model, HttpServletRequest req){
        model.addAttribute("listRole", roleService.findAll());
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
