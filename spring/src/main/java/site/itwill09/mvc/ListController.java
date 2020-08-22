package site.itwill09.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청 처리 클래스(Command Controller - Model) : 클라이언트 요청을 처리하는 메소드가 선언된 클래스 
public class ListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Service 클래스의 메소드를 호출하여 요청 처리 후 반환결과 저장
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("aaa", "1111", "홍길동", "aaa@itwill.site"));
		memberList.add(new Member("bbb", "2222", "임꺽정", "bbb@itwill.site"));
		memberList.add(new Member("ccc", "3333", "전우치", "ccc@itwill.site"));
		memberList.add(new Member("ddd", "4444", "일지매", "ddd@itwill.site"));
		memberList.add(new Member("eee", "5555", "장길산", "eee@itwill.site"));
		
		//요청 처리 결과를 응답페이지에 공유
		request.setAttribute("memberList", memberList);
		
		//응답페이지 정보 반환
		return "member_list";
	}

}





