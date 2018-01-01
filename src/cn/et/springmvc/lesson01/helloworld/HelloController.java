package cn.et.springmvc.lesson01.helloworld;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * springmvc中一个路径和方法的映射 叫做一个action(动作)
 * @author Administrator
 *
 */
@Controller
public class HelloController {
	@RequestMapping("/test")
	public String index(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.getWriter().println("hello springmvc="+request.getParameter("id"));
		return null;
	}
	
	@RequestMapping("/param")
	public String param(User user,HttpServletResponse response) throws IOException{
		response.getWriter().println(user.getId()+"--"+user.getName());
		return null;
	}
	
	@RequestMapping("/mvc")
	public String mvc() throws IOException{
		return "/index.jsp";
	}
	
	
	
}
