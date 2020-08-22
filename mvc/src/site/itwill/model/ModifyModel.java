package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//클라이언트가 "/modify.do"로 요청한 경우 처리를 위해 제공되는 모델 클래스
// => POST 방식으로만 요청할 경우에만 처리 가능하도록 설정
// => 회원정보를 전달받아 USERINFO 테이블에 저장된 회원정보를 변경 처리
// => "/view.do" 페이지로 리다이렉트 이동
public class ModifyModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();
		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();
			}

			request.setCharacterEncoding("UTF-8");
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			
			UserinfoDTO userinfo=new UserinfoDTO();
			userinfo.setUserid(userid);
			if(password==null || password.equals("")) {
				userinfo.setPassword(UserinfoService
					.getService().selectUserinfo(userid).getPassword());
			} else {
				userinfo.setPassword(password);
			}
			userinfo.setName(name);
			userinfo.setEmail(email);
			
			//회원정보를 전달하여 USERINFO 테이블에 저장된 회원정보를 변경하는 메소드 호출
			UserinfoService.getService().updateUserinfo(userinfo);
			
			actionForward.setForward(false);
			actionForward.setPath("view.do?userid="+userid);		
		} catch (Exception e) {
			System.out.println("[예외] "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");		
		}
		return actionForward;
	}

}
