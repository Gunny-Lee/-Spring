package biz.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import biz.dao.DAO;
import biz.vo.CheckVO;
import biz.vo.FriendVO;
import biz.vo.MViewVO;
import biz.vo.MailVO;
import biz.vo.UserVO;
import biz.vo.ViewVO;


@Service("service")
public class UserServiceImpl implements UserService{
	
	@Resource(name="mybatis")
	private DAO dao;
	
	@Autowired
	private ApplicationContext context;

	@Override
	public int addUser(UserVO user) {
		return dao.addUser(user);
	}

	@Override
	public int updateUser(UserVO user) {
		return dao.updateUser(user);
	}

	@Override
	public UserVO login(String id, String pw) {
		return dao.login(id, pw);
	}

	@Override
	public UserVO getUser(String id) {
		return dao.getUser(id); 
	}

	@Override
	public int removeUser(String id) {
		return dao.removeUser(id);
	}

	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}

	@Override
	public int addFriend(String id, String fid) {
		return dao.addFriend(id, fid);
	}

	@Override
	public int removeFriend(String id, String fid) {
		return dao.removeFriend(id, fid);
	}

	@Override
	public List<FriendVO> getFriendList(String id) {
		return dao.getFriendList(id);
	}

	@Override
	public int addCheckContent(CheckVO content) {
		return dao.addCheckContent(content);
	}

	@Override
	public int removeCheckContent(String id) {
		return dao.removeCheckContent(id);
	}

	@Override
	public int updateCheckContent(CheckVO content) {
		return dao.updateCheckContent(content);
	}

	@Override
	public CheckVO getCheckContent(String id) {
		return dao.getCheckContent(id);
	}

	@Override
	public List<ViewVO> searchFriends(String id, String condition) {
		return dao.searchFriends(id, condition);
	}

	@Override
	public int sendMail(MailVO mail) {
		return dao.addMail(mail);
	}

	@Override
	public MailVO getMail(int num) {
		return dao.getMail(num);
	}

	@Override
	public int friendConfirm(MailVO mail) {
		String id = mail.getId();
		String fid = mail.getFid();
		MailVO confirm = new MailVO(0, fid, id, "r", id+" add friend", null);
		int row = 0;
		
		row = dao.addFriend(id, fid);
		row = row | dao.addFriend(fid, id)*2;
		row = row | dao.deleteMail(mail.getNum())*4;
		row = row | dao.addMail(confirm)*8;
		return row;
	}

	@Override
	public int meetConfirm(MailVO mail) {
		String id = mail.getId();
		String fid = mail.getFid();
		MailVO confirm = new MailVO(0, fid, id, "r", id+" meet you", null);
		int row = 0;
		
		row = dao.deleteMail(mail.getNum());
		row = row | dao.addMail(confirm)*2;
		return row;
	}

	@Override
	public int cancle(MailVO mail) {
		String id = mail.getId();
		String fid = mail.getFid();
		String why = mail.getReq();
		MailVO cancle = new MailVO(0, fid, id, "r", id+" refuse "+why, null);
		int row = 0;
		
		row = dao.deleteMail(mail.getNum());
		row = row | dao.addMail(cancle)*2;
		return row;
	}

	@Override
	public List<CheckVO> getCheckContentList() {
		return dao.getCheckContentList();
	}

	@Override
	public List<ViewVO> getFriendViewList(String id) {
		return dao.getFriendViewList(id);
	}

	@Override
	public ViewVO getView(String id) {
		return dao.getView(id);
	}

	@Override
	public List<MailVO> getMailList(String id) {
		return dao.getMailList(id);
	}

	@Override
	public int countMail(String id) {
		return dao.countMail(id);
	}

	@Override
	public int removeMail(int num) {
		return dao.removeMail(num);
	}

	@Override
	public List<MViewVO> getMViewList(String id) {
		return dao.getMViewList(id);
	}
}
