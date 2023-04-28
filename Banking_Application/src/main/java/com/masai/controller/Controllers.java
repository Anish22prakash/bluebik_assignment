package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AccountException;
import com.masai.exception.UserException;
import com.masai.model.Account;
import com.masai.model.User;
import com.masai.service.ServiceImpl;

@RestController
public class Controllers {
	
	
	
	@Autowired
	private ServiceImpl service;
	
	
	
	@PostMapping("/createAccount")
	public ResponseEntity<Account> createAccountHandler(@RequestBody Account account)throws AccountException{
		 Account acc= service.createAccount(account);
		 
		 return new ResponseEntity<Account>(acc,HttpStatus.CREATED);
	}
	
	@PostMapping("/createUserAccount")
	public ResponseEntity<User> createUserAccountHandler(@RequestBody User user)throws UserException{
		 User us= service.createUserAccount(user);
		 
		 return new ResponseEntity<User>(us,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/creditBalanace/{user_id}/{bal}")
	public ResponseEntity<String> creditHandler(@PathVariable("user_id") Integer user_id,@PathVariable("bal") long bal)throws AccountException{
		String mesg=service.creditBalance(user_id, bal);
		
		return  new ResponseEntity<String>(mesg,HttpStatus.OK);
	}
	
	
	@GetMapping("/debitBalanace/{user_id}/{bal}")
	public ResponseEntity<String> debitHandler(@PathVariable("user_id") Integer user_id,@PathVariable("bal") long bal)throws AccountException{
		String mesg=service.debitBalance(user_id, bal);
		
		return  new ResponseEntity<String>(mesg,HttpStatus.OK);
	}

}
