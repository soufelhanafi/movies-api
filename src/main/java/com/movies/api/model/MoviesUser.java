/**
 * 
 */
package com.movies.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.SafeHtml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "movies_user")
public class MoviesUser extends AbstractBaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8389412028228051740L;

	@Column
	@Email
	@NotBlank(message = "email could not be empty")
	@Size(max = 100, message = "email should have atmost 100 characters")
	private String email;
	
	@Column
	@Size(max = 100, message = "password should have atmost 100 characters")
	@NotBlank(message = "password could not be empty")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Column
	@NotBlank(message = "firstName could not be empty")
	@Size(max = 100, message = "firstName should have atmost 100 characters")
	private String firstName;

	@Column
	@Size(max = 100, message = "middleNames should have atmost 100 characters")
	private String middleName;

	@Column
	@NotBlank(message = "lastName could not be empty")
	@Size(max = 100, message = "name should have atmost 100 characters")
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Civility civility;
	
	@Column
	@Size(max = 50, message = "phone should have atmost 50 characters")
	private String phone;
	
	@Column
	@Size(max = 250, message = "Address should have atmost 250 characters")
	private String address;

	@Column
	@Size(max = 30, message = "postal code should have atmost 30 characters")
	private String postalCode;

	@Column
	@Size(max = 30, message = "City should have atmost 30 characters")
	private String city;

	@Column
	@NotBlank(message = "Country could not be empty")
	@NotBlank(message = "country could not be empty")
	@Size(max = 30, message = "country should have atmost 100 characters")
	private String country;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date birthDate;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Civility getCivility() {
		return civility;
	}

	public void setCivility(Civility civility) {
		this.civility = civility;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
