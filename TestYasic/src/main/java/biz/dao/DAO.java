package biz.dao;

import java.util.List;

import biz.vo.CheckVO;
import biz.vo.FriendVO;
import biz.vo.MViewVO;
import biz.vo.MailVO;
import biz.vo.UserVO;
import biz.vo.ViewVO;

public interface DAO {
	
	int addUser(UserVO user);
	int updateUser(UserVO user);
	UserVO login(String id, String pw);
	UserVO getUser(String id);//for f in getFriendList(): getUser(f.id)
	int removeUser(String id);//admin
	List<UserVO> getUserList();//admin
	
	int addFriend(String id, String fid);//in friendConfirm()
	int removeFriend(String id, String fid);
	List<FriendVO> getFriendList(String id);
	
	int addCheckContent(CheckVO content);
	int removeCheckContent(String id);
	int updateCheckContent(CheckVO content);
	List<CheckVO> getCheckContentList();
	CheckVO getCheckContent(String id);//for f in getFriendList(): getUser(f.id)

	List<ViewVO> searchFriends(String id, String condition);
	List<ViewVO> getFriendViewList(String id);
	ViewVO getView(String id);
	
	int addMail(MailVO mail);
	MailVO getMail(int num);
	int updateMail(MailVO mail);
	int deleteMail(int num);
	List<MailVO> getMailList(String id);
	List<MViewVO> getMViewList(String id);
	int countMail(String id);
	int removeMail(int num);

}
