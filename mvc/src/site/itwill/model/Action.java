package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��� ��(Model) Ŭ������ �ݵ�� ��� �޾ƾ� �Ǵ� �������̽�
// => �������̽��� �߻�޼ҵ带 �������̵� �����Ͽ� ��û ó�� �޼ҵ��� �ۼ���Ģ�� ����
// => �θ� �������̽��� ���������� ��� �ڽ� Ŭ������ �ν��Ͻ� ����
// => �������̽��� �̿��Ͽ� �ڽ�Ŭ������ �������̵� ����� �޼ҵ� ȣ��
public interface Action {
	//��û�� ó���ϰ� ���� ����� ��ȯ�޾� �޼ҵ�
	ActionForward execute(HttpServletRequest request, HttpServletResponse response);
}
