package site.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import site.itwill10.dto.Userinfo;

//������ ���� ���� ó���� ���� ���ͼ��� Ŭ���� 
// => ��α��� �����̰ų� �����ڰ� �ƴ� ��� ���� �������� �̵�
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
