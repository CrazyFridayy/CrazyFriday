package cn.itcast.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		//request.setAttribute("k","V");
		mv.addObject("msg","springmvc的第一个程序");//封装模型数据

		mv.setViewName("/hello.jsp");//设置视图名称

		return mv;
	}
}
