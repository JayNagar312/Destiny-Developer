package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Form;
import com.entity.User;
import com.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService uservice;
	
//	@RequestMapping("/home")
//	public String home(Model model) {
//		System.out.println("This is Controller");
//
//		
//		model.addAttribute("name","Jay");
//		
//		return "home";
//	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		return "About";
	}

	@GetMapping("/Listing")
	public String listing() {
		return "Listing";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "signin";
	}
	
	@RequestMapping("/signup")
	public String signUp() {
		return "signup";
	}


	@RequestMapping(path="/SignUp",method = RequestMethod.GET)
	public String signUp(@RequestParam("user") String user, @RequestParam("mail") String mail, @RequestParam("pass") String pass, Model model) {
	
		User extUser=uservice.findUser(mail);
		if(extUser==null) {
			User newUser=new User();
			newUser.setUser(user);
			newUser.setMail(mail);
			newUser.setPass(pass);
			 
			uservice.saveUser(newUser);
			model.addAttribute("msg", "Sign Up successfull !");
			
			return "index";	
		}
		else {
			model.addAttribute("msg", "User Already Exist!");
			return "login";
		}
	}

	@RequestMapping(path="/SignIn",method = RequestMethod.GET)
	public String loginUser(@RequestParam("mail") String mail, @RequestParam("pass") String pass, Model model) {
		User usr = uservice.findUser(mail); 
		if (mail != null && usr.getPass().equals(pass)) {
			model.addAttribute("msg", "Login successful!"); 
			return "index"; // Redirect to a welcome page 
			} else {
				model.addAttribute("msg", "Invalid credentials!"); 
				return "login"; // Redirect back to login page
				}
	}
		
	@RequestMapping(path="/form", method =RequestMethod.GET)
	public String form(@RequestParam("name") String name, @RequestParam("mail") String mail,@RequestParam("msg") String msg, Model model) {
		if(mail != null && name != null) {
			Form frm=new Form();
			frm.setName(name);
			frm.setMail(mail);
			frm.setMsg(msg);
			
			uservice.saveForm(frm);
			model.addAttribute("msg", "Message sent successfully !");
		}
		else {
			model.addAttribute("msg","Please enter mail and name");
		}
	return "";
	}
}

