package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dto.UserinfoDTO;
import site.itwill.exception.ExistsUserinfoException;
import site.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� "/write.do"�� ��û�� ��� ó���� ���� �����Ǵ� �� Ŭ����
// => POST ������θ� ��û�� ��쿡�� ó�� �����ϵ��� ����
// => ȸ�������� ���޹޾� USERINFO ���̺� �����ϵ��� ó��
// => "/loginForm.do" �������� �����̷�Ʈ �̵�
// => ���̵� �ߺ��Ǿ� ���� ���е� ��� "model_two/user_write.jsp" ������ ������ �̵� 
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
			
			//ȸ�������� �����Ͽ� USERINFO ���̺� �����ϴ� �޼ҵ� ȣ��
			// => ���̵� �ߺ��� ��� ExistsUserinfoException ���� �߻�
			UserinfoService.getService().insertUserinfo(userinfo);
			
			actionForward.setForward(false);
			actionForward.setPath("loginForm.do");
		} catch (ExistsUserinfoException e) {
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userinfo", userinfo);
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_write.jsp");
		} catch (Exception e) {
			System.out.println("[����] "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");
		}
		
		return actionForward;
	}

}
