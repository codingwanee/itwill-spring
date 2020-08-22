package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.itwill.dto.UserinfoDTO;

//Ŭ���̾�Ʈ�� "/writeForm.do"�� ��û�� ��� ó���� ���� �����Ǵ� �� Ŭ����
// => �����ڸ� ���� �����ϵ��� ���� ó��
// => "model_two/user_write.jsp" ������ ������ �̵�
public class WriteFormModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward actionForward=new ActionForward();
		
		try {
			HttpSession session=request.getSession();
			UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
			if(loginUserinfo==null || !loginUserinfo.getUserid().equals("abc123")) {
				throw new Exception();
			}
			
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
