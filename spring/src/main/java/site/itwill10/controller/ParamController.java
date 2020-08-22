package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	//�Է������� ��û >> ���� �Է��Ͽ� ó��(���)�������� �����Ͽ� ��û
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}
	
	/*
	//ó��(���)������ ��û
	//��ûó�� �޼ҵ�� �����ε� ���� ����
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "param_result";
	}
	*/
	
	/*
	//�Ű������� �����ϸ� ���ް��� Spring Container�κ��� �ڵ����� ���޹޾� ����
	// => �Է��±��� name �Ӽ����� �Ű������� �̸��� ���� ��쿡�� ����
	// => �Է��±��� name �Ӽ����� �Ű������� �̸��� �ٸ� ��� �Ű��������� �⺻��(NULL) ����
	//�Է°��� �ڵ����� ���޹޾� �����ϱ� ���� �Է°��� ���� ĳ���ͼ� ����
	// => ���ڵ� ���͸� ����Ͽ� ��ûó�� �� �̸� ĳ���ͼ� ���� ���� - web.xml ����
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(String name,Model model) {
		model.addAttribute("name",name);
		return "param_result";
	}
	*/
	
	/*
	//@RequestParam : ��ûó�� �޼ҵ忡�� �Է°��� ���޹޾� �����ϴ� �Ű������� ����ϴ� ������̼�
	// => �Է��±��� name �Ӽ����� �Ű������� �̸��� ���� ���� ��� 400 ���� �߻�
	// => �ݵ�� �Է°��� ���޹޾� �����ؾ� �Ǵ� �Ű������� �����ϱ� ���� ���
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam String name,Model model) {
		model.addAttribute("name",name);
		return "param_result";
	}
	*/
	
	/*
	//@RequestParam ������̼ǿ� value �Ӽ��� �Ӽ������� �Է��±��� name �Ӽ����� ����
	// => �Է��±��� name �Ӽ����� �Ű������� �̸��� Ʋ�� ��쿡�� �Է°��� ���޹޾� ������ �� ���
	// => value �Ӽ��� ������ ��� �Ӽ����� ���� ����
	// => value �Ӽ� ��� name �Ӽ� ��� ����
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam("userName") String name,Model model) {
		model.addAttribute("name",name);
		return "param_result";
	}
	*/
	
	/*
	//@RequestParam ������̼ǿ� defaultValue �Ӽ��� �Ӽ������� �Ű������� ����� �ʱⰪ ����
	// => �Է°��� ���ų� �Է��±��� name �Ӽ����� ���� �̸��� �Ű������� �ƴ� ��� ���
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(defaultValue="�Ӳ���") String name,Model model) {
		model.addAttribute("name",name);
		return "param_result";
	}
	*/
	
	//@RequestParam ������̼ǿ� required �Ӽ��� �Ӽ������� false�� ������ ���
	//�Է°��� ���޵��� �ʾƵ� 400 ���� �̹߻�(�ʼ� �Է¿�Ұ� �ƴ� ��� ����)
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(required = false) String name,Model model) {
		model.addAttribute("name",name);
		return "param_result";
	}
}





