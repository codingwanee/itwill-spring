package site.itwill10.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice : 모든 Controller 클래스의 요청처리 메소드에서 발생되는 예외를 
//처리하기 위한 ExceptionHandler 메소드를 작성하는 클래스에 사용하는 어노테이션
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		return "userinfo/user_error";
	}
}
