package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Account;

public interface AccountDao extends JpaRepository<Account, Integer>{
	
	@Query(value = "select acc.account_id from Account as acc inner join User as us on acc.account_id=us.account  where us.user_id=?1")
	public Integer balanceCheck(Integer user_id);

}
