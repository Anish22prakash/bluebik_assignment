package com.masai.service;

import com.masai.exception.AccountException;
import com.masai.exception.UserException;
import com.masai.model.Account;
import com.masai.model.User;

public interface AllService {
	
	public Account createAccount(Account account)throws AccountException;
	public User createUserAccount(User user)throws UserException;
	public String creditBalance(Integer user_id,long bal)throws AccountException;
	public String debitBalance(Integer user_id,long bal)throws AccountException;
	

	

}
