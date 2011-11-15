package it.trew.prove.web;

import it.trew.prove.model.beans.User;
import it.trew.prove.server.services.UsersService;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

	private final UsersService userService;
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

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
	public ModelAndView saveUser(Locale locale, @Valid User user, BindingResult result) {
				
		if (result.hasErrors()) {
		
			logger.error("Errori form:: " + result.getErrorCount());
			
		} else {
			
			logger.info("Utente salvato");
			userService.saveUser(user);
			
		}
		
		ModelAndView mav = this.listUsers();
		
		return mav;
	}
}
