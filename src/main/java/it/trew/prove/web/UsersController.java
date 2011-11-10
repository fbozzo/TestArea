package it.trew.prove.web;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

	@RequestMapping( value = "/users" , method = RequestMethod.GET )
	public ModelAndView listUsers(Locale locale) {
		
		ModelAndView mav = new ModelAndView("usersList");
		
		return mav;
	}
}
