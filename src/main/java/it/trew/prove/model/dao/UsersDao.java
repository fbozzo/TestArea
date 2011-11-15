package it.trew.prove.model.dao;

import it.trew.prove.model.beans.User;

import com.googlecode.objectify.ObjectifyService;

public class UsersDao extends ObjectifyDao<User> {

	public UsersDao() {
		super(User.class);
	}

	static {
		ObjectifyService.register(User.class);
	}
	
}
