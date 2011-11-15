package it.trew.prove.web;

import it.trew.prove.model.beans.User;
import it.trew.prove.server.services.UsersService;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

	private final UsersService userService;

	@Autowired
	public UsersController(UsersService userService) {
		this.userService = userService;
	}
	
	@RequestMapping( value = "/users" , method = RequestMethod.GET )
	public ModelAndView listUsers() {
		
		ModelAndView mav = new ModelAndView("usersList");
		
		mav.addObject("utenti",	userService.listUsers());
		
		return mav;
	}
	
	
	@RequestMapping( value = "/users" , method = RequestMethod.POST )
	public ModelAndView saveUser(Locale locale, 
			@RequestParam(required=true) String username,
			@RequestParam String firstName,
			@RequestParam String lastName) {
				
		User user = new User(username);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		userService.saveUser(user);
		
		ModelAndView mav = this.listUsers();
		
		return mav;
	}
}
