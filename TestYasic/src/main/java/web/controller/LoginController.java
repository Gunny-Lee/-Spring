package web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import biz.service.UserService;
import biz.vo.CheckVO;
import biz.vo.UserVO;

@Controller
public class LoginController { 

	@Autowired
	UserService service;
	
	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String loginProc(UserVO vo,HttpServletRequest request) {
		UserVO user = service.login(vo.getId(), vo.getPw());
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", user);
			session.setAttribute("mycheck", service.getCheckContent(user.getId()));
			session.setAttribute("myview", service.getView(user.getId()));
			return "redirect:/index.do";
		}else {
   			request.setAttribute("msg", "로그인 정보를 다시입력하세요.");
   			return "login";
		}
	}
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		request.setAttribute("msg", "로그아웃되었습니다.");
		return "login";
	}
	
}





