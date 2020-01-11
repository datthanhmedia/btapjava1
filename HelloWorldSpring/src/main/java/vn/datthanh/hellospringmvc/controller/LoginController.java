package vn.datthanh.hellospringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class LoginController {
 
    @RequestMapping("/login")
    public String login(Model model) {
        
      
    	 model.addAttribute("greeting", "Hello Spring MVC");
        return "login";
        
    }
 
}
