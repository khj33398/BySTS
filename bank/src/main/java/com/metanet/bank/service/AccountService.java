package com.metanet.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metanet.bank.dto.Account;

public interface AccountService {
	Account accountInfo(String id) throws Exception;
	
	List<Account> allAccountInfo() throws Exception;
	
	void makeAccount(Account acc) throws Exception;
	
	void deposit(String id, int money) throws Exception;
	
	void withdraw(String id, int money) throws Exception;
}
