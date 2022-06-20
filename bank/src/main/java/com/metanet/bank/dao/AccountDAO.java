package com.metanet.bank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.metanet.bank.dto.Account;

@Mapper
@Repository
//@Repository("accountDAO") //이름도 별도로 지정 가능
public interface AccountDAO {
	public Account selectOne(String id) throws Exception;
	
	public List<Account> selectAll() throws Exception;
	
	public void insertOne(Account acc) throws Exception;
	
	public void updateBalance(Account acc) throws Exception;

	public void deposit(@Param("id") String id, @Param("money") int money);
}
