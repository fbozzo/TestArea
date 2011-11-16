package it.trew.prove.server.services;

import it.trew.prove.model.beans.Fattura;
import it.trew.prove.model.dao.FattureDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class FatturaService {

	@Autowired
	private FattureDao fattureDao;

		
	public List<Fattura> listFatture() {
		return fattureDao.list();
	}

	public void saveFattura(Fattura fattura) {
		fattureDao.add(fattura);
	}

}
