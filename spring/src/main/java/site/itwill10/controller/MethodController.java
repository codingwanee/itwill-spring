package site.itwill10.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	//�Է������� ��û >> ���� �Է¹޾� ó��(���)�������� �����Ͽ� ��û
	@RequestMapping("/input1")
	public String input1() {
		return "method_input";
	}
	
	//ó��(���)������ ��û >> ���ް��� ��ȯ�޾� ���
	@RequestMapping("/input2")
	public String output1(HttpServletRequest request) throws UnsupportedEncodingException {
		//���ް��� ���� ĳ���ͼ�(���ڵ�) ����
		// => UnsupportedEncodingException ���� �߻� - ����ó��
		request.setCharacterEncoding("UTF-8");
		
		//���ް��� ��ȯ�޾� ����
		String name=request.getParameter("name");
		
		//��ȯ���� ���ް� ����
		request.setAttribute("name", name);
		
		return "method_output";
	}
	
	//�Է��������� ó��(���)�������� ��û�� ���� URL �ּҸ� �����ϰ� ����(����)
	// => Ŭ���̾�Ʈ ��û�� ���� URL �ּҰ� ������ ��� ���� �߻�
	// => Ŭ���̾�Ʈ ��û����� �ٸ��� �����Ͽ� ����
	//value �Ӽ��� ��û URL �ּҸ� �Ӽ������� �����ϰ� method �Ӽ��� ��û����� �Ӽ������� ����
	// => method �Ӽ��� ������ ��� �⺻������ ��û����� GET ������� ó�� 
	// => method �Ӽ����� RequestMethod(Enum)�� ����ʵ�(ContentField) ��� 
	
	//�Է������� ��û(GET)
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String input2() {
		return "method_input";
	}
	
	//ó��(���)������ ��û(POST)
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String output2(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output";
	}
}




