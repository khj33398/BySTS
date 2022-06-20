package com.metanet.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metanet.bank.dto.Account;
import com.metanet.bank.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService service;
	
	@PostMapping("/makeaccount")
	public ResponseEntity<String> makeAccount(@ModelAttribute Account acc) {
		try {
			service.makeAccount(acc);
			return new ResponseEntity<String>("계좌 개설 성공", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("계좌 개설 실패", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/idoverlap/{id}")
	public ResponseEntity<String> idOverlapCheck(@PathVariable("id") String id){
		boolean result;
		try {
			result = service.idoverlap(id);
			if(result == true) return new ResponseEntity<String>("사용 가능한 계좌번호입니다.", HttpStatus.OK);
		} catch (Exception e) {}
		return new ResponseEntity<String>("사용 불가능한 계좌번호입니다.", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Account>> allAccountList(){
		try {
			List<Account> accs = service.allAccountInfo();
			return new ResponseEntity<List<Account>>(accs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Account>>(new ArrayList<Account>(), HttpStatus.BAD_REQUEST);
		}
	}
}
