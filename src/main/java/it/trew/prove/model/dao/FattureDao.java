package it.trew.prove.model.dao;

import it.trew.prove.model.beans.Fattura;

import com.googlecode.objectify.ObjectifyService;

public class FattureDao extends ObjectifyDao<Fattura> {

	public FattureDao() {
		super(Fattura.class);
	}

	static {
		ObjectifyService.register(Fattura.class);
	}
	
}
