package it.trew.prove.server.services;

import it.trew.prove.model.beans.User;
import it.trew.prove.model.dao.UsersDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class UsersServiceImpl implements UsersService {

	private final UsersDao usersDao;

	@Autowired
	public UsersServiceImpl(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	@Override
	public List<User> listUsers() {
		return usersDao.list();
	}

	@Override
	public void saveUser(User user) {
		usersDao.add(user);
	}

}
