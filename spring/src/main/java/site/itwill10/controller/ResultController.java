package site.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	//��ûó�� �޼ҵ忡�� ��������(JSP ����)�� ó������� �����ϴ� ���
	//1.ModelAndView �ν��Ͻ��� �̿��Ͽ� ó����� ���� - ��ûó�� �޼ҵ��� ��ȯ�� : ModelAndView
	//2.HttpServletRequest �ν��Ͻ��� �̿��Ͽ� ó����� ���� - ��ûó�� �޼ҵ��� ��ȯ�� : String
	//3.Model �ν��Ͻ��� �̿��Ͽ� ó����� ���� - ��ûó�� �޼ҵ��� ��ȯ�� : String
	//4.ModelMap �ν��Ͻ��� �̿��Ͽ� ó����� ���� - ��ûó�� �޼ҵ��� ��ȯ�� : String
	
	/*
	@RequestMapping("/resultMV")
	public ModelAndView modelAnaView() {
		//ModelAndView : ���������� ó������� �����ϰų� viewName�� �����Ͽ� �����ϴ� ����� Ŭ����
		//ModelAndView mv=new ModelAndView();
		//ModelAndView.setViewName(String viewName) : viewName�� �����ϴ� �޼ҵ�
		//mv.setViewName("result_display");
		
		//ModelAndView Ŭ������ �����ڷ� viewName�� �ʱ�ȭ ����
		ModelAndView mv=new ModelAndView("result_display");
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ���������� �ν��Ͻ�(ó�����)�� �����ϴ� �޼ҵ�
		// => attributeName�� ������ ��� ���� �ν��Ͻ��� Ŭ�����̸��� �ڵ����� �����Ӽ������� ����
		// => attributeName�� �ٸ��� �����Ͽ� ���� ���� �ν��Ͻ� ���� ����
		mv.addObject("mv", "ȫ�浿");
		
		return mv;
	}
	*/
	
	//Ŭ���̾�Ʈ ��û�� ���� ��ûó�� �޼ҵ�� Spring Container�� ���� �ڵ� ȣ��
	//��ûó�� �޼ҵ忡 �Ű������� �����ϸ� Spring Container�� �Ű������� 
	//�ν��Ͻ��� �����ϰų� �����޾� �ڵ����� �����Ͽ� ���� 
	@RequestMapping("/resultMV")
	public ModelAndView modelAnaView(ModelAndView mv) {
		mv.setViewName("result_display");
		mv.addObject("mv", "ȫ�浿");
		return mv;
	}
	
	@RequestMapping("/resultRequest")
	public String request(HttpServletRequest request) {
		request.setAttribute("request", "�Ӳ���");
		return "result_display";
	}
	
	//Model : �ν��Ͻ�(ó�����) ������ �������� Spring Framework���� �����ϴ� �ν��Ͻ� - �������̽�
	@RequestMapping("/resultModel")
	public String model(Model model) {
		//Model.addAttribute(String attributeName, Object attributeValue)
		// => ���������� �ν��Ͻ��� �����ϴ� �޼ҵ�
		model.addAttribute("model", "����ġ");
		return "result_display";
	}
	
	//ModelMap : �ν��Ͻ�(ó�����) ������ �������� Spring Framework���� �����ϴ� �ν��Ͻ� - Ŭ����
	@RequestMapping("/resultMap")
	public String modelMap(ModelMap map) {
		//ModelMap.addAttribute(String attributeName, Object attributeValue)
		// => ���������� �ν��Ͻ��� �����ϴ� �޼ҵ�
		map.addAttribute("map", "������");
		return "result_display";
	}
}