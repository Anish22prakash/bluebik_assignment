package com.masai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	@Id
	private Integer user_id;
	private String name;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="account_id")
	private Account account;



	
	

}
