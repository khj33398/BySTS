package com.metanet.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.metanet.bank.dto.Account;

public class AccountDAOImpl implements AccountDAO {
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSesson) {
		this.sqlSession = sqlSesson;
	}
	
	@Override
	public void insertAccount(Account acc) throws Exception {
		sqlSession.insert("", acc);
		sqlSession.insert("mapper.account.insertAccount", acc);	
	}

	@Override
	public Account selectAccount(String id) throws Exception {
		return sqlSession.selectOne("mapper.account.selectAccount", id);	
	}

	@Override
	public void updateAccount(Account acc) throws Exception {
		sqlSession.update("mapper.account.updateAccount", acc);	
	}

	@Override
	public List<Account> selectAll() throws Exception {
		return sqlSession.selectList("mapper.account.selectAll");	
	}
	
}
