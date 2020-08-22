package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트가 "/loginForm.do"로 요청한 경우 처리를 위해 제공되는 모델 클래스
// => "model_two/user_login.jsp" 문서로 포워드 이동
public class LoginFormModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();
		actionForward.setForward(true);
		actionForward.setPath("model_two/user_login.jsp");		
		return actionForward;
	}
	
}
