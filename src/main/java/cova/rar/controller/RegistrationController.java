package cova.rar.controller;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import cova.rar.entities.User;
import cova.rar.service.CookieMonster;
import cova.rar.service.UserService;
import cova.rar.validator.UserValidator;

@Controller
public class RegistrationController {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	CookieMonster cookieMonster;
	
	 @InitBinder
	   protected void initBinder(WebDataBinder binder) {
	      binder.addValidators(userValidator);
	   }

	@GetMapping("/register")
	//@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map<String, Object> model) {
		User user = new User();    
        model.put("user", user);
        
		return "register";
	}
	
	
	// click on register button
	@PostMapping("/registerProcess")
	public String registerProcess(@ModelAttribute("user") @Validated User user, 
		      BindingResult bindingResult, Model model, HttpServletRequest request, HttpServletResponse response) {
		
	      if (bindingResult.hasErrors()) {
	    	 System.out.println("Validation has error!");
	    	 System.out.println(bindingResult.getFieldErrorCount());
	    	 
	    	 List<ObjectError> errors = bindingResult.getAllErrors();
	    	 for(ObjectError error:errors) {
	    		 System.out.println(error);
	    	 }
	    	 System.out.println();
	         return "register";
	      }

	      userService.register(user);
	      cookieMonster.setLoginCookie(request, response);
	      cookieMonster.setUserCookie(user, response);
	      return "redirect:home";
	}
}


