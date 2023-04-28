package com.masai.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
	
	
	@Id
	private Integer account_id;
	private long balance;
	
	
 
	

}
