package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import spring.biz.user.vo.UserVO;

public class Advice {
	public void log(JoinPoint jp) {
		System.out.println("*********** Log 시작 **********");
		System.out.println(jp.toString());
		System.out.println(jp.getArgs()[0]);
		System.out.println("*********** Log END **********");
	}

	public void after_Return(Object data) {
		System.out.println("*********** after return 시작 **********");
		System.out.println("return value : " + data);
		System.out.println("*********** after return END **********");
	}

	public Object around(ProceedingJoinPoint pp) throws Throwable {
		// ProceedingJoinPoint 객체에 가로채 온 login() 입력
		System.out.println("*********** around 시작 **********");
		// 가로 챈 기능 수행 (login() 실행)후 return 값 받아옴 
		Object obj = pp.proceed();
		UserVO vo = null;
		// 가로 챈 값 (UserVO)을 가공한 후에 return이 가능
		if (obj != null && obj instanceof UserVO) {
			vo = (UserVO) obj;
			vo.setUserpwd("********");
		}
		System.out.println("*********** around 시작 **********");
		return obj;
	}
}