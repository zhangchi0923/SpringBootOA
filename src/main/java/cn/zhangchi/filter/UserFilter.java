package cn.zhangchi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * 用户权限处理
 * @author j
 *
 */
@Component
@WebFilter(urlPatterns = "/*")
public class UserFilter implements Filter{
	
	private static final String[] IGNORE_URI = {"/index","/user/validataUser","/css/","/js/","/user/login","/images","/user/list"};

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rsp = (HttpServletResponse)response;
		
		String uri = req.getRequestURI();
		System.out.println("URI: "+uri);
		
		// 判断uri是否在列表中，如果是，doFilter之后方法返回
		boolean pass = canPassIgnore(uri);
		if(pass) {
			chain.doFilter(req, rsp);
			return;
		}
		
		// 检查是否已经登录，如未登录，重定向至登录页面；如已经登录，doFilter
		Object user = req.getSession().getAttribute("user");
		if(user == null) {
			rsp.sendRedirect("/user/login");
			return;
		}
			
		
		System.out.println("---filter---"+uri);
		chain.doFilter(req, rsp);
		
	}
	
	
	
	
	public boolean canPassIgnore(String uri) {
		
		for(String str:IGNORE_URI) {
			//下级目录也能访问
			if(uri.startsWith(str)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		// 加载filter时，启动需要的资源
		System.out.println("----- initializing -----");
		
		Filter.super.init(filterConfig);
	}
	
	
	
	

}
