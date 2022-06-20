package com.metanet.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metanet.jpa.dto.Account;
import com.metanet.jpa.model.AccountEntity;


public interface AccountService {
	Account accountInfo(String id) throws Exception;
	
	List<AccountEntity> allAccountInfo() throws Exception;
	
	void makeAccount(Account acc) throws Exception;
	
	void deposit(String id, int money) throws Exception;
	
	void withdraw(String id, int money) throws Exception;
}
