package it.trew.prove.server.services;

import it.trew.prove.model.beans.User;

import java.util.List;

public interface UsersService {

	public List<User> listUsers();
	
	public void saveUser(User user);
}
