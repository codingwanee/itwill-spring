package site.itwill09.mvc;

//응답페이지를 반환하는 기능을 제공하는 클래스
public class ViewResolver {
	//문자열을 전달받아 실제 응답할 페이지(JSP 문서)로 변환하는 반환하는 메소드
	public String getViewPage(String view) {
		return "/WEB-INF/mvc/"+view+".jsp";
	}
}
