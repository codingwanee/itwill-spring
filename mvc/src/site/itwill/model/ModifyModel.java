package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.itwill.dto.UserinfoDTO;
import site.itwill.service.UserinfoService;

//Ŭ���̾�Ʈ�� "/modify.do"�� ��û�� ��� ó���� ���� �����Ǵ� �� Ŭ����
// => POST ������θ� ��û�� ��쿡�� ó�� �����ϵ��� ����
// => ȸ�������� ���޹޾� USERINFO ���̺� ����� ȸ�������� ���� ó��
// => "/view.do" �������� �����̷�Ʈ �̵�
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
			
			//ȸ�������� �����Ͽ� USERINFO ���̺� ����� ȸ�������� �����ϴ� �޼ҵ� ȣ��
			UserinfoService.getService().updateUserinfo(userinfo);
			
			actionForward.setForward(false);
			actionForward.setPath("view.do?userid="+userid);		
		} catch (Exception e) {
			System.out.println("[����] "+e.getMessage());
			actionForward.setForward(false);
			actionForward.setPath("error.do");		
		}
		return actionForward;
	}

}
