package tx;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.vo.UserVO;

@Service("txservice")
public class UserService {

	@Resource(name = "mybatis")
	UserDAO dao;
	
	@Transactional
	public void addUser(UserVO user,boolean flag) {
		dao.addUser(user);
		System.out.println(user.getUserid()+" => insert 수행");
		
		if(flag) {
			throw new RuntimeException("문제 발생");
		}
		
		user.setUserid(user.getUserid()+"**");
		dao.addUser(user);
		System.out.println(user.getUserid()+" => insert 수행");
	}
	public void print() {
		System.out.println("*********  user List **************");
		for(UserVO data :dao.getUserList()) {
			System.out.println(data);
		}
		
	}
	
}
