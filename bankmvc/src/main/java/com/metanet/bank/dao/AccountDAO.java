package com.metanet.bank.dao;

import java.util.List;

import com.metanet.bank.dto.Account;

public interface AccountDAO {
	void insertAccount(Account acc) throws Exception;
	Account selectAccount(String id) throws Exception;
	void updateAccount(Account acc) throws Exception;
	List<Account> selectAll() throws Exception;
}
