package com.test.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecondController {

	@RequestMapping("/view2")
	public String view2(Model model) {

		int sum = 0;
		for (int i = 0; i < 101; i++) {
			sum += i;
		}
		model.addAttribute("res", sum);
		return "view2";
	}

	@RequestMapping("/modelview")
	public String modelview(HttpServletRequest httpServletRequest, Model model) {

		String id = httpServletRequest.getParameter("id");
		String num = httpServletRequest.getParameter("num");
		int len;
		if(num!=null){
		len = Integer.parseInt(num);
		}else{
			len=101;
		}
		if(id==null){
			id="no id";
		}
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += i;
		}
		model.addAttribute("id", id);
		model.addAttribute("res", sum);
		return "/model/modelview";
	}
	
	
	@RequestMapping("/paramview")
	public String paramview(@RequestParam ("id") String id,@RequestParam ("pw") String pw, Model model){

		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "paramview";
	}
	
	
	//   http://localhost:8181/ex/join?id=qhsowntu&name=kys&email=qhsowntu@naver.com&pw=1234
	@RequestMapping("/join")
	public String join(Member member){
		return "join";
	}
	
	
	@RequestMapping("/gp")
	public String gp(){
		return "/model/getpost";
	}
	
	//RequestMapping 파라미터 get
	@RequestMapping( method = RequestMethod.GET, value="/std" )
	public String get(HttpServletRequest httpServletRequest, Model model){
		System.out.println("get");

		String id=httpServletRequest.getParameter("id");
		String pw=httpServletRequest.getParameter("pw");
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		return "/model/getpost2";	
	}
	
	//RequestMapping 파라미터 post
	@RequestMapping( method = RequestMethod.POST, value="/std" )
	public String post(HttpServletRequest httpServletRequest, Model model){
		System.out.println("post");

		String id=httpServletRequest.getParameter("id");
		String pw=httpServletRequest.getParameter("pw");
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		return "/model/getpost2";	
	}
}














