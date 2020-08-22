package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.exception.PasswordMissMatchException;
import site.itwill.exception.UserinfoNotFoundException;
import site.itwill.service.UserinfoService;

//클라이언트가 "/login.do"로 요청한 경우 처리를 위해 제공되는 모델 클래스
// => POST 방식으로만 요청할 경우에만 처리 가능하도록 설정
// => 로그인정보를 전달받아 USERINFO 테이블에 저장된 회원정보와 비교하여 인증 처리
// => 인증 성공 : "loginForm.do" 페이지로 리다이렉트 이동
// => 인증 실패 : "model_two/user_login.jsp" 문서로 포워드 이동 
public class LoginModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();

		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();//인위적 예외 발생
			}
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			
			//모델 클래스는 서비스 클래스의 메소드를 호출하여 기능 구현
			//USERINFO 테이블에 저장된 회원정보를 검색하여 인증 처리하는 메소드를 호출 
			// => 인증 실패시 UserinfoNotFoundException 또는 PasswordMissMatchException 예외 발생
			UserinfoService.getService().login(userid, password);
			
			//인증 성공 - 세션을 이용하여 인증정보(회원정보) 공유
			//HttpServletRequest.getSession() : HttpSession 인스턴스를 바인딩
			//하여 반환하는 메소드 - 세션 생성 또는 세션 트랙킹 
			HttpSession session=request.getSession();
			//Session Scope : 공유된 인스턴스가 모든 웹문서에서 사용 가능
			session.setAttribute("loginUserinfo"
					,UserinfoService.getService().selectUserinfo(userid));
			
			actionForward.setForward(false);
			actionForward.setPath("loginForm.do");
		} catch (UserinfoNotFoundException | PasswordMissMatchException e) {//JDK1.7 이상
			//Request Scope : 공유된 인스턴스가 제어권이 이동된 웹문서에서 공유되어 사용 가능
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userid", request.getParameter("userid"));	
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_login.jsp");
		} catch (Exception e) {//SQLException 포함
			System.out.println("[예외] "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");		
		}
		
		return actionForward;
	}

}
