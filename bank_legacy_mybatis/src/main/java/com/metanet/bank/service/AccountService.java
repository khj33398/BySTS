package com.metanet.bank.service;

import java.util.List;

import com.metanet.bank.dto.Account;

public interface AccountService {
	void makeAccount(Account acc) throws Exception;
	Account accountInfo(String id) throws Exception;
	void deposit(String id, int money) throws Exception;
	void withdraw(String id, int money) throws Exception;
	List<Account> accountList() throws Exception;
}
