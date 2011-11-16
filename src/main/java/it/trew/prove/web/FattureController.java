package it.trew.prove.web;

import java.util.List;

import it.trew.prove.model.beans.Fattura;
import it.trew.prove.server.services.FatturaService;
import it.trew.prove.server.services.UsersService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FattureController {

	@Autowired
	private UsersService userService;
	
	@Autowired
	private FatturaService fatturaService;
	
	private static final Logger logger = LoggerFactory.getLogger(FattureController.class);

		
	@RequestMapping( value = "/fatture" , method = RequestMethod.GET )
	public ModelAndView listUsers() {
		
		ModelAndView mav = new ModelAndView("fatture");
		
		List<Fattura> leFatture = fatturaService.listFatture();
		for (Fattura f : leFatture) {
			f.setUtente(userService.getByKey(f.getUtenteKey()));
		}
		
		mav.addObject("listaFatture", leFatture);
		
		mav.addObject("laFattura", new Fattura());
		
		return mav;
	}
	
	
}
