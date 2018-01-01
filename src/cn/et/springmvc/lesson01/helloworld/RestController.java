package cn.et.springmvc.lesson01.helloworld;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * ��������ύ��ʽ �����@RequestMappingָ������Դ��������һ�� 
 *  �׳� 405
 * @author Administrator
 *
 */
@Controller
public class RestController {
	/**
	 * /user/2
	 * /user/3
	 * 
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String index(@PathVariable(value="id") String userId) throws IOException{
		return "/lesson01/user.jsp";
	}
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String addUser(String name,HttpServletResponse response) throws IOException{
		response.getWriter().println(name+"--add success");
		return null;
	}
	@RequestMapping(value="/user/{id}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable(value="id") String userId,String name,HttpServletResponse response) throws IOException{
		response.getWriter().println(userId+name+"--update success");
		return null;
	}
	@RequestMapping(value="/user/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable(value="id") String userId,HttpServletResponse response) throws IOException{
		response.getWriter().println(userId+"--delete success");
		return null;
	}
	
	
}
