package site.itwill10.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.itwill10.dto.RestMemberJSON;
import site.itwill10.dto.RestMemberListXML;
import site.itwill10.dto.RestMemberXML;
import site.itwill10.service.RestMemberService;

//Rest(RePresentational State Transfer) 기능을 제공하는 컨트롤러
// => 하나의 요청 URL 자원이 하나의 리소스를 대표하도록 제공
// => 다양한 기기에서 요청에 대한 응답결과를 공통적으로 처리할 수 있는 형식의 데이타로 전달하는 것이 목적
// => XML 또는 JSON를 이용하여 응답 결과 제공 - 정보의 전달을 목적
// => 웹에서는 Ajax 기능으로 요청하고 응답 결과를 제공받아 DHTML를 이용하여 출력
@Controller
public class RestfulController {
	@Autowired
	private RestMemberService restMemberService;
	
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String rest() {
		return "rest/input";
	}
	
	/*
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public String rest(@RequestParam String id, @RequestParam String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "rest/result";
	}
	*/
	
	/*
	//@ResponseBody : 반환결과를 ViewResolver에게 전달하지 않고 요청처리
	//메소드에서 직접 응답처리 하도록 설정하는 어노테이션
	// => 텍스트 데이타(XML 또는 JSON)로 응답하고자 할 경우 사용
	//@RequestBody : POST, PUT, DELETE 등의 요청에 의해 전달된 모든 입력값을
	//JSON 형식의 텍스트 데이타(JavaScript 객체)로 전달받아 저장하기 위한 어노테이션
	// => GET 방식으로 전달된 데이타 저장 불가능
	// => AJAX 요청에 대한 입력값을 전달하기 위해 사용
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	@ResponseBody
	public String rest(@RequestBody String data) {
		return data;
	}
	*/
	
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public @ResponseBody String rest(@RequestBody String data) {
		return data;
	}
	
	//클라이언트 요청에 대해 회원정보를 XML 텍스트 데이타 응답하는 요청처리 메소드
	// => 문자열이 아닌 인스턴스로 응답할 경우 500 에러 발생
	// => 인스턴스를 XML 또는 JSON 형식의 텍스트 데이타로 자동 변환하여 응답처리 되도록 설정
	@RequestMapping("/xml_member")
	@ResponseBody
	public RestMemberXML restMemberXML() {
		return restMemberService.getRestMemberListXML().get(0);
	}
	
	//클라이언트 요청에 대해 회원목록을 XML 텍스트 데이타 응답하는 요청처리 메소드
	/*
	//List 인스턴스에 대한 클래스를 XML 변환되도록 설정 불가능   
	@RequestMapping("/xml_list")
	@ResponseBody
	public List<RestMemberXML> restMemberListXML() {
		return restMemberService.getRestMemberListXML();
	}
	*/
	
	@RequestMapping("/xml_list")
	@ResponseBody
	public RestMemberListXML restMemberListXML() {
		RestMemberListXML listXML=new RestMemberListXML();
		listXML.setRestMemberList(restMemberService.getRestMemberListXML());
		return listXML;
	}
	
	@RequestMapping("/xml_display")
	public String displayXML() {
		return "rest/display_xml";
	}
	
	//클라이언트 요청에 대해 회원정보을 JSON 텍스트 데이타 응답하는 요청처리 메소드
	@RequestMapping("/json_member")
	@ResponseBody
	public RestMemberJSON restMemberJSON() {
		return restMemberService.getRestMemberListJSON().get(0);
	}
	
	//클라이언트 요청에 대해 회원목록을 JSON 텍스트 데이타 응답하는 요청처리 메소드
	@RequestMapping("/json_list")
	@ResponseBody
	public List<RestMemberJSON> restMemberListJSON() {
		return restMemberService.getRestMemberListJSON();
	}
	
	@RequestMapping("/json_display")
	public String displayJSON() {
		return "rest/display_json";
	}
	
	@RequestMapping(value = "/json_map",method = RequestMethod.GET)
	public String input() {
		return "rest/input";
	}
	
	//모든 입력값을 Map 인스턴스로 전달받아 응답 처리
	// => Map 인스턴스를 반환하면 자동으로 JSON 텍스트 데이타로 변환되어 응답
	// => JavaBean 클래스가 없는 경우 Map 인스턴스를 이용하여 응답 처리
	@RequestMapping(value = "/json_map",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> input(@RequestParam Map<String,String> map) {
		return map;
	}
	
	//ResponseEntity : 요청에 대한 응답을 직접 제공하기 위한 클래스
	// => @ResponseBody 어노테이션의 역활을 수행하는 클래스
	// => 제네릭에 응답 인스턴스를 설정
	@RequestMapping("/member_list")
	public ResponseEntity<List<RestMemberJSON>> restMemnerList() {
		ResponseEntity<List<RestMemberJSON>> entity=null;
		try {
			//ResponseEntity 인스턴스 생성시 요청에 대한 응답 결과와 응답코드를 저장 
			entity=new ResponseEntity<List<RestMemberJSON>>
				(restMemberService.getRestMemberListJSON(), HttpStatus.OK);	
		} catch (Exception e) {
			//ResponseEntity 인스턴스 생성시 요청에 대한 응답코드를 저장 
			entity=new ResponseEntity<List<RestMemberJSON>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping("/handlebars")
	public String handlebars() {
		return "rest/handlebars";
	}
}








