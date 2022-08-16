package io.github.jonathan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="PERSON")
public class PersonVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERSONID")
	private Integer personId;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PHONENUMBER")
	private String phoneNumber;
}
