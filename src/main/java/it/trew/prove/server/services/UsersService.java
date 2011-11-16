package it.trew.prove.server.services;

import it.trew.prove.model.beans.Fattura;
import it.trew.prove.model.beans.User;
import it.trew.prove.model.dao.FattureDao;
import it.trew.prove.model.dao.UsersDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Key;

public class UsersService {

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private FattureDao fattureDao;
	
	public List<User> listUsers() {
		return usersDao.list();
	}

	public void saveUser(User user) {
		Key<User> nuovoUtente = usersDao.add(user);
		Fattura f = new Fattura();
		f.setNumero("12/2011");
		f.setImporto(123.45);
		f.setUtenteKey(nuovoUtente);
		fattureDao.add(f);
	}

	public User getByKey(Key<User> key) {
		try {
			return usersDao.get(key);
		} catch (EntityNotFoundException e) {
			return new User();
		}
	}
}
