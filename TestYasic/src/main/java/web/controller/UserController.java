package web.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import biz.service.UserService;
import biz.vo.CheckVO;
import biz.vo.FriendVO;
import biz.vo.MailVO;
import biz.vo.UserVO;
import web.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	UserService service;

	@RequestMapping("/index.do")
	public String indexProc(HttpServletRequest request) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		request.setAttribute("users", service.getFriendViewList(user.getId()));
		request.setAttribute("mailCount", service.countMail(user.getId()));
		return "index";
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String addUser() {
		return "add";
	}

//	@RequestMapping(value = "/add.do",method = RequestMethod.POST)
//	public String addUserProc(UserVO user , HttpServletRequest request, BindingResult errors) {
//		System.out.println(user);
//		new UserValidator().validate(user, errors);
//		if(errors.hasErrors()) {
//			request.setAttribute("user", user);
//			return "add";
//		}
//		int row = service.addUser(user);
//		return "redirect:/index.do";
//	}

	public void upload(MultipartFile file, HttpServletRequest request, String name) {
		String fileName = name;
		String path = request.getRealPath("/upload/");
		System.out.println(path);
		if (!file.isEmpty()) {
			File f = new File(path + fileName);
			try {
				file.transferTo(f);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("imgname", fileName);
	}
	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	public String addUserProc(UserVO vo,  MultipartFile file, 
			HttpServletRequest request, BindingResult errors) {
		
		new UserValidator().validate(vo, errors);
		int row = 0;
		if (errors.hasErrors()) {
			return "add";
		}

		String name = vo.getId() + file.getOriginalFilename().toLowerCase();
		vo.setImg(name);
		System.out.println(vo);
		row = service.addUser(vo);

		System.out.println("회원가입 : " + row);
		upload(file, request, name);
		return "redirect:/index.do";

	}

	@RequestMapping("/mypage.do")
	public String toMypage() {
		return "mypage";
	}

	@RequestMapping("/yourpage.do")
	public String yourPage(HttpServletRequest request, String id) {
		UserVO user = service.getUser(id);
		CheckVO check = service.getCheckContent(id);

		request.setAttribute("user", user);
		request.setAttribute("check", check);
		return "yourpage";
	}

	@RequestMapping("/mailbox.do")
	public String toMailBox(HttpServletRequest request) {
		String id = ((UserVO) request.getSession().getAttribute("login")).getId();
		request.setAttribute("mviews", service.getMViewList(id));
		return "mailbox";
	}

	@RequestMapping("/search.do")
	public String doSearch(HttpServletRequest request, String condition) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		request.setAttribute("users", service.searchFriends(user.getId(), condition));
		return "index";
	}

	@RequestMapping(value = "/fix.do", method = RequestMethod.GET)
	public String toFix(HttpServletRequest request) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		request.setAttribute("user", service.getUser(user.getId()));
		return "fix";
	}

//	@RequestMapping(value = "/fix.do", method = RequestMethod.POST)
//	public String doFix(UserVO user, HttpServletRequest request, BindingResult errors) {
//		new UserValidator().validate(user, errors);
//		if(errors.hasErrors()) {
//			request.setAttribute("user", user);
//			return "fix";
//		}
//		int row = service.updateUser(user);
//		return "close";
//	}
	
	@RequestMapping(value = "/fix.do", method = RequestMethod.POST)
	public String fixUserProc(UserVO vo, MultipartFile file,
			HttpServletRequest request, BindingResult errors) {
		
		System.out.println(vo);

		new UserValidator().validate(vo, errors);
		int row = 0;
		if (errors.hasErrors()) {
			request.setAttribute("user", vo);
			return "fix";
		}

		String name = vo.getId() + file.getOriginalFilename().toLowerCase();
		vo.setImg(name);
		System.out.println(vo);
		row = service.updateUser(vo);
		String id = vo.getId();
		HttpSession session = request.getSession();
		session.setAttribute("login", service.getUser(id));
		session.setAttribute("myview", service.getView(id));

		System.out.println("fix : " + row);
		upload(file, request, name);
		return "close";

	}

	@RequestMapping(value = "/fadd.do", method = RequestMethod.GET)
	public String toAddFriendPage(HttpServletRequest request) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		request.setAttribute("user", user);
		return "fadd";
	}

//	@RequestMapping(value = "/fadd.do", method = RequestMethod.POST)
//	public String addFriend(HttpServletRequest request, String fid) {
//		UserVO user = (UserVO) request.getSession().getAttribute("login");
//		
//		System.out.println("add");
//		
//		MailVO mail = new MailVO();
//		mail.setId(fid);
//		mail.setFid(user.getId());
//		mail.setReq("f");
//		service.sendMail(mail);
//		/*transaction 필요*/
//		String id = user.getId();
//		service.addFriend(id, fid);
//		service.addFriend(fid, id);
//		/*===============*/
//		System.out.println("end");
//		
//		request.setAttribute("user", user);
//		request.setAttribute("msg", "친구추가가 완료 되었습니다.");
//		return "fadd";
//	}

