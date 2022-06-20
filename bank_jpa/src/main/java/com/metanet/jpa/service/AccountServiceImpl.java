package com.metanet.jpa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metanet.jpa.dto.Account;
import com.metanet.jpa.model.AccountEntity;
import com.metanet.jpa.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public Account accountInfo(String id) throws Exception {
		AccountEntity accountEntity = accountRepository.findById(id).get();
		//System.out.println(accountEntity.toString());
		try {
			//Account acc = modelMapper.map(accountEntity, Account.class);
			Account acc = AccountEntity.createDto(accountEntity);
			return acc;
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public List<AccountEntity> allAccountInfo() throws Exception {
		List<AccountEntity> temps = accountRepository.findAll();
//		List<Account> accs = new ArrayList<Account>();
//		for(AccountEntity temp : temps) {
//			//accs.add(modelMapper.map(temp, Account.class));
//			accs.add(AccountEntity.createDto(temp));
//		}
//		return accs;
		return temps;
	}

	@Override
	public void makeAccount(Account acc) throws Exception {
		//AccountEntity accountEntity = modelMapper.map(acc, AccountEntity.class);
		AccountEntity accountEntity = AccountEntity.createEntity(acc);
		accountRepository.save(accountEntity);
	}

	@Override
	public void deposit(String id, int money) throws Exception {
		try {
			AccountEntity accountEntity = accountRepository.findById(id).get();
			//Account acc = modelMapper.map(accountEntity, Account.class);
			Account acc = AccountEntity.createDto(accountEntity);
			acc.deposit(money);
			//AccountEntity updateAcc = modelMapper.map(acc, AccountEntity.class);
			AccountEntity updateAcc = AccountEntity.createEntity(acc);
			accountRepository.save(updateAcc);
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void withdraw(String id, int money) throws Exception {
		try {
			AccountEntity accountEntity = accountRepository.findById(id).get();
			//Account acc = modelMapper.map(accountEntity, Account.class);
			Account acc = AccountEntity.createDto(accountEntity);
			acc.withdraw(money);
			//AccountEntity updateAcc = modelMapper.map(acc, AccountEntity.class);
			AccountEntity updateAcc = AccountEntity.createEntity(acc);
			accountRepository.save(updateAcc);
		} catch(Exception e) {
			throw e;
		}
	}

}
