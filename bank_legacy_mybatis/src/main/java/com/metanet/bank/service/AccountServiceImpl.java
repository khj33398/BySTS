package com.metanet.bank.service;

import java.util.List;

import com.metanet.bank.dao.AccountDAO;
import com.metanet.bank.dto.Account;

public class AccountServiceImpl implements AccountService {
	AccountDAO accountDAO;
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	@Override
	public void makeAccount(Account acc) throws Exception {
		accountDAO.insertAccount(acc);
	}

	@Override
	public Account accountInfo(String id) throws Exception {
		return accountDAO.selectAccount(id);
	}

	@Override
	public void deposit(String id, int money) throws Exception {
		Account acc = accountDAO.selectAccount(id);
		acc.deposit(money);
		accountDAO.updateAccount(acc);
		
	}

	@Override
	public void withdraw(String id, int money) throws Exception {
		Account acc = accountDAO.selectAccount(id);
		acc.withdraw(money);
		accountDAO.updateAccount(acc);
	}

	@Override
	public List<Account> accountList() throws Exception {
		return accountDAO.selectAll();
	}

}
