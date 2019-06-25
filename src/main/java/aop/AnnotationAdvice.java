package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import spring.biz.user.vo.UserVO;

@Component
@Aspect
public class AnnotationAdvice {

	static final Logger LOGGER = LoggerFactory.getLogger("root");

	@Pointcut("execution(* spring.biz.user.service.UserService.login(..))")
	public void pointcut_1() {

	}

	@Pointcut("execution(* spring.biz.*.service.*Service.*(..))")
	public void pointcut_2() {
	}

//	@Before("pointcut_1()")
	public void log(JoinPoint jp) {
		Object[] args = jp.getArgs();
		LOGGER.info(jp.toString());

	}

//	@Around("pointcut_1()")
//	public Object around(ProceedingJoinPoint pp) throws Throwable {
//		String method = pp.getSignature().getName();
//		StopWatch stopwatch = new StopWatch();
//		stopwatch.start();
//
//		Object obj = pp.proceed();
//		stopwatch.stop();
//		System.out.println(method + "() 수행 시간 : " + stopwatch.getTotalTimeMillis() + "(ms)초");
//		return obj;
//	}
	@Around("pointcut_1()")
	public Object around(ProceedingJoinPoint pp) throws Throwable {
		Object obj = pp.proceed();
		UserVO vo = null;
		if (obj != null && obj instanceof UserVO) {
			vo = (UserVO) obj;
			vo.setUserpwd("*****");
		}
		return obj;
	}
//
//	@AfterThrowing(pointcut = "pointcut_2()", throwing = "e")
//	// joinpoint 는 무적권 첫번째 parameter에 와야 함
//	public void ex(JoinPoint jp, Exception e) {
//		LOGGER.error(jp.getSignature().getName() + " " + e.getMessage());
//	}

}
