package com.metanet.bank.controller;


import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metanet.bank.dto.Account;
import com.metanet.bank.dto.Member;
import com.metanet.bank.service.AccountService;
import com.metanet.bank.service.MemberService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {	
		return "bankmain";
	}
	
	@RequestMapping(value = "/makeaccount", method = RequestMethod.GET)
	public String makeAccount() {
		return "makeAccount";
	}
	
	@RequestMapping(value = "/makeaccount", method = RequestMethod.POST)
	public ModelAndView makeAccount(@ModelAttribute Account acc) {
		ModelAndView mav = new ModelAndView();
		try {
			accountService.makeAccount(acc);
			mav.addObject("acc", acc);
			mav.setViewName("accountInfo_res");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("err", "계좌 개설 실패");
			mav.setViewName("err");
		}
		return mav;
	}
	
	@RequestMapping(value = "/accountinfo", method = RequestMethod.GET)
	public String accountInfo() {
		return "accountInfo";
	}
	
	@RequestMapping(value = "/accountinfo", method = RequestMethod.POST)
	public ModelAndView accountInfo(@RequestParam("id") String id) {
		ModelAndView mav = new ModelAndView();
		try {
			Account acc = accountService.accountInfo(id);
			mav.addObject("acc", acc);
			mav.setViewName("accountInfo_res");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("err", "계좌 조회 실패");
			mav.setViewName("err");
		}
		return mav;
	}
	
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public String deposit() {
		return "deposit";
	}
	
	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public ModelAndView deposit(@RequestParam("id") String id, @RequestParam("money") int money) {
		ModelAndView mav = new ModelAndView();
		try {
			accountService.deposit(id, money);
			Account acc = accountService.accountInfo(id);
			mav.addObject("acc", acc);
			mav.setViewName("accountInfo_res");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("err", "입금 실패");
			mav.setViewName("err");
		}
		return mav;
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String withdraw() {
		return "withdraw";
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public ModelAndView withdraw(@RequestParam("id") String id, @RequestParam("money") int money) {
		ModelAndView mav = new ModelAndView();
		try {
			accountService.withdraw(id, money);
			Account acc = accountService.accountInfo(id);
			mav.addObject("acc", acc);
			mav.setViewName("accountInfo_res");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("err", "출금 실패");
			mav.setViewName("err");
		}
		return mav;
	}
	
	@RequestMapping(value = "/allaccountinfo", method = RequestMethod.GET)
	public ModelAndView allAccountInfo() {
		ModelAndView mav = new ModelAndView();
		try {
			List<Account> accs = accountService.accountList();
			mav.addObject("accs", accs);
			mav.setViewName("allAccountInfo");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("err", "전체 계좌 조회 실패");
			mav.setViewName("err");
		}
		return mav;
	}
	
	
	
}
