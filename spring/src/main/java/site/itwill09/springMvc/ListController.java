package site.itwill09.springMvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import site.itwill09.mvc.Member;

//Spring Framework에서 제공하는 Controller 인터페이스를 상속받아 Command Controller 작성
public class ListController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Service 클래스의 메소드를 호출하여 요청 처리 후 반환결과 저장
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("aaa", "1111", "홍길동", "aaa@itwill.site"));
		memberList.add(new Member("bbb", "2222", "임꺽정", "bbb@itwill.site"));
		memberList.add(new Member("ccc", "3333", "전우치", "ccc@itwill.site"));
		memberList.add(new Member("ddd", "4444", "일지매", "ddd@itwill.site"));
		memberList.add(new Member("eee", "5555", "장길산", "eee@itwill.site"));

		//ModelAndView : 요청 처리 결과를 공유하고 응답정보를 저장하는 클래스
		ModelAndView mv=new ModelAndView();
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => 응답 JSP 문서에 인스턴스를 공유하는 메소드
		mv.addObject("memberList", memberList);
		
		//ModelAndView.setViewName(String viewName) : 응답페이지 정보를 변경하는 메소드
		mv.setViewName("member_list");
		
		return mv;
	}
}
