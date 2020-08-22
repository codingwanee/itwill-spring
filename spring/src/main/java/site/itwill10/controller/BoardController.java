package site.itwill10.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import site.itwill10.dto.RestBoard;
import site.itwill10.service.RestBoardService;
import site.itwill10.util.Pager;


@Controller
//@RestController : 모든 요청처리 메소드가 응답처리 되도록 설정하는 어노테이션
// => 요청처리 메소드에 @ResponseBody 어노테이션을 사용하지 않아도 응답처리
// => REST 서비스를 제공하는 컨트롤러를 작성할 경우 사용
//@RestController
public class BoardController {
	@Autowired
	private RestBoardService restBoardService;
	
	@RequestMapping("/board")
	public String restBoard() {
		return "rest/board";
	}

	//Advanced REST Client 프로그램을 검색하여 크롬 앱 설치
	// => REST 기능을 제공하는 페이지 요청에 대한 JSON 응답 결과를 확인하기 위한 테스트 프로그램
	@RequestMapping(value = "/board_list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
		//REST_BOARD 테이블에 저장된 검색 게시글의 갯수를 반환받아 저장
		int totalArticle=restBoardService.getCountRestBoard();
		
		int pageSize=5;//페이지에 출력될 게시글의 갯수
		int blockSize=5;//블럭에 검색될 페이지 갯수
		
		Pager pager=new Pager(pageNum, totalArticle, pageSize, blockSize);
		
		//Service 클래스의 메소드를 호출하기 위한 Map 인스턴스 생성 및 요소 저장
		Map<String, Object> pagerMap=new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());
		pagerMap.put("endRow", pager.getEndRow());
		
		//JSON 텍스트 데이타로 반환하기 위한 Map 인스턴스 생성 및 요소 저장
		Map<String, Object> map=new HashMap<String, Object>();
		//출력될 게시글 목록을 반환받아 저장
		map.put("restBoardList", restBoardService.getRestBoardList(pagerMap));
		//페이징 처리에 필요한 인스턴스를 저장
		map.put("pager", pager);
		
		return map;
	}
	
	@RequestMapping(value = "/board_add", method = RequestMethod.POST)
	@ResponseBody
	public String restBoardAdd(@RequestBody RestBoard board) {
		board.setContent(HtmlUtils.htmlEscape(board.getContent()));
		restBoardService.addRestBoard(board);
		return "success";
	}
	
	/*
	@RequestMapping(value = "/board_view", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@RequestParam int num) {
		return restBoardService.getRestBoard(num);
	}
	*/
	
	//요청 페이지의 정보를 이용하여 값을 전달받아 사용 가능
	// => 요청 페이지의 URL 주소에 {변수} 형식으로 표현
	// => @PathVariable 어노테이션을 이용하여 전달값을 매개변수에 저장
	//요청 페이지의 변수명과 매개변수명이 반드시 동일하도록 작성
	// => 변수명과 매개변수명이 다른 경우 @PathVariable 어노테이션에 value 속성을 이용하여 변수값을 전달받아 저장
	@RequestMapping(value = "/board_view/{num}", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@PathVariable int num) {
		return restBoardService.getRestBoard(num);
	}
	
	//method 속성값 : GET(검색), POST(저장), PUT(전체 변경), PATCH(부분 변경), DELETE(삭제) 등
	// => AJAX 요청에 대한 구분을 위해 사용
	//요청방식이 여러 개인 경우 {} 안에 요청방식을 나열하여 선언
	@RequestMapping(value = "/board_modify", method = {RequestMethod.PUT, RequestMethod.PATCH})
	@ResponseBody
	public String restBoardModify(@RequestBody RestBoard board) {
		restBoardService.modifyRestBoard(board);
		return "success";
	}
	
	@RequestMapping(value = "/board_erase/{num}", method = RequestMethod.DELETE)
	@ResponseBody
	public String restBoardErase(@PathVariable int num) {
		restBoardService.eraseRestBoard(num);
		return "success";
	}
}





