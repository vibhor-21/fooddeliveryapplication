package com.learning.fooddeliveryapp.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")}, name = "register")
public class Register {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int regId;
	
	@Size(max=50)
	@Email
	private String email;
	
	@Size(max=50)
	@NotBlank
	private String name;
	
	@Size(max=100)
	@NotBlank
	private String password;
	
	@NotBlank
	private String address;
	
	@OneToOne(mappedBy = "regId", cascade = CascadeType.ALL)
	@JsonIgnore
	private Login login;
	
}
