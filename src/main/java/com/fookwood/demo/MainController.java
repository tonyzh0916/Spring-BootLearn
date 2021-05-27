package com.fookwood.demo;

import org.apache.tomcat.util.descriptor.tld.TldRuleSet.Variable;
import org.jboss.logging.NDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ch.qos.logback.core.net.ssl.ConfigurableSSLServerSocketFactory;


@RestController
public class MainController {
	
	@Autowired private ObjectMapper objectMapper;
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
	
	//using ModelAndView
	@GetMapping("/home2")
	public ModelAndView home2() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("title","model");
		return modelAndView;
	}
	
	
	//using ModelAttrubute 
	@ModelAttribute
	public void fillDate (Model model) {
		model.addAttribute("tabName","message");
		model.addAttribute("useName","fookwood");
	}
	
	
	//Json API
	//如果你的控制器里的所有方法都是API，那么可以将@Controller替换成@RestController，这样不用在每个方法上都添加@ResponseBody了
	@RequestMapping("/api")
	@ResponseBody
	public String api() {
		return "Hello from fookwood.com";
	}
	
	@RequestMapping("/player")
	public ObjectNode api2() {
		ObjectNode node = objectMapper.createObjectNode();
		node.put("name","kevin Durant");
		node.put("team", "Nets");
		return node;
		
	}
	
	@RequestMapping("/player2")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Player> api3() {
		Player player = new Player();
		player.setName("Russl Westbrook");
		player.setTeam("Rockets");
		return ResponseEntity.status(HttpStatus.OK).body(player);
	}

}
