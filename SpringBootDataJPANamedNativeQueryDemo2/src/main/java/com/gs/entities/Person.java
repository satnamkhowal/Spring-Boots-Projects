package com.gs.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "person_table")
@DynamicUpdate
/*
 * @NamedQueries(value = { @NamedQuery(name = "Person.getDetailByLastName",
 * query = "SELECT p FROM Person p WHERE p.lastName=?1"),
 * 
 * @NamedQuery(name = "Person.getByFirstNameAndEmail", query =
 * "SELECT p FROM Person p WHERE p.firstName=?1 and p.email=?2") })
 */
@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "Person.getDetailByLastName", query = "select * from person_table where last_name=?1", resultClass = Person.class),
		@NamedNativeQuery(name = "Person.getByFirstNameAndEmail", query = "select * from person_table where first_name=?1 and email=?2", resultClass = Person.class) })
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private int id;
	@Column(name = "first_name", length = 60, nullable = false)
	private String firstName;
	@Column(name = "last_name", length = 60, nullable = false)
	private String lastName;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "creation_date")
	private Date creationDate;

	public Person(String firstName, String lastName, String email, Date creationDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creationDate = creationDate;
	}

	public Person() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", creationDate=" + creationDate + "]";
	}

}
