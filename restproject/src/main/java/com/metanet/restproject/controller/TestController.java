package com.metanet.restproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.restproject.dto.Member;

@RestController
@RequestMapping("/test/*")
public class TestController {

	@GetMapping("hello")
	public String main() {
		return "Hello Rest!!";
	}
	
	@GetMapping("/memberlist")
	public ResponseEntity<List<Member>> listMember(){
		List<Member> members = new ArrayList<Member>();
		for(int i=0; i<10; i++) {
			Member member = new Member();
			member.setId("hong"+i);
			member.setPwd("123"+i);
			member.setName("홍길동"+i);
			member.setEmail("hong"+i+"@test.com");
			members.add(member);
		}
		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
	}
	
	@GetMapping("/membermap")
	public ResponseEntity<Map<String, Member>> mapMember(){
		Map<String, Member> members = new HashMap<>();
		for(int i=0; i<10; i++) {
			Member m = new Member();
			m.setId("hong"+i);
			m.setPwd("123"+i);
			m.setName("홍길동"+i);
			m.setEmail("hong"+i+"@test.com");
			members.put(m.getId(), m);
		}
		return new ResponseEntity<Map<String, Member>>(members, HttpStatus.OK);
	}
}
