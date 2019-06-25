package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import biz.service.UserService;
import biz.vo.UserVO;

public class Test02 {

	public static void main(String[] args) {
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		UserService service = (UserService) context.getBean("service");
//		UserVO user = new UserVO();
//		user.setId("333");
//		user.setPw("123");
//		user.setName("test");
//		user.setAge(28);
//		user.setSex("m");
//		user.setImg("test.jpg");
//		System.out.println(service.addUser(user));
		System.out.println(service.searchFriends("333", "#테스트"));
	}

}
