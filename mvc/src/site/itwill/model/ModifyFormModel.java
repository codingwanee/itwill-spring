package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//클라이언트가 "/modifyForm.do"로 요청한 경우 처리를 위해 제공되는 모델 클래스
// => 관리자 또는 로그인 사용자와 변경 사용자가 동일한 경우에만 접근 가능하도록 권한 처리
// => 아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 검색하여 공유 처리
// => "model_two/user_modify.jsp" 문서로 포워드 이동
public class ModifyFormModel implements Action {
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
			
			String userid=request.getParameter("userid");
			
			if(!loginUserinfo.getUserid().equals("abc123") && !loginUserinfo.getUserid().equals(userid)) {
				throw new Exception();
			}
			
			//아이디를 전달하여 USERINFO 테이블에 저장된 회원정보를 검색하여 반환하는 메소드 호출
			// => 전달된 아이디의 회원정보가 존재하지 않을 경우 UserinfoNotFoundException 발생
			// => 뷰페이지(user_modify.jsp)에서 사용할 수 있도록 반환결과 공유
			request.setAttribute("userinfo",UserinfoService.getService().selectUserinfo(userid));
			
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_modify.jsp");
		} catch (Exception e) {
			System.out.println("[예외] "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");		
		}
		return actionForward;
	}

}
