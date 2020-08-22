package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyncode.jtwig.functions.util.HtmlUtils;

@Controller
public class XssController {
	@RequestMapping(value = "/xss", method = RequestMethod.GET)
	public String xss() {
		return "xss/input";
	}
	
	//XSS : �Է��±׿� ���������� �ڵ带 �Է��Ͽ� ���α׷��� �����ϴ� ���
	// => XSS ���ݿ� ���� �� ���� ���� �ڵ� �ʿ�
	
	//1.�������������� ó�� ��� >> �±� ���� ���ڸ� Escape ���ڷ� ��ȯ
	// => ��ûó�� �޼ҵ忡�� ����� �±׵� Escape ���ڷ� ��ȯ
	// 1) Core �±� ���̺귯���� out �±׸� ����Ͽ� ����ϴ� ���
	// 2) Functions �±� ���̺귯���� escapeXml() EL �Լ��� ����Ͽ� ����ϴ� ���
	
	//2.��ûó�� �޼ҵ忡���� ó�� ���
	// 1) Spring Framework���� �����ϴ� HtmlUtils Ŭ������ htmlEscape() �޼ҵ� ���
	// 2) Apache �׷쿡�� �����ϴ� HtmlUtils Ŭ������ stripTag() �޼ҵ� ���
	@RequestMapping(value = "/xss", method = RequestMethod.POST)
	public String xss(@RequestParam String subject
			, @RequestParam String content,Model model) {
		/*
		model.addAttribute("subject", subject);
		//model.addAttribute("content", content);
		model.addAttribute("content", content.replace("\n", "<br>"));
		*/
		
		//HtmlUtils.htmlEscape(String text) : ���޵� ���ڿ��� �����ϴ�
		//�±� ���� ���ڸ� Escape ���ڷ� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		/*
		model.addAttribute("subject", HtmlUtils.htmlEscape(subject));
		model.addAttribute("content", HtmlUtils.htmlEscape(content).replace("\n", "<br>"));
		*/
		
		//HtmlUtils.stripTags(String text) : ���޵� ���ڿ��� �����ϴ�
		//�±� ���� ���ڸ� ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		model.addAttribute("subject", HtmlUtils.stripTags(subject));
		model.addAttribute("content", HtmlUtils.stripTags(content).replace("\n", "<br>"));
		return "xss/result";
	}
}








