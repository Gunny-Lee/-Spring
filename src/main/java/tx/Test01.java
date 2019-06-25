package tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.biz.user.vo.UserVO;

public class Test01 {
	public static void main(String[] args) {
		String[] config = {"applicationContext.xml"};
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(config);
		
		UserService service = (UserService) context.getBean("txservice");
		
        UserVO vo = 
        		new UserVO("java01", "자바", "1aA~", "email", "010", "mc");
       
        // service.addUser(vo, true); // 예외발생시킴
        service.print();
		
	}
}
