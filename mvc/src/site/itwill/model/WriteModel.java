package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dto.UserinfoDTO;
import site.itwill.exception.ExistsUserinfoException;
import site.itwill.service.UserinfoService;

//클라이언트가 "/write.do"로 요청한 경우 처리를 위해 제공되는 모델 클래스
// => POST 방식으로만 요청할 경우에만 처리 가능하도록 설정
// => 회원정보를 전달받아 USERINFO 테이블에 저장하도록 처리
// => "/loginForm.do" 페이지로 리다이렉트 이동
// => 아이디가 중복되어 저장 실패된 경우 "model_two/user_write.jsp" 문서로 포워드 이동 
public class WriteModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();
		UserinfoDTO userinfo=null;
		
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();
			}
	
			request.setCharacterEncoding("UTF-8");
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			
			userinfo=new UserinfoDTO();
			userinfo.setUserid(userid);
			userinfo.setPassword(password);
			userinfo.setName(name);
			userinfo.setEmail(email);
			
			//회원정보를 전달하여 USERINFO 테이블에 저장하는 메소드 호출
			// => 아이디가 중복될 경우 ExistsUserinfoException 예외 발생
			UserinfoService.getService().insertUserinfo(userinfo);
			
			actionForward.setForward(false);
			actionForward.setPath("loginForm.do");
		} catch (ExistsUserinfoException e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userinfo", userinfo);
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
