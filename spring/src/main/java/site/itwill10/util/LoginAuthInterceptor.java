package site.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//���ͼ��� Ŭ������ �ݵ�� HandlerInterceptorAdapter Ŭ������ ��ӹ޾� �ۼ�
// => Spring Bean���� ����ؾ߸� ���ͼ��� Ŭ������ �޼ҵ� ȣ��

//�α��� ���� ���� ó���� ���� ���ͼ��� Ŭ���� 
// => ��α��� ������ ��� �α������� �Է��������� �̵�
public class LoginAuthInterceptor extends HandlerInterceptorAdapter {
	//��ûó�� �޼ҵ��� ����� ����Ǳ� ���� ȣ��Ǵ� �޼ҵ�
	// => �޼ҵ忡�� false�� ��ȯ�ϸ� ��ûó�� �޼ҵ��� ��� �̽���
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		if(session.getAttribute("loginUserinfo")==null) {
			String uri=request.getRequestURI().substring(request.getContextPath().length());
			String query=request.getQueryString();
			if(query==null) {
				query="";
			} else {
				query="?"+query;
			}
			
			if(request.getMethod().equals("GET")) {
				session.setAttribute("destURI",uri+query);
			}
				
			response.sendRedirect(request.getContextPath()+"/userinfo/login");
			return false;
		}
		return true;
	}
	
	//��ûó�� �޼ҵ��� ����� ����� �Ŀ� ȣ��Ǵ� �޼ҵ�
	// => ��ûó�� �޼ҵ忡�� ���ܰ� �߻��� ��� ��ȣ��
	// => ��ûó�� �޼ҵ��� ��ȯ���� ������ ��� ���
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	//��ûó�� �޼ҵ��� ����� ����� �Ŀ� ȣ��Ǵ� �޼ҵ�
	// => ��ûó�� �޼ҵ忡�� ���ܰ� �߻��� ��� ȣ��
	// => ����ó���� �ϰ��� �� ��� ���
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}











