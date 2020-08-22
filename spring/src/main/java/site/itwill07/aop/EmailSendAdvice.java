package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

public class EmailSendAdvice {
	//이메일을 전송하기 전에 실행될 명령을 선언한 메소드
	public void beforeMessage(JoinPoint joinPoint) {
		String email=(String)joinPoint.getArgs()[0];
		String subject=(String)joinPoint.getArgs()[1];
		System.out.println("[메세지]"+email+"님에게 <"+subject+"> 제목의 이메일을 전송합니다.");
	}
	
	//이메일 전송 성공 후에 실행될 명령이 선언된 메소드 - 받는 사람의 이메일 주소 출력
	/*
	public void successMessage(JoinPoint joinPoint) {
		String email=(String)joinPoint.getArgs()[0];
		System.out.println("[메세지]"+email+"님에게 이메일을 성공적으로 전송 하였습니다.");
	}
	*/
	
	//핵심관심모듈이 하나인 경우 매개변수를 핵심관심모듈의 반환형으로 선언
	public void successMessage(String email) {
		System.out.println("[메세지]"+email+"님에게 이메일을 성공적으로 전송 하였습니다.");
	}
	
	//이메일 전송 실패 후에 실행될 명령이 선언된 메소드 - 예외 메세지 출력 
	public void failMessage(Exception exception) {
		System.out.println("[에러]이메일 전송 실패 = "+exception.getMessage());
	}
}






