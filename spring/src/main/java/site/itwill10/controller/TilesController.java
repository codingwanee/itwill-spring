package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {
	@RequestMapping("/")
	public String template() {
		//tiles.xml ���Ͽ� ����� definition ������Ʈ�� ������(name �Ӽ���)��
		//viewName���� ��ȯ�ϸ� ������ ���ø� ������(JSP ����)�� �̿��Ͽ� ����
		return "index";
	}
	
	@RequestMapping("/tiles1")
	public String tiles1() {
		return "hello_tiles";
	}
	
	@RequestMapping("/tiles2")
	public String tiles2() {
		return "tiles/hi_tiles";
	}
	
	@RequestMapping("/tiles3")
	public String tiles3() {
		return "tiles/good/bye_tiles";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/admin_hello")
	public String adminHello() {
		return "admin/hello_tiles";
	}
}







