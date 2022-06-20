package com.metanet.bank.service;

import java.util.List;

import com.metanet.bank.dto.Account;

public interface AccountService {
	Account accountInfo(String id) throws Exception;
	
	List<Account> allAccountInfo() throws Exception;
	
	void makeAccount(Account acc) throws Exception;
	
	void deposit(String id, int money) throws Exception;
	
	void withdraw(String id, int money) throws Exception;
	
	boolean idoverlap(String id) throws Exception;
}
