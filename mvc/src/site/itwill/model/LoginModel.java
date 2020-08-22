package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.exception.PasswordMissMatchException;
import site.itwill.exception.UserinfoNotFoundException;
import site.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� "/login.do"�� ��û�� ��� ó���� ���� �����Ǵ� �� Ŭ����
// => POST ������θ� ��û�� ��쿡�� ó�� �����ϵ��� ����
// => �α��������� ���޹޾� USERINFO ���̺� ����� ȸ�������� ���Ͽ� ���� ó��
// => ���� ���� : "loginForm.do" �������� �����̷�Ʈ �̵�
// => ���� ���� : "model_two/user_login.jsp" ������ ������ �̵� 
public class LoginModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();

		try {
			if(request.getMethod().equals("GET")) {
				throw new Exception();//������ ���� �߻�
			}
			
			String userid=request.getParameter("userid");
			String password=request.getParameter("password");
			
			//�� Ŭ������ ���� Ŭ������ �޼ҵ带 ȣ���Ͽ� ��� ����
			//USERINFO ���̺� ����� ȸ�������� �˻��Ͽ� ���� ó���ϴ� �޼ҵ带 ȣ�� 
			// => ���� ���н� UserinfoNotFoundException �Ǵ� PasswordMissMatchException ���� �߻�
			UserinfoService.getService().login(userid, password);
			
			//���� ���� - ������ �̿��Ͽ� ��������(ȸ������) ����
			//HttpServletRequest.getSession() : HttpSession �ν��Ͻ��� ���ε�
			//�Ͽ� ��ȯ�ϴ� �޼ҵ� - ���� ���� �Ǵ� ���� Ʈ��ŷ 
			HttpSession session=request.getSession();
			//Session Scope : ������ �ν��Ͻ��� ��� ���������� ��� ����
			session.setAttribute("loginUserinfo"
					,UserinfoService.getService().selectUserinfo(userid));
			
			actionForward.setForward(false);
			actionForward.setPath("loginForm.do");
		} catch (UserinfoNotFoundException | PasswordMissMatchException e) {//JDK1.7 �̻�
			//Request Scope : ������ �ν��Ͻ��� ������� �̵��� ���������� �����Ǿ� ��� ����
			request.setAttribute("message", e.getMessage());
			request.setAttribute("userid", request.getParameter("userid"));	
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_login.jsp");
		} catch (Exception e) {//SQLException ����
			System.out.println("[����] "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");		
		}
		
		return actionForward;
	}

}
