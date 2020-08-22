package site.itwill.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러(Controller) : 클라이언트(브라우저)의 모든 요청을 받아 필요한 모델(Model)을
//이용하여 요청 처리 후 처리결과를 뷰(View)로 전달하는 기능의 서블릿

//1.클라이언트의 모든 요청을 받을 수 있는 단일 진입점 기능 구현
//@WebServlet(String url) : 서블릿 등록과 URL 매핑 기능의 어노테이션
// => URL 주소 대신 패턴(Pattern - * 또는 ?)를 이용하여 설정 가능
//클라이언트에서 "~.do" 형식의 URL 주소로 요청한 경우 실행되는 서블릿
//@WebServlet("*.do")
//@WebServlet 어노테이션 대신 web.xml 파일을 설정하여 서블릿 등록과 URL 매핑
// => 소스파일 변경 없이 다양한 환경설정 가능
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//요청정보(Key)와 Model 인스턴스(Value)를 정보들을 저장하기 위한 필드
	private Map<String, Action> actionMap;
	
	//서블릿 클래스로 인스턴스를 생성하기 위한 생성자 - 초기화 작업
	/*
	public ControllerServlet() {
		//actionMap=new HashMap<String, Action>();
		System.out.println("# ControllerServlet 클래스의 생성자 호출 #");
	}
	*/
	
	//서블릿 클래스가 인스턴스로 생성된 후 가장 먼저 호출되는 메소드 - 1번만 호출
	// => 생성자보다 다양한 형식의 초기화 작업 가능
	@Override
	public void init(ServletConfig config) throws ServletException {
		//HashMap 인스턴스를 생성하여 actionMap 필드에 저장
		actionMap=new HashMap<String, Action>();
		
		//요청정보와 요청에 대한 모델 클래스의 인스턴스를 actionMap 필드에 저장
		// => 클라이언트 요청전에 미리 Map 인스턴스에 요청정보와 Model 인스턴스 저장
		// => 요청에 대한 Model 인스턴스의 메소드 실행 속도 증가
		/*
		actionMap.put("/loginForm.do", new LoginFormModel());
		actionMap.put("/login.do", new LoginModel());
		actionMap.put("/logout.do", new LogoutModel());
		actionMap.put("/writeForm.do", new WriteFormModel());
		actionMap.put("/write.do", new WriteModel());
		actionMap.put("/list.do", new ListModel());
		actionMap.put("/view.do", new ViewModel());
		actionMap.put("/modifyForm.do", new ModifyFormModel());
		actionMap.put("/modify.do", new ModifyModel());
		actionMap.put("/remove.do", new RemoveModel());
		actionMap.put("/error.do", new ErrorModel());
		*/
		
		//Properties 파일에 저장된 정보를 이용하여 요청정보와 Model 인스턴스를 actionMap 필드에 추가
		// => Properties File(~.properties) : 프로그램 실행에 필요한 정보를 제공하기 위한 텍스트 파일
		
		//Properties 파일의 이름을 web.xml 파일에서 제공받아 저장
		//ServletConfig.getInitParameter(String parameterName) 
		// => web.xml 파일에 등록되어 제공하는 정보를 반환하는 메소드
		// => Properties 파일의 경로가 변경돼도 컨트롤러 미변경
		String configFile=config.getInitParameter("configFile");
		
		//Properties 파일의 실제 서버 시스템의 절대경로를 반환받아 저장
		//ServletConfig.getServletContext() : ServletContext 인스턴스(컨텍스트 정보)를 반환하는 메소드
		//ServletContext.getRealPath(String filePath) :  컨텍스트에 존재하는 파일의 실제 시스템 경로를 반환하는 메소드
		//String configFilePath=config.getServletContext().getRealPath("/WEB-INF/model.properties");
		String configFilePath=config.getServletContext().getRealPath(configFile);
		//System.out.println("configFilePath = "+configFilePath);
		
		//Properties 인스턴스 생성 - Properties 파일의 정보들을 저장하여 제공하기 위한 인스턴스
		Properties properties=new Properties();
		
		try {
			//Properties 파일의 정보을 읽기 위한 입력스트림 생성
			FileInputStream fin=new FileInputStream(configFilePath);
			
			//Properties 파일의 정보을 읽어 Properties 인스턴스에 저장
			//Properties.load(InputStrean in) : 입력스트림을 이용하여 Properties 인스턴스에 정보 저장하는 메소드
			properties.load(fin);
			
			//입력스트림 제거
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Properties 인스턴스에 저장된 정보를 이용하여 Map 인스턴스에 저장 - 일괄처리
		//Properties.keySet() : Properties 인스턴스에 저장된 모든 키들을 반환하는 메소드
		for(Object key:properties.keySet()) {
			//Properties 인스턴스에 저장된 키(요청정보)를 반환받아 저장
			String actionCommand=(String)key;
			
			//Properties 인스턴스에 저장된 값(Model 클래스 이름)를 반환받아 저장
			//Properties.get(String key) : 키에 의해 저장되 값을 반환하는 메소드
			String actionClassName=(String)properties.get(key);
			//System.out.println(actionCommand+" = "+actionClassName);
			
			try {
				//Model 클래스 이름을 이용하여 Model 인스턴스 생성 - 리플렉션 기능 이용
				//Class.forName(String className) : 클래스를 읽어 메모리에 저장하는 메소드
				// => Class 인스턴스(Clazz) 반환
				//Class.newInstance() : 메모리에 저장된 클래스의 기본 생성자를 이용하여 인스턴스 생성하여 반환하는 메소드
				Action actionObject=(Action)Class.forName(actionClassName).newInstance();
				
				//Map 인스턴스에 요청정보와 Model 인스턴스를 저장
				actionMap.put(actionCommand, actionObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//클라이언트의 모든 방식의 요청에 대한 처리와 응답을 위해 자동 호출되는 메소드 - 반복 호출
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("# ControllerServlet 클래스의 service() 메소드 호출");
		
		//2.클라이언트의 요청 분석 => http://localhost:8000/mvc/XXX.do
		
		//HttpServletRequest.getRequestURI() : 요청 URL 주소의 URI 값을 반환하는 메소드 => /mvc/XXX.do
		String requestURI=request.getRequestURI();
		//System.out.println("requestURI = "+requestURI);
	
		//HttpServletRequest.getContextPath() : 요청 URL 주소의 컨텍스트 경로를 반환하는 메소드 => /mvc
		String contentPath=request.getContextPath();
		//System.out.println("contentPath = "+contentPath);
		
		//URI 값에서 컨텍스트 경로를 제외한 문자열을 분리하여 저장 => /XXX.do
		String command=requestURI.substring(contentPath.length());
		//System.out.println("command = "+command);
		
		//3.요청정보에 따라 필요한 모델(Model) 클래스를 인스턴스로 생성하여 처리 메소드 호출
		// => 모델 클래스의 처리 메소드의 호출 결과(이동방식과 URL 주소)를 반환받아 저장
		//로그인 입력페이지 : /loginForm.do - Model : LoginFormModel >> 포워드 이동(View : user_login.jsp) 
		//로그인 처리페이지 : /login.do - Model : LoginModel >> 리다이렉트 이동(/loginForm.do)
		//로그아웃 처리페이지 : /logout.do - Model : LogoutModel >> 리다이렉트 이동(/loginForm.do)
		//회원등록 입력페이지 : /writeForm.do - Model : WriteFormModel >> 포워드 이동(View : user_write.jsp)
		//회원등록 처리페이지 : /write.do - Model : WriteModel >> 리다이렉트 이동(/loginForm.do)
		//회원목록 출력페이지 : /list.do - Model : ListModel >> 포워드 이동(View : user_list.jsp)
		//회원상세 출력페이지 : /view.do - Model : ViewModel >> 포워드 이동(View : user_view.jsp)
		//회원변경 입력페이지 : /modifyForm.do - Model : ModifyFormModel >> 포워드 이동(View : user_modify.jsp)
		//회원변경 처리페이지 : /modify.do - Model : ModifyModel >> 리다이렉트 이동(/view.do)
		//회원삭제 처리페이지 : /remove.do - Model : RemoveModel >> 리다이렉트 이동(/list.do)
		//에러메세지 출력페이지 : /error.do - Model : ErrorModel >> 포워드 이동(View : user_error.jsp)
		
		/*
		//모델 클래스(자식)의 인스턴스를 저장하기 위한 인터페이스(부모)의 참조변수 생성
		Action action=null;
		
		//요청정보를 비교하여 모델 클래스로 인스턴스 생성하여 참조변수에 저장
		if(command.equals("/loginForm.do")) {
			action=new LoginFormModel();	
		} else if(command.equals("/login.do")) {
			action=new LoginModel();		
		} else if(command.equals("/logout.do")) {
			action=new LogoutModel();	
		} else if(command.equals("/writeForm.do")) {
			action=new WriteFormModel();
		} else if(command.equals("/write.do")) {
			action=new WriteModel();
		} else if(command.equals("/list.do")) {
			action=new ListModel();
		} else if(command.equals("/view.do")) {
			action=new ViewModel();
		} else if(command.equals("/modifyForm.do")) {
			action=new ModifyFormModel();
		} else if(command.equals("/modify.do")) {
			action=new ModifyModel();
		} else if(command.equals("/remove.do")) {
			action=new RemoveModel();
		} else if(command.equals("/error.do")) {
			action=new ErrorModel();
		} else {//요청정보가 존재하지 않을 경우 - 비정상적인 요청
			action=new ErrorModel();
		}
		*/
		
		//요청정보(Key)를 이용하여 actionMap 필드에 저장된 Model 인스턴스(Value)를 반환받아 저장
		Action action=actionMap.get(command);
	
		//요청정보(Key)가 존재하지 않을 경우 에러페이지 응답
		if(action==null) {
			action=actionMap.get("/error.do");
		}
		
		//참조변수에 저장된 모델 인스턴스의 요청 처리 메소드 호출하여 결과(이동정보)를 반환받아 저장
		ActionForward actionForward=action.execute(request, response);
		
		//4.반환받은 결과를 이용하여 페이지 이동 처리
		if(actionForward.isForward()) {//포워드 이동 
			//다른 웹어플리케이션으로 스레드(프로그램의 흐름)를 이동 - 제어권 이동
			// => 클라이언트 브라우저의 주소창에 변화가 없으며 request scope의 객체 공유 가능
			//HttpServletRequest.getRequestDispatcher(String path) 
			// => 제어권을 이동하기 위한 RequestDispatcher 인스턴스를 반환하는 메소드 
			//RequestDispatcher.forward(ServletRequest Request, ServletResponse response)
			// => RequestDispatcher 인스턴스로 제어권을 이동하는 메소드 
			request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
		} else {//리다이렉트 이동
			//클라이언트에게 URL 주소를 전달하여 재요청 하도록 설정
			// => 클라이언트 브라우저의 주소창에 변화가 있으며 request scope의 객체 공유 불가능
			response.sendRedirect(actionForward.getPath());
		}
	}
}
