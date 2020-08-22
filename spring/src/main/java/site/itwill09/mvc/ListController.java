package site.itwill09.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��û ó�� Ŭ����(Command Controller - Model) : Ŭ���̾�Ʈ ��û�� ó���ϴ� �޼ҵ尡 ����� Ŭ���� 
public class ListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Service Ŭ������ �޼ҵ带 ȣ���Ͽ� ��û ó�� �� ��ȯ��� ����
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("aaa", "1111", "ȫ�浿", "aaa@itwill.site"));
		memberList.add(new Member("bbb", "2222", "�Ӳ���", "bbb@itwill.site"));
		memberList.add(new Member("ccc", "3333", "����ġ", "ccc@itwill.site"));
		memberList.add(new Member("ddd", "4444", "������", "ddd@itwill.site"));
		memberList.add(new Member("eee", "5555", "����", "eee@itwill.site"));
		
		//��û ó�� ����� ������������ ����
		request.setAttribute("memberList", memberList);
		
		//���������� ���� ��ȯ
		return "member_list";
	}

}





