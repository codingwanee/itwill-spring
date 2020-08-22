package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;

//클라이언트가 "/writeForm.do"로 요청한 경우 처리를 위해 제공되는 모델 클래스
// => 관리자만 접근 가능하도록 권한 처리
// => "model_two/user_write.jsp" 문서로 포워드 이동
public class WriteFormModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();
		
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo==null || !loginUserinfo.getUserid().equals("abc123")) {
				throw new Exception();
			}
			
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_write.jsp");
		} catch (Exception e) {
			System.out.println("[예외] "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		
		return actionForward;
	}
}
