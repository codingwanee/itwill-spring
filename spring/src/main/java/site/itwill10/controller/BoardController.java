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
//@RestController : ��� ��ûó�� �޼ҵ尡 ����ó�� �ǵ��� �����ϴ� ������̼�
// => ��ûó�� �޼ҵ忡 @ResponseBody ������̼��� ������� �ʾƵ� ����ó��
// => REST ���񽺸� �����ϴ� ��Ʈ�ѷ��� �ۼ��� ��� ���
//@RestController
public class BoardController {
	@Autowired
	private RestBoardService restBoardService;
	
	@RequestMapping("/board")
	public String restBoard() {
		return "rest/board";
	}

	//Advanced REST Client ���α׷��� �˻��Ͽ� ũ�� �� ��ġ
	// => REST ����� �����ϴ� ������ ��û�� ���� JSON ���� ����� Ȯ���ϱ� ���� �׽�Ʈ ���α׷�
	@RequestMapping(value = "/board_list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
		//REST_BOARD ���̺� ����� �˻� �Խñ��� ������ ��ȯ�޾� ����
		int totalArticle=restBoardService.getCountRestBoard();
		
		int pageSize=5;//�������� ��µ� �Խñ��� ����
		int blockSize=5;//���� �˻��� ������ ����
		
		Pager pager=new Pager(pageNum, totalArticle, pageSize, blockSize);
		
		//Service Ŭ������ �޼ҵ带 ȣ���ϱ� ���� Map �ν��Ͻ� ���� �� ��� ����
		Map<String, Object> pagerMap=new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());
		pagerMap.put("endRow", pager.getEndRow());
		
		//JSON �ؽ�Ʈ ����Ÿ�� ��ȯ�ϱ� ���� Map �ν��Ͻ� ���� �� ��� ����
		Map<String, Object> map=new HashMap<String, Object>();
		//��µ� �Խñ� ����� ��ȯ�޾� ����
		map.put("restBoardList", restBoardService.getRestBoardList(pagerMap));
		//����¡ ó���� �ʿ��� �ν��Ͻ��� ����
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
	
	//��û �������� ������ �̿��Ͽ� ���� ���޹޾� ��� ����
	// => ��û �������� URL �ּҿ� {����} �������� ǥ��
	// => @PathVariable ������̼��� �̿��Ͽ� ���ް��� �Ű������� ����
	//��û �������� ������� �Ű��������� �ݵ�� �����ϵ��� �ۼ�
	// => ������� �Ű��������� �ٸ� ��� @PathVariable ������̼ǿ� value �Ӽ��� �̿��Ͽ� �������� ���޹޾� ����
	@RequestMapping(value = "/board_view/{num}", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@PathVariable int num) {
		return restBoardService.getRestBoard(num);
	}
	
	//method �Ӽ��� : GET(�˻�), POST(����), PUT(��ü ����), PATCH(�κ� ����), DELETE(����) ��
	// => AJAX ��û�� ���� ������ ���� ���
	//��û����� ���� ���� ��� {} �ȿ� ��û����� �����Ͽ� ����
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





