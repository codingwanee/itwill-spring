package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//클라이언트가 "/list.do"로 요청한 경우 처리를 위해 제공되는 모델 클래스
// => 로그인 상태의 사용자로만 접근 가능하도록 권한 처리
// => USERINFO 테이블에 저장된 모든 회원정보를 검색하여 공유 처리
// => "model_two/user_list.jsp" 문서로 포워드 이동
public class ListModel implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();
		
		try {
			//비로그인 상태의 사용자에 대한 요청 처리
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo==null) {
				throw new Exception();
			}
			
			//USERINFO 테이블에 저장된 모든 회원정보를 검색하여 반환하는 메소드 호출
			// => 뷰페이지(user_list.jsp)에서 사용할 수 있도록 반환결과 공유
			request.setAttribute("userinfoList", UserinfoService.getService().selectAllUserinfo());
			
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_list.jsp");
		} catch (Exception e) {
			System.out.println("[예외] "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");		
		}
		return actionForward;
	}
}
