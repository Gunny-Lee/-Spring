package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.dao.UserDAO_JDBC;
import spring.biz.user.service.UserService;
import spring.biz.user.service.UserServiceImpl;
import spring.biz.user.vo.UserVO;

public class ListController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		UserDAO dao = new UserDAO_JDBC();
		UserService service = new UserServiceImpl(dao);
		List<UserVO> list = service.getUserList();
		request.setAttribute("users", list);
		return "/list.jsp";
	}

}

class LoginController implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		// login.do
		return "/login.jsp";
	}
	
}

class HomeController implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		// home.do
		return "/index.jsp";
	}
	
}
