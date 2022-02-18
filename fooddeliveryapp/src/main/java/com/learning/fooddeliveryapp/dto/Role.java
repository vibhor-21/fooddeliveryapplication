package com.learning.fooddeliveryapp.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Role {
	
	@Id //Id must be auto generated
	@GeneratedValue(strategy = GenerationType.AUTO) //auto increment
	private int roleId;
	
	//it should be the value from available Enums
	
	@Enumerated(EnumType.STRING) 
	@Column(length = 30)
	private EROLE roleName; 

}