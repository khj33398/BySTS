package com.metanet.restproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {
	@GetMapping("/jsontest")
	public String jsontext() {
		
		return "jsontest";
	}
	
	@GetMapping("/objjson")
	public String objjson() {
		return "objjson";
	}
	
	@GetMapping("/objmap")
	public String objmap() {
		return "objmap";
	}
	
}
