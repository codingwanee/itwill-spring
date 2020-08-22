package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

public class EmailSendAdvice {
	//�̸����� �����ϱ� ���� ����� ����� ������ �޼ҵ�
	public void beforeMessage(JoinPoint joinPoint) {
		String email=(String)joinPoint.getArgs()[0];
		String subject=(String)joinPoint.getArgs()[1];
		System.out.println("[�޼���]"+email+"�Կ��� <"+subject+"> ������ �̸����� �����մϴ�.");
	}
	
	//�̸��� ���� ���� �Ŀ� ����� ����� ����� �޼ҵ� - �޴� ����� �̸��� �ּ� ���
	/*
	public void successMessage(JoinPoint joinPoint) {
		String email=(String)joinPoint.getArgs()[0];
		System.out.println("[�޼���]"+email+"�Կ��� �̸����� ���������� ���� �Ͽ����ϴ�.");
	}
	*/
	
	//�ٽɰ��ɸ���� �ϳ��� ��� �Ű������� �ٽɰ��ɸ���� ��ȯ������ ����
	public void successMessage(String email) {
		System.out.println("[�޼���]"+email+"�Կ��� �̸����� ���������� ���� �Ͽ����ϴ�.");
	}
	
	//�̸��� ���� ���� �Ŀ� ����� ����� ����� �޼ҵ� - ���� �޼��� ��� 
	public void failMessage(Exception exception) {
		System.out.println("[����]�̸��� ���� ���� = "+exception.getMessage());
	}
}






