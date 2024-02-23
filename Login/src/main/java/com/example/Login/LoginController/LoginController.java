package com.example.Login.LoginController;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.Login.Logindomain.Login;
import com.example.Login.Loginservices.Loginservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	    @Autowired
	    private Loginservice userService;
	                                    
	    @GetMapping("/login")
	           
	    public ModelAndView login() {
	        ModelAndView mav = new ModelAndView("login");
	        mav.addObject("user", new Login());
	        return mav;
	    }
	    
	    @PostMapping("/login")
	    public String login(@ModelAttribute("user") Login user ) {
	        
	        Login oauthUser = userService.login(user.getUsername(), user.getPassword());
	        
	        System.out.print(oauthUser);
	        if(oauthUser == null)
	        {
	        	System.out.println("oauthuser is null");
	        	return "redirect:/invalid";
	        }
	        else {
	        	System.out.println("Invalid");
	            return "redirect:";
	        }
	       
	}
	    
	    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
	    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
	    {
	        return "redirect:/login";
	    }
	    
	    
	    @GetMapping("/invalid")
        
	    public ModelAndView invalidView() {
	        ModelAndView mav = new ModelAndView("invalid");
	        return mav;
	    }
}

