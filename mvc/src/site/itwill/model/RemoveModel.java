package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� "/remove.do"�� ��û�� ��� ó���� ���� �����Ǵ� �� Ŭ����
// => �����ڸ� ���� �����ϵ��� ���� ó���ϰ� ������ ���� �Ұ���
// => ���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� ���� ó��
// => "/list.do" �������� �����̷�Ʈ �̵�
public class RemoveModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();
		try {
			//�����ڰ� �ƴ� ������� ��� ������ ���� �߻�
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo==null || !loginUserinfo.getUserid().equals("abc123")) {
				throw new Exception();
			}
						
			String userid=request.getParameter("userid");
			if(userid==null || userid.equals("abc123")) {
				throw new Exception();
			}
			
			//���̵� �����Ͽ� USERINFO ���̺� ����� ȸ�������� �����ϴ� �޼ҵ� ȣ��
			UserinfoService.getService().deleteUserinfo(userid);
			
			actionForward.setForward(false);
			actionForward.setPath("list.do");
		} catch (Exception e) {
			System.out.println("[����] "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");		
		}
		return actionForward;
	}

}
