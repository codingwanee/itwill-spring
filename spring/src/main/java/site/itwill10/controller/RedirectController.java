package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_display")
	public String forwardDisplay(Model model) {
		//Model�� �̿��� �ν��Ͻ� ����(Request Scope) - ��ûó�� �޼ҵ��� �������� ����
		model.addAttribute("name", "ȫ�浿");
		
		//��������(JSP ����)�� ������ �̵� - ������������ ������ �ν��Ͻ� ���
		return "redirect/forward_display";
	}
	
	/*
	@RequestMapping("/redirect_display")
	public String redirectDisplay(Model model) {
		model.addAttribute("name", "ȫ�浿");
		return "redirect/redirect_display";
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		//��ȯ�Ǵ� ���ڿ�(ViewName)�� redirect ���λ�(Namespace)�� �̿��Ͽ� �����̷�Ʈ �̵�
		// => Ŭ���̾�Ʈ���� 301 �����ڵ�� ��û URL�� �����Ͽ� ���û
		// => �������� URL �ּ� ����
		//return "redirect:/forward_display";
		return "redirect:/redirect_display";
	}
	*/
	
	/*
	//�Է°��� �Ű������� ���޹޾� �����Ͽ� ������������ ���
	// => form �±� �Ǵ� QueryString�� �̿��Ͽ� ���� ���޹޾� ���
	@RequestMapping("/redirect_display")
	public String redirectDisplay(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "redirect/redirect_display";
	}
	
	@RequestMapping("/redirect")
	public String redirect(Model model) {
		//������ �̵��� ���������� �ν��Ͻ� ����(Request Scope)
		model.addAttribute("name", "ȫ�浿");
		
		//�����̷�Ʈ�� ���� ����� ��ûó�� �޼ҵ��� �������������� ���� �ν��Ͻ� ��� �Ұ���
		// => Request Scope�� ������ �ν��Ͻ��� �����̷�Ʈ �̵��� ���������� ��� �Ұ���
		//Model�� ���� ������ �ν��Ͻ��� ���ڿ��� ��� �����̷�Ʈ ��������
		//QueryString �������� ���޵Ǿ� ����� �� ������ ���ڿ��� �ƴ� ��� ���� �Ұ���
		return "redirect:/redirect_display";
	}
	*/
	
	@RequestMapping("/redirect_display")
	public String redirectDisplay() {
		return "redirect/redirect_display";
	}
	
	//RedirectAttributes : �����̷�Ʈ �̵��� ���� ����� ��ûó�� �޼ҵ���
	//���������� �ν��Ͻ��� �����ϱ� ���� ����� �����ϴ� �ν��Ͻ�
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes) {
		//RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
		// => �����̷�Ʈ �̵��� ���� ����� ��ûó�� �޼ҵ��� ������������ �ν��Ͻ��� �����ϴ� �޼ҵ� 
		attributes.addFlashAttribute("name", "ȫ�浿");
		return "redirect:/redirect_display";
	}
}