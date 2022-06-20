package com.metanet.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.metanet.demo.dto.Account;

@Mapper
@Repository("accountDAO")
public interface AccountDAO {
	List<Account> accountList();
	
}
