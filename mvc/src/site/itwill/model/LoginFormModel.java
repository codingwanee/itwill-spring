package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ŭ���̾�Ʈ�� "/loginForm.do"�� ��û�� ��� ó���� ���� �����Ǵ� �� Ŭ����
// => "model_two/user_login.jsp" ������ ������ �̵�
public class LoginFormModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(true);
		actionForward.setPath("model_two/user_login.jsp");		
		return actionForward;
	}
	
}
