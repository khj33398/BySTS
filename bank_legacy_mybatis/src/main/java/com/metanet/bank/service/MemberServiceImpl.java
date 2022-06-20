package com.metanet.bank.service;

import com.metanet.bank.dao.MemberDAO;
import com.metanet.bank.dto.Member;

public class MemberServiceImpl implements MemberService{
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	
	@Override
	public void join(Member member) throws Exception {
		memberDAO.insertMember(member);
	}

	@Override
	public void login(int id, String password) throws Exception {
		Member member = memberDAO.selectMember(id);
		if(member==null) throw new Exception("아이디 오류");
		if(!member.getPassword().equals(password)) throw new Exception("비밀번호 오류");
	}

}
