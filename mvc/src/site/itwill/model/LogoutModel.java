package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Ŭ���̾�Ʈ�� "/logout.do"�� ��û�� ��� ó���� ���� �����Ǵ� �� Ŭ����
// => �������� ������ ���������� �����Ͽ� �α׾ƿ� ó��
// => "/loginForm.do" �������� �����̷�Ʈ �̵�
public class LogoutModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.invalidate();
		
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(false);
		actionForward.setPath("loginForm.do");
		return actionForward;
	}

}
