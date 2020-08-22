package site.itwill09.springMvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import site.itwill09.mvc.Member;

//Spring Framework���� �����ϴ� Controller �������̽��� ��ӹ޾� Command Controller �ۼ�
public class ListController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Service Ŭ������ �޼ҵ带 ȣ���Ͽ� ��û ó�� �� ��ȯ��� ����
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("aaa", "1111", "ȫ�浿", "aaa@itwill.site"));
		memberList.add(new Member("bbb", "2222", "�Ӳ���", "bbb@itwill.site"));
		memberList.add(new Member("ccc", "3333", "����ġ", "ccc@itwill.site"));
		memberList.add(new Member("ddd", "4444", "������", "ddd@itwill.site"));
		memberList.add(new Member("eee", "5555", "����", "eee@itwill.site"));

		//ModelAndView : ��û ó�� ����� �����ϰ� ���������� �����ϴ� Ŭ����
		ModelAndView mv=new ModelAndView();
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ���� JSP ������ �ν��Ͻ��� �����ϴ� �޼ҵ�
		mv.addObject("memberList", memberList);
		
		//ModelAndView.setViewName(String viewName) : ���������� ������ �����ϴ� �޼ҵ�
		mv.setViewName("member_list");
		
		return mv;
	}
}
