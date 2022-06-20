package com.metanet.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metanet.bank.dto.Member;
import com.metanet.bank.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("id") Integer id, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView();
		try {
			memberService.login(id, password);
			mav.setViewName("redirect:/makeaccount");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("err", "로그인 실패");
			mav.setViewName("err");
		}
		return mav;
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView join(@ModelAttribute Member member) {
		ModelAndView mav = new ModelAndView();
		try {
			memberService.join(member);
			mav.setViewName("redirect:/login");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("err", e.getMessage());
			mav.setViewName("err");
		}
		return mav;
	}

}
