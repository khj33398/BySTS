package com.metanet.bank.service;

import com.metanet.bank.dto.Member;

public interface MemberService {
	void join(Member member) throws Exception;
	void login(int id, String password) throws Exception;
	
}
