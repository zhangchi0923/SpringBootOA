package cn.zhangchi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	
	@RequestMapping("/")
//	@ResponseBody
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("index")
	public String index2() {
		
		return "index";
	}
	

}
