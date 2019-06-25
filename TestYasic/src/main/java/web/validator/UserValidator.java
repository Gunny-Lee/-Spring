package web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import biz.vo.UserVO;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserVO vo = (UserVO) target;
		if(vo.getId() == null || vo.getId().trim().isEmpty()) {
			errors.rejectValue("id", "required");
			System.out.println("id");
		}
		if(vo.getPw() == null || vo.getPw().trim().isEmpty()) {
			errors.rejectValue("pw", "required");
			System.out.println("pw");
		}
		
		
		if(vo.getName() == null || vo.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
			System.out.println("name");
		}
		
		if(vo.getSex() == null || vo.getSex().trim().isEmpty()) {
			errors.rejectValue("sex", "required");
			System.out.println("sex");
		}
		
		if(vo.getAge() <= 1900 && vo.getAge()>=2200) {
			errors.rejectValue("age", "required");
			System.out.println("age");
		}
		
//		if(vo.getImg() == null || vo.getImg().trim().isEmpty()) {
//			errors.rejectValue("img", "required");
//			System.out.println("img");
//		}
//		
		
		
		
		
	}
}
