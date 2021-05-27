package com.fookwood.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@PostMapping("/add")
	public String add() {return "users/add";}
	
	@GetMapping
	public String all() {return "userList";}
	
	//localhost:8080/users/23
	@GetMapping("/{userId")
	public String show(@PathVariable int userId) {
		return "user";
	}
	
	
	//localhost:8080/users?userId=23
//	@GetMapping
//	public String show2(@RequestParam("userId") int id,
//			            @RequestParam int userId) {
//		return "user";
//	}
	
//	@GetMapping
//	public String show3 (@RequestParam(defaultValue="0") int userId) {
//		return "user";
//	}

}
