package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��û ó�� Ŭ����(Command Controller)�� �ݵ�� ��ӹ޾ƾ� �Ǵ� �������̽�
// => �������̽��� ��ӹ��� �ڽ�Ŭ������ ������ ������ �ۼ��ǵ��� ����
// => ��� �ڽ�Ŭ������ �ν��Ͻ� ������ �������̽� ���������� �����ϱ� ���� ���� - ������
public interface Controller {
	//��û ó�� �޼ҵ� - �ڽ�Ŭ�������� ������ �������̵� ����
	// => ���� ������(JSP ����) ���� ��ȯ
	String handleRequest(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException, IOException; 
}
