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

//Rest(RePresentational State Transfer) ����� �����ϴ� ��Ʈ�ѷ�
// => �ϳ��� ��û URL �ڿ��� �ϳ��� ���ҽ��� ��ǥ�ϵ��� ����
// => �پ��� ��⿡�� ��û�� ���� �������� ���������� ó���� �� �ִ� ������ ����Ÿ�� �����ϴ� ���� ����
// => XML �Ǵ� JSON�� �̿��Ͽ� ���� ��� ���� - ������ ������ ����
// => �������� Ajax ������� ��û�ϰ� ���� ����� �����޾� DHTML�� �̿��Ͽ� ���
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
	//@ResponseBody : ��ȯ����� ViewResolver���� �������� �ʰ� ��ûó��
	//�޼ҵ忡�� ���� ����ó�� �ϵ��� �����ϴ� ������̼�
	// => �ؽ�Ʈ ����Ÿ(XML �Ǵ� JSON)�� �����ϰ��� �� ��� ���
	//@RequestBody : POST, PUT, DELETE ���� ��û�� ���� ���޵� ��� �Է°���
	//JSON ������ �ؽ�Ʈ ����Ÿ(JavaScript ��ü)�� ���޹޾� �����ϱ� ���� ������̼�
	// => GET ������� ���޵� ����Ÿ ���� �Ұ���
	// => AJAX ��û�� ���� �Է°��� �����ϱ� ���� ���
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
	
	//Ŭ���̾�Ʈ ��û�� ���� ȸ�������� XML �ؽ�Ʈ ����Ÿ �����ϴ� ��ûó�� �޼ҵ�
	// => ���ڿ��� �ƴ� �ν��Ͻ��� ������ ��� 500 ���� �߻�
	// => �ν��Ͻ��� XML �Ǵ� JSON ������ �ؽ�Ʈ ����Ÿ�� �ڵ� ��ȯ�Ͽ� ����ó�� �ǵ��� ����
	@RequestMapping("/xml_member")
	@ResponseBody
	public RestMemberXML restMemberXML() {
		return restMemberService.getRestMemberListXML().get(0);
	}
	
	//Ŭ���̾�Ʈ ��û�� ���� ȸ������� XML �ؽ�Ʈ ����Ÿ �����ϴ� ��ûó�� �޼ҵ�
	/*
	//List �ν��Ͻ��� ���� Ŭ������ XML ��ȯ�ǵ��� ���� �Ұ���   
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
	
	//Ŭ���̾�Ʈ ��û�� ���� ȸ�������� JSON �ؽ�Ʈ ����Ÿ �����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping("/json_member")
	@ResponseBody
	public RestMemberJSON restMemberJSON() {
		return restMemberService.getRestMemberListJSON().get(0);
	}
	
	//Ŭ���̾�Ʈ ��û�� ���� ȸ������� JSON �ؽ�Ʈ ����Ÿ �����ϴ� ��ûó�� �޼ҵ�
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
	
	//��� �Է°��� Map �ν��Ͻ��� ���޹޾� ���� ó��
	// => Map �ν��Ͻ��� ��ȯ�ϸ� �ڵ����� JSON �ؽ�Ʈ ����Ÿ�� ��ȯ�Ǿ� ����
	// => JavaBean Ŭ������ ���� ��� Map �ν��Ͻ��� �̿��Ͽ� ���� ó��
	@RequestMapping(value = "/json_map",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> input(@RequestParam Map<String,String> map) {
		return map;
	}
	
	//ResponseEntity : ��û�� ���� ������ ���� �����ϱ� ���� Ŭ����
	// => @ResponseBody ������̼��� ��Ȱ�� �����ϴ� Ŭ����
	// => ���׸��� ���� �ν��Ͻ��� ����
	@RequestMapping("/member_list")
	public ResponseEntity<List<RestMemberJSON>> restMemnerList() {
		ResponseEntity<List<RestMemberJSON>> entity=null;
		try {
			//ResponseEntity �ν��Ͻ� ������ ��û�� ���� ���� ����� �����ڵ带 ���� 
			entity=new ResponseEntity<List<RestMemberJSON>>
				(restMemberService.getRestMemberListJSON(), HttpStatus.OK);	
		} catch (Exception e) {
			//ResponseEntity �ν��Ͻ� ������ ��û�� ���� �����ڵ带 ���� 
			entity=new ResponseEntity<List<RestMemberJSON>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping("/handlebars")
	public String handlebars() {
		return "rest/handlebars";
	}
}








