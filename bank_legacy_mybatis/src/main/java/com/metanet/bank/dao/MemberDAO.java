package com.metanet.bank.dao;

import com.metanet.bank.dto.Member;

public interface MemberDAO {
	void insertMember(Member member) throws Exception;
	Member selectMember(Integer id) throws Exception;
}
