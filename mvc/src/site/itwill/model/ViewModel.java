package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� "/view.do"�� ��û�� ��� ó���� ���� �����Ǵ� �� Ŭ����
// => �α��� ������ ����ڷθ� ���� �����ϵ��� ���� ó��
// => ���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� �˻��Ͽ� ���� ó��
// => "model_two/user_view.jsp" ������ ������ �̵�
public class ViewModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();
		try {
			//��α��� ������ ����ڿ� ���� ��û ó��
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo==null) {
				throw new Exception();
			}
			
			String userid=request.getParameter("userid");
			
			//���̵� �����Ͽ� USERINFO ���̺� ����� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ� ȣ��\
			// => ���޵� ���̵��� ȸ�������� �������� ���� ��� UserinfoNotFoundException �߻�
			// => ��������(user_view.jsp)���� ����� �� �ֵ��� ��ȯ��� ����
			request.setAttribute("userinfo",UserinfoService.getService().selectUserinfo(userid));
			
			actionForward.setForward(true);
			actionForward.setPath("model_two/user_view.jsp");
		} catch (Exception e) {
			System.out.println("[����] "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");		
		}
		return actionForward;
	}
}
