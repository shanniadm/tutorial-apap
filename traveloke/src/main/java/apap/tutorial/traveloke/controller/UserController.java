package apap.tutorial.traveloke.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public String addUserSubmit(@ModelAttribute UserModel user, Model model){
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @RequestMapping(value="/updatePassword")
    private String updatePassword(Model model){
        return "form-update-password";
    }

    @RequestMapping(value="/updatePassword", method = RequestMethod.POST)
    private String updatePasswordSubmit(HttpServletRequest req, Model model){
        String passLama = req.getParameter("passLama");
        String passBaru1 = req.getParameter("passBaru");
        String passBaru2 = req.getParameter("passConfirm");
        UserModel user = userService.findUser(req.getRemoteUser());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(passLama, user.getPassword()) && passBaru1.equals(passBaru2) && userService.validatePass(passBaru1)){
            userService.updatePassword(user, passBaru1);
            model.addAttribute("message", user.getUsername() + ", password kamu telah berhasil diperbaharui!");
        } else {
            model.addAttribute("message", "Password gagal diperbaharui, cek kembali passwordmu!");
        }
        return "update-password";
    }
}
