package com.metanet.bank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metanet.bank.dto.Account;
import com.metanet.bank.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService service;
	
	//홈
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main() {
		return "bankmain";
	}
	
	//계좌생성
	@GetMapping("/makeaccount")
	public String makeAccount() {
		return "makeAccount";
	}
	
	@PostMapping("/makeaccount")
	public ModelAndView makeAccount(@ModelAttribute Account acc) {
		 //데이터와 뷰를 동시에 지정해주는 역할
		ModelAndView mav = new ModelAndView();
		try {
			service.makeAccount(acc);
			Account racc = service.accountInfo(acc.getId());
			mav.setViewName("accountInfo_res");
			mav.addObject("acc", racc);
		} catch (Exception e) {
			mav.setViewName("err");
			mav.addObject("err", "계좌개설 오류");
		}
		return mav;
	}
	
	//계좌조회
	@GetMapping("/accountinfo")
	public String accountInfo() {
		return "accountInfo";
	}
	
	@PostMapping("/accountinfo")
	public String accountInfo(@RequestParam("id") String id, Model model) {
		try {
			Account acc = service.accountInfo(id);
			model.addAttribute("acc", acc);
			return "accountInfo_res";
		} catch (Exception e) {
			model.addAttribute("err", e.getMessage());
			return "err";
		}
	}
	
	//전체 계좌조회
	@GetMapping("/allacountinfo")
	public ModelAndView allAccountInfo() {
		ModelAndView mav = new ModelAndView();
		try {
			mav.setViewName("allAccountInfo");
			mav.addObject("accs", service.allAccountInfo());
		} catch (Exception e) {
			mav.setViewName("err");
			mav.addObject("err", "계좌 정보 오류");
		}
		return mav;
	}
	
	//예금
	@GetMapping("/deposit")
	public String deposit() {
		return "deposit";
	}
	
	@PostMapping("/deposit")
	public ModelAndView deposit(@Param("id") String id, @Param("moeny") int money) {
		ModelAndView mav = new ModelAndView();
		try {
			service.deposit(id, money);
			mav.setViewName("accountInfo_res");
			mav.addObject("acc", service.accountInfo(id));
		} catch (Exception e) {
			mav.setViewName("err");
			mav.addObject("err", e.getMessage());
		}
		return mav;
	}
	
	//출금
	@GetMapping("/withdraw")
	public String withdraw() {
		return "withdraw";
	}
	
	@PostMapping("/withdraw")
	public ModelAndView withdraw(@Param("id") String id, @Param("moeny") int money) {
		ModelAndView mav = new ModelAndView();
		try {
			service.withdraw(id, money);
			mav.setViewName("accountInfo_res");
			mav.addObject("acc", service.accountInfo(id));
		} catch (Exception e) {
			mav.setViewName("err");
			mav.addObject("err", e.getMessage());
		}
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
