package cn.itcast.springmvc.controller;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class Hello2Controller {



	@RequestMapping("show1")//url localhost:9090/hello/show1.do
	public ModelAndView test1(){
		ModelAndView mv = new ModelAndView();

		mv.addObject("msg","springmvc的第一个注解程序");//封装模型数据

		mv.setViewName("hello");//设置视图名称

		return mv;
	}


	/*?：通配一个字符
	 *：单独使用的时候只能匹配>=1个,配合其他一个字符以上的时候,通配0个或者多个字符
	 **：通配0个或者多个路径, 配合其他一个字符以上的时候通配0或多个字符,而单独使用的时候,可以配置多个路径*/


//	?：通配一个字符
	@RequestMapping("/a?/show2")
	public  ModelAndView test2(){

		ModelAndView mv = new ModelAndView();

		mv.addObject("msg","springmvc的ant风格映射:?");//封装模型数据

		mv.setViewName("hello");//设置视图名称
		return mv;
	}



	//*：单独使用的时候只能匹配>=1个,配合其他一个字符以上的时候,通配0个或者多个字符
	@RequestMapping("/a*/show4")
	public  ModelAndView test3(){

		ModelAndView mv = new ModelAndView();

		mv.addObject("msg","springmvc的ant风格映射:*");//封装模型数据

		mv.setViewName("hello");//设置视图名称
		return mv;
	}


	 //**：通配0个或者多个路径, 配合其他一个字符以上的时候通配0或多个字符,而单独使用的时候,可以配置多个路径*/
	 @RequestMapping("/a**/show4")
	 public  ModelAndView test4(){

		 ModelAndView mv = new ModelAndView();

		 mv.addObject("msg","springmvc的ant风格映射:**");//封装模型数据

		 mv.setViewName("hello");//设置视图名称
		 return mv;
	 }
}
