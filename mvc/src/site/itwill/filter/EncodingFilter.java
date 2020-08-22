package site.itwill.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Filter 클래스 : 클라이언트의 특정 요청에 대한 요청정보(Request)를 변경하거나
//응답정보(Response)를 변경하기 위한 클래스 => Filter 인터페이스를 상속받아 작성 

//EncodingFilter : 클라이언트의 모든 요청에 대한 요청정보의 캐릭터셋을 변경하는 필터 클래스
// => @WebFilter 어노테이션 또는 web.xml 파일을 이용하여 필터 등록과 요청 URL 패턴 설정
public class EncodingFilter implements Filter {
	//변경할 캐릭터셋에 대한 인코딩 정보를 저장하기 위한 필드
	private String encoding;
	
	//필터클래스가 인스턴스로 생성된 후 가장 먼저 호출되는 메소드 - 초기화 작업(한번만 실행)
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//encoding="UTF-8";
		
		//FilterConfig.getInitParameter(String parameterName)
		// => web.xml 파일의 filter 엘리먼트에서 제공하는 값을 얻어와 반환하는 메소드
		encoding=filterConfig.getInitParameter("encoding");
	}
	
	//클라이언트 요청에 의해 동작되는 경우 호출되는 메소드
	// => 요청정보(Request)를 변경하거나 응답정보(Response)를 변경하는 메소드
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//요청정보 변경 - 입력값에 대한 캐릭터셋 변경
		if(request.getCharacterEncoding()==null || 
				!request.getCharacterEncoding().equals(encoding)) {
			request.setCharacterEncoding(encoding);
		}
		
		//클라이언트의 요청을 처리하는 웹문서(Servlet 또는 JSP)의 실행
		//FilterChain.doFilter(ServletRequest request,ServletResponse response)
		// => 클라이언트의 실제 요청문서가 실행되도록 처리하는 메소드
		chain.doFilter(request, response);
		
		//응답정보 변경
		//response.setCharacterEncoding("UTF-8");
	}

}
