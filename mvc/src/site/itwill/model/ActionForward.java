package site.itwill.model;

//뷰(View) 페이지(JSP 문서)로 포워드 이동하거나 다른 페이지가 요청되도록 
//리다이렉트 이동할 수 있는 정보를 저장하기 위한 클래스
public class ActionForward {
	//포워드 이동 또는 리다이렉트 이동에 대한 정보를 구분하여 저장하기 위한 필드
	// => false : 리다이렉트 이동, true : 포워드 이동
	private boolean forward;
	//이동 JSP 문서(포워드) 또는 요청 페이지의 URL 주소(리다이렉트)를 저장하기 위한 필드
	private String path;
	
	public ActionForward() {
		// TODO Auto-generated constructor stub
	}

	public boolean isForward() {
		return forward;
	}

	public void setForward(boolean forward) {
		this.forward = forward;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
