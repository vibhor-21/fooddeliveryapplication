package com.learning.fooddeliveryapp.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="register")
public class User 
{
	
	@Email // giving the email constraint 
	@NotNull
	private String email;
	
	@NotNull
	@Size(max=40)
	private String username;
	
	@Size(min=8)
	@NotNull
	private String password;
	
	@Size(max=100)
	@NotNull
	private String address;
	
	@Id  // making regId as primary key
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long Id;
	
	
	
//	  @JsonSerialize(using=CustomListSerializer.class)
//	  @OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
//	  private Login login;
	
	@ManyToMany(fetch =FetchType.LAZY)
	@JoinTable(name="User_roles",joinColumns = @JoinColumn(name="regId"),
	inverseJoinColumns=@JoinColumn(name="roleId"))
	
	private Set<Role> roles = new HashSet<>();
	  
	  public User(String username,String email,String password,String address) {
			
			this.username = username;
			this.email = email;
			this.password = password;
			this.address=address;
		}
		

}



