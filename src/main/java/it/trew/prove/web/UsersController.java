package it.trew.prove.web;

import it.trew.prove.model.beans.User;
import it.trew.prove.server.services.UsersService;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

	@Autowired
	private UsersService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

		
	@RequestMapping( value = "/users" , method = RequestMethod.GET )
	public ModelAndView listUsers() {
		
		ModelAndView mav = new ModelAndView("usersList");
		
		User theUser = new User("defaultUsername");
		theUser.setFirstName("defaultFN");
		theUser.setLastName("defaultLN");
		mav.addObject("theUser", theUser);
		
		mav.addObject("utenti",	userService.listUsers());
		
		return mav;
	}
	
	
	@RequestMapping( value = "/users" , method = RequestMethod.POST )
	public ModelAndView saveUser(Locale locale, @Valid User user, BindingResult result) {
				
		if (result.hasErrors()) {
		
			for (ObjectError e : result.getAllErrors()) {
				logger.error("Errore form:: " + e.toString());
			}
			
		} else {
			
			logger.info("Utente salvato");
			userService.saveUser(user);
			
		}
		
		ModelAndView mav = this.listUsers();
		
		return mav;
	}
	
	
	@RequestMapping(value="/jsontest", method=RequestMethod.GET)
	public @ResponseBody List<User> getUserAsJson() {
		
		return userService.listUsers();
	}
}
