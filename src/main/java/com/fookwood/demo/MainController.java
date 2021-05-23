package com.fookwood.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
	
//	@GetMapping("/")
//	@ResponseBody
//	public String home() {
//		return "home";
//	}
	
	//add ftl @PostMapping、@PatchMapping、@PutMapping和@DeleteMapping
	@GetMapping("/home")
	public String home(Model model) {
		String[] cities = new String[] {"Beijing", "ShangHai","GuangZhou","HangZhou"};
		model.addAttribute("list", cities);
		model.addAttribute("title", "big citiy");
		return "home";
	}
	
	
	//using RequestMapping
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String home() {
		return "home";
	}

}
