package site.itwill09.mvc;

import java.util.HashMap;
import java.util.Map;

//클라이언트 요청정보와 처리 클래스의 인스턴스를 저장하기 위한 필드가 선언된 클래스
// => 클라이언트 요청정보를 이용하여 처리 클래스의 인스턴스를 반환하는 메소드 선언
public class HandlerMapping {
	//Key : 클라이언트 요청정보(String), Value : 처리 클래스의 인스턴스(Controller)
	private Map<String, Controller> mapping;
	
	public HandlerMapping() {
		mapping=new HashMap<String, Controller>();
		initConfig();
	}
	
	//Map 필드에 클라이언트 요청와 처리 클래스의 인스턴스를 저장하기 위한 메소드
	private void initConfig() {
		mapping.put("/list.itwill", new ListController());
		mapping.put("/view.itwill", new ViewController());
	}
	
	//클라이언트 요청정보를 전달받아 처리 클래스의 인스턴스를 반환하는 메소드
	public Controller getController(String command) {
		return mapping.get(command);
	}
}



