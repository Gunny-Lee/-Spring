package spring.biz.user.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mappers.UserMapper;
import spring.biz.user.vo.UserVO;

@Repository("mybatis")
public class UserDAO_MyBatis implements UserDAO {

//	@Autowired
	// @Inject
	SqlSession sqlSession = null;
	UserMapper ui = null;

	@Inject
	public void setSqlSession(SqlSession sqlSession) {
		// sqlsession이 생성자에 의해 메모에 띄워진 후 ui에 주입되어야 하므로
		// 순서를 잘 생각해야 한다~
		this.sqlSession = sqlSession;
		ui = sqlSession.getMapper(UserMapper.class);
	}

	public UserVO login(String id, String pw) {
		System.out.println("UserDAO mybatis 연동");
		UserVO vo = new UserVO();
		vo.setUserid(id);
		vo.setUserpwd(pw);

		// user Interface 기반
		return ui.login(vo);
		// user_mapper.xml 기반
		// return sqlSession.selectOne("user.login", vo);
	}

	public int addUser(UserVO user) {
		System.out.println("mybatis");
		return sqlSession.insert("user.add", user);
	}

	public UserVO getUser(String userid) {

		return sqlSession.selectOne("user.getuser", userid);
	}

	public List<UserVO> getUserList() {
		return ui.getuserlist();
		// user_mapper.xml 기반
		// return sqlSession.selectList("user.getuser");
	}

	public int updateUser(UserVO user) {

		return sqlSession.update("user.update", user);
	}

	public int removeUser(String userid) {
		return sqlSession.delete("user.delete", userid);
	}

	public List<UserVO> searchUser(String condition, String keyword) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(condition, keyword);
		return sqlSession.selectList("user.search", map);
	}

}
