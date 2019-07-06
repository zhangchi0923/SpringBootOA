package cn.zhangchi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.zhangchi.entity.User;
import cn.zhangchi.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userSrv;
	
	
	@RequestMapping("login")
	public String login() {
		
		return "user/login";
	}
	

	@RequestMapping("/validataUser")
	@ResponseBody
	public String validataUser(String loginName,String password,HttpServletRequest request) {
		
		System.out.println("loginName: "+loginName);
		System.out.println("password: "+password);
		
		User user = userSrv.findByLoginNameAndPassword(loginName,password);
		
		if(user == null) {
			return "登录失败";
		}else {
			request.getSession().setAttribute("user", user);
			return "success";
			
		}
	}
	
	@RequestMapping("/logout")
//	@ResponseBody
	public String logOut(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		
		return "/index";
		
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "5") int pageSize,Model map) {
		
//		List<User> userlist = userSrv.findByPage(pageNum,pageSize);
//		map.addAttribute("userList", userlist);
		
		PageInfo<User> page = userSrv.findByPage(pageNum,pageSize);
		map.addAttribute("page", page);
		return "/user/list";
	}
	
}
