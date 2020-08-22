package site.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import site.itwill10.dto.Userinfo;

//관리자 관련 권한 처리를 위한 인터셉터 클래스 
// => 비로그인 상태이거나 관리자가 아닌 경우 에러 페이지로 이동
public class AdminAuthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo==null || !loginUserinfo.getUserid().equals("abc123")) {
			/*
			request.getRequestDispatcher("userinfo/user_error").forward(request, response);
			return false;
			*/
			throw new Exception();
		}
		return true;
	}
}
