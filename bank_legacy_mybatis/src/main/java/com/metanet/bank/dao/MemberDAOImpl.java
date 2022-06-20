package com.metanet.bank.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.metanet.bank.dto.Member;

public class MemberDAOImpl implements MemberDAO {
	
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSesson) {
		this.sqlSession = sqlSesson;
	}

	@Override
	public void insertMember(Member member) throws Exception {
		sqlSession.insert("mapper.member.insertMember", member);
	}

	@Override
	public Member selectMember(Integer id) throws Exception {
		return sqlSession.selectOne("mapper.member.selectMember", id);
	}

}
