package com.metanet.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.metanet.bank.dto.Account;

public class AccountDAOImpl implements AccountDAO {

	private SimpleJdbcInsert jdbcInsert;
	private JdbcTemplate jdbcTemplate;
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("account");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void insertAccount(Account acc) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", acc.getId());
		params.put("name", acc.getName());
		params.put("balance", acc.getBalance());
		jdbcInsert.execute(params);
		
	}

	@Override
	public Account selectAccount(String id) throws Exception {
		String sql = "select * from account where id=?";
		Account acc = jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Account>() {
			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException{
				Account acc = new Account();
				acc.setId(rs.getNString(1));
				acc.setName(rs.getNString(2));
				acc.setBalance(rs.getInt(3));
				return acc;
			}
		});
		return acc;
	}

	@Override
	public void updateAccount(Account acc) throws Exception {
		String sql = "update account set balance=? where id=?";
		jdbcTemplate.update(sql, acc.getBalance(), acc.getId());
	}

	@Override
	public List<Account> selectAll() throws Exception {
		String sql = "select * from account";
		RowMapper<Account> mapper = new BeanPropertyRowMapper<Account>(Account.class);
		return jdbcTemplate.query(sql, mapper);
		/*
		return jdbcTemplate.query(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account acc = new Account();
				acc.setId(rs.getNString(1));
				acc.setName(rs.getNString(2));
				acc.setBalance(rs.getInt(3));
				return acc;
			}
			
		});
		*/
	}
	
}
