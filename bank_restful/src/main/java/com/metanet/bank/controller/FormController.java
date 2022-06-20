package com.metanet.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

	@GetMapping("/")
	public String main() {
		return "bankmain";
	}
	
	@GetMapping("/makeaccount")
	public String makeAccount() {
		return "makeAccount";
	}
	
	@GetMapping("/deposit")
	public String deposit() {
		return "deposit";
	}
	
	@GetMapping("/withdraw")
	public String withdraw() {
		return "withdraw";
	}
	
	@GetMapping("/accountinfo")
	public String accountInfo() {
		return "accountInfo";
	}
	
	@GetMapping("/allacountinfo")
	public String allAccountInfo() {
		return "allAccountInfo";
	}
	
}
