package site.itwill10.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice : ��� Controller Ŭ������ ��ûó�� �޼ҵ忡�� �߻��Ǵ� ���ܸ� 
//ó���ϱ� ���� ExceptionHandler �޼ҵ带 �ۼ��ϴ� Ŭ������ ����ϴ� ������̼�
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		return "userinfo/user_error";
	}
}