//	@RequestMapping("/yourpage.do")
//	public String yourPage(HttpServletRequest request, String id) {
//		System.out.println(id);
//		UserVO user = service.getUser(id);
//		CheckVO check = service.getCheckContent(id);
//		request.setAttribute("user", service.getUser(id));
//		request.setAttribute("check", service.getCheckContent(id));
//		return "mypage";
//	}

	@RequestMapping("/remove.do")
	public String remove(HttpServletRequest request) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		service.removeUser(user.getId());
		return "redirect:/index.do";
	}

	@RequestMapping("/reqFriend.do")
	public String reqFriend(HttpServletRequest request, String fid) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		String id = user.getId();
		List<FriendVO> friends = service.getFriendList(id);
		List<String> flist = new ArrayList<String>();
		flist.add(id);
		friends.forEach(f -> flist.add(f.getFid()));

		if (flist.contains(fid)) {
			System.out.println("contain");
		} else {
			String msg = id + " request friend";
			MailVO mail = new MailVO();
			mail.setId(fid);
			mail.setFid(id);
			mail.setReq("f");
			mail.setMsg(msg);
			int row = service.sendMail(mail);
		}
		return "close";
	}

	@RequestMapping("/confirm.do")
	public String confirm(HttpServletRequest request, MailVO mail) {
		String req = mail.getReq();
		System.out.println(mail);
		if (req.equals("f")) {
			service.friendConfirm(mail);
		} else if (req.equals("m")) {
			service.meetConfirm(mail);
		}
		String id = ((UserVO) request.getSession().getAttribute("login")).getId();
		request.setAttribute("mviews", service.getMViewList(id));
		return "mailbox";
	}

	@RequestMapping("/refuse.do")
	public String refuse(HttpServletRequest request, MailVO mail) {
		service.cancle(mail);
		String id = ((UserVO) request.getSession().getAttribute("login")).getId();
		request.setAttribute("mviews", service.getMViewList(id));
		return "mailbox";
	}

	@RequestMapping("/reqMeet.do")
	public String reqMeet(HttpServletRequest request, String fid, String content) {
		UserVO user = (UserVO) request.getSession().getAttribute("login");
		String id = user.getId();
		String msg = id + " request meet";
		MailVO mail = new MailVO();
		mail.setId(fid);
		mail.setFid(id);
		mail.setReq("m");
		mail.setMsg(content);
		int row = service.sendMail(mail);
		return "close";
	}

	@RequestMapping("/msg.do")
	public String toMsg(HttpServletRequest request, String fid) {
		System.out.println(fid);
		request.setAttribute("friend", service.getUser(fid));
		System.out.println("hh");
		return "message";
	}

	@RequestMapping(value = "/checkbox.do", method = RequestMethod.GET)
	public String toCheckBox() {
		return "checkbox";
	}

	@RequestMapping(value = "/checkbox.do", method = RequestMethod.POST)
	public String addCheckProc(CheckVO vo, HttpServletRequest request, String content, String smin, String emin) {
//		vo.setColor("r");
//		if (errors.hasErrors()) {
//			return "checkbox";
//		}
		System.out.println("hhhh");
		System.out.println("stime:" + vo.getStime());
		System.out.println("etime:" + vo.getEtime());
		System.out.println(vo.getColor());
		System.out.println(vo);
		if (vo.getColor().equals("0")) {
			System.out.println(vo.getColor());
			service.removeCheckContent(vo.getId());
			HttpSession session = request.getSession();
			session.setAttribute("myview", service.getView(vo.getId()));
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			time.setHours(Integer.parseInt(vo.getStime()));
			time.setMinutes(Integer.parseInt(smin));
			String stimestring = format.format(time);

			time.setHours(Integer.parseInt(vo.getEtime()));
			time.setMinutes(Integer.parseInt(emin));
			String etimestring = format.format(time);

//			System.out.println(stimestring);
//			System.out.println(etimestring);

			vo.setWhy(vo.getWhy() + content);
			vo.setStime(stimestring);
			vo.setEtime(etimestring);

//			System.out.println(vo);
//			System.out.println(service.getCheckContent(vo.getId()));

			HttpSession session = request.getSession();
			String id = ((UserVO) session.getAttribute("login")).getId();
			session.setAttribute("check", vo);

			int row = 0;
			if (service.getCheckContent(vo.getId()) != null) {
				row = service.updateCheckContent(vo);
			} else {
				row = service.addCheckContent(vo);
			}
			session.setAttribute("myview", service.getView(id));
		}
		return "close";
	}

	@RequestMapping("/ok.do")
	public String removeMail(HttpServletRequest request, String num) {
		String id = ((UserVO) request.getSession().getAttribute("login")).getId();
		service.removeMail(Integer.parseInt(num));
		request.setAttribute("mviews", service.getMViewList(id));
		return "mailbox";
	}
	
	@RequestMapping("/contact.do")
	public String tocontact() {
		return "contact";
	}

//	@ExceptionHandler(Exception.class)
//	public String Ex(Exception exception,Model model) {
//		model.addAttribute("exception", exception);
//		return "error";
//	}

}
