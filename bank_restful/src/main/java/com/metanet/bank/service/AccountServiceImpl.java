package com.metanet.bank.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.bank.dao.AccountDAO;
import com.metanet.bank.dto.Account;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDAO dao;
	
	@Override
	public Account accountInfo(String id) throws Exception {
		Account acc = dao.selectOne(id);
		try {
			if(acc==null) throw new SQLException("계좌 조회 오류");
		} catch (SQLException e) {
			throw e;
		}
		return acc;
	}

	@Override
	public List<Account> allAccountInfo() throws Exception {
		return dao.selectAll();
	}

	@Override
	public void makeAccount(Account acc) throws Exception {
		dao.insertOne(acc);	
	}

	@Override
	public void deposit(String id, int money) throws Exception {
		if(money<=0) throw new Exception("입금 오류");
		Account acc = dao.selectOne(id);
		if(acc==null) throw new Exception("계좌번호 오류");
		acc.deposit(money);
		dao.updateBalance(acc);
	}

	@Override
	public void withdraw(String id, int money) throws Exception {
		if(money<=0) throw new Exception("출금 오류");
		Account acc = dao.selectOne(id);
		if(acc==null) throw new Exception("계좌번호 오류");
		if(acc.getBalance()<money) throw new Exception("잔액 부족");
		acc.withdraw(money);
		dao.updateBalance(acc);
	}

	@Override
	public boolean idoverlap(String id) throws Exception {
		Account acc = dao.selectOne(id);
		if(acc==null) return true;
		return false;
	}

}
