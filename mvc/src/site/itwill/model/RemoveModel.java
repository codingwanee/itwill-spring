package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//클라이언트가 "/remove.do"로 요청한 경우 처리를 위해 제공되는 모델 클래스
// => 관리자만 접근 가능하도록 권한 처리하고 관리자 삭제 불가능
// => 아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 삭제 처리
// => "/list.do" 페이지로 리다이렉트 이동
public class RemoveModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();
		try {
			//관리자가 아닌 사용자인 경우 인위적 예외 발생
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo==null || !loginUserinfo.getUserid().equals("abc123")) {
				throw new Exception();
			}
						
			String userid=request.getParameter("userid");
			if(userid==null || userid.equals("abc123")) {
				throw new Exception();
			}
			
			//아이디를 전달하여 USERINFO 테이블에 저장된 회원정보를 삭제하는 메소드 호출
			UserinfoService.getService().deleteUserinfo(userid);
			
			actionForward.setForward(false);
			actionForward.setPath("list.do");
		} catch (Exception e) {
			System.out.println("[예외] "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");		
		}
		return actionForward;
	}

}
