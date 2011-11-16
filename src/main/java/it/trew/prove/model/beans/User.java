package it.trew.prove.model.beans;

import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class User {

	@Id
	Long id;
	
	String firstName;
	String lastName;
	
	@NotEmpty
	@Size(min=3,max=20)
	String username;
	
	String passwordHash;
	
	public User() {
		
	}
	
	public User(String username) {
		super();
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
		
}
