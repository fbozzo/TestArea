package it.trew.prove.model.beans;

import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;

@Entity
public class Fattura {

	@Id
	Long id;
	
	@NotEmpty
	String numero;
	
	@Min(value=0)
	Double importo;
	
	@Transient User utente;
	Key<User> utenteKey;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public User getUtente() {
		return utente;
	}

	public void setUtente(User utente) {
		this.utente = utente;
	}

	public Key<User> getUtenteKey() {
		return utenteKey;
	}

	public void setUtenteKey(Key<User> utenteKey) {
		this.utenteKey = utenteKey;
	}
}
