package biz.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import biz.vo.FriendVO;
import biz.vo.MViewVO;
import biz.vo.MailVO;
import biz.vo.CheckVO;
import biz.vo.UserVO;
import biz.vo.ViewVO;
import mappers.UserMapper;

@Repository("mybatis")
public class DAO_Mybatis implements DAO{

	private SqlSession sqlSession;
	private UserMapper ui = null;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		ui = sqlSession.getMapper(UserMapper.class);
	}
	
	public int addUser(UserVO user) {
		return ui.addUser(user); 
	}

	@Override
	public int updateUser(UserVO user) {
		return ui.updateUser(user);
	}

	@Override
	public UserVO login(String id, String pw) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		return ui.login(map);
	}

	@Override
	public UserVO getUser(String id) {
		return ui.getUser(id);
	}

	@Override
	public int removeUser(String id) {
		return ui.removeUser(id);
	}

	@Override
	public List<UserVO> getUserList() {
		return ui.getUserList();
	}

	@Override
	public int addFriend(String id, String fid) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("fid", fid);
		return ui.addFriend(map);
	}

	@Override
	public int removeFriend(String id, String fid) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("fid", fid);
		return ui.removeFriend(map);
	}

	@Override
	public List<FriendVO> getFriendList(String id) {
		return ui.getFriendList(id);
	}

	@Override
	public int addCheckContent(CheckVO content) {
		return ui.addCheckContent(content);
	}

	@Override
	public int removeCheckContent(String id) {
		return ui.removeCheckContent(id);
	}

	@Override
	public int updateCheckContent(CheckVO content) {
		return ui.updateCheckContent(content);
	}

	@Override
	public CheckVO getCheckContent(String id) {
		return ui.getCheckContent(id);
	}

	@Override
	public List<ViewVO> searchFriends(String id, String condition) {
		return ui.searchFriends(id, condition);
	}

	@Override
	public int addMail(MailVO mail) {
		return ui.addMail(mail);
	}

	@Override
	public MailVO getMail(int num) {
		return ui.getMail(num);
	}

	@Override
	public List<CheckVO> getCheckContentList() {
		return ui.getCheckContentList();
	}

	@Override
	public List<ViewVO> getFriendViewList(String id) {
		return ui.getFriendViewList(id);
	}

	@Override
	public ViewVO getView(String id) {
		return ui.getView(id);
	}

	@Override
	public int updateMail(MailVO mail) {
		return ui.updateMail(mail);
	}

	@Override
	public int deleteMail(int num) {
		return ui.deleteMail(num);
	}

	@Override
	public List<MailVO> getMailList(String id) {
		return ui.getMailList(id);
	}

	@Override
	public int countMail(String id) {
		return ui.countMail(id);
	}

	@Override
	public int removeMail(int num) {
		return ui.removeMail(num);
	}

	@Override
	public List<MViewVO> getMViewList(String id) {
		return ui.getMViewList(id);
	}
}

