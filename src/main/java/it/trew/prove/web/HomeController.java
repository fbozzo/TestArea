package it.trew.prove.web;

import it.trew.prove.model.beans.User;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale) {
		
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		ModelAndView mav = new ModelAndView("home");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		mav.addObject( "serverTime", formattedDate );
		
		return mav;
	}
	
	
	@RequestMapping(value="/jsontest", method=RequestMethod.GET)
	public @ResponseBody User getUserAsJson() {
		
		User jsonUser = new User();
		jsonUser.setFirstName("Mickey");
		jsonUser.setLastName("Mouse");
		jsonUser.setUsername("mmous");
		
		
		return jsonUser;
	}
	
}
