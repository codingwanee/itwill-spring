package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ŭ���̾�Ʈ�� "/error.do"�� ��û�� ��� ó���� ���� �����Ǵ� �� Ŭ����
// => "model_two/user_error.jsp" ������ ������ �̵�
public class ErrorModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(true);
		actionForward.setPath("model_two/user_error.jsp");		
		return actionForward;
	}
}
