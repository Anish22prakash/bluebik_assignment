package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.AccountDao;
import com.masai.dao.UserDao;
import com.masai.exception.AccountException;
import com.masai.exception.UserException;
import com.masai.model.Account;
import com.masai.model.User;


@Service
public class ServiceImpl implements AllService{
	
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Account createAccount(Account account) throws AccountException {
		
		return accountDao.save(account);
		
	}

	@Override
	public User createUserAccount(User user) throws UserException {
		
		return userDao.save(user);
		
	}

	@Override
	public synchronized String creditBalance(Integer user_id,long bal) throws AccountException {
		
		Integer account_id=accountDao.balanceCheck(user_id);
		   Optional<Account>opt=accountDao.findById(account_id);
		   if(opt.isPresent()) {
			   Account acc= opt.get();
			   acc.setBalance(acc.getBalance()+bal);
			   accountDao.save(acc);
			   
			   return "balanaced is credited in your account";
		   }
		   else {
			  throw new AccountException("balanced in not credit"); 
		   }
		
	}

	@Override
	public synchronized String debitBalance(Integer user_id,long bal) throws AccountException {
		
		Integer account_id=accountDao.balanceCheck(user_id);
		   Optional<Account>opt=accountDao.findById(account_id);
		   if(opt.isPresent()) {
			   Account acc= opt.get();
			   acc.setBalance(acc.getBalance()-bal);
			   accountDao.save(acc);
			   
			   return "balanaced is debited in your account";
		   }
		   else {
			  throw new AccountException("balanced in not debit"); 
		   }
		
	}

}
