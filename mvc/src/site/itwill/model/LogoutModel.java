package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//클라이언트가 "/logout.do"로 요청한 경우 처리를 위해 제공되는 모델 클래스
// => 세션으로 공유된 인증정보를 제거하여 로그아웃 처리
// => "/loginForm.do" 페이지로 리다이렉트 이동
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
