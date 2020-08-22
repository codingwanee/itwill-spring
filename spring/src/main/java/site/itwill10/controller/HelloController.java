package site.itwill10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Controller Ŭ���� : Ŭ���̾�Ʈ�� ��û�� ���� ó�� �޼ҵ尡 ����� Ŭ����
//@Controller : Controller Ŭ������ Spring Bean���� ����ϱ� ���� ������Ʈ
// => Controller �������̽��� ��ӹ��� �ʾƵ� Controller Ŭ������ �ۼ� ����
//Ŭ���̾�Ʈ ��û�� �޾� Ư�� �޼ҵ�� ��û ó�� ���� 
// => �ϳ��� Controller Ŭ������ Ŭ���̾�Ʈ�� ���� ��û�� �޾� ó��
// => @RequestMapping ������̼��� �̿��Ͽ� �޼ҵ� ����
//Spring Bean�� �̸�(beanName)�� �⺻������ Ŭ������ �̿�
// => ������̼��� value �Ӽ��� beanName�� ���Ǵ�� ���� ����
@Controller
public class HelloController {
	private final static Logger logger=LoggerFactory.getLogger(HelloController.class);
	//Front Controller���� viewName�� �����ϴ� ���
	// => ViewResolver Ŭ������ ���� View �������� �ϼ��Ͽ� ������ �̵��Ͽ� ���� ó��
	//1.��ûó�� �޼ҵ��� ��ȯ�� void�� �����Ͽ� �޼ҵ������ viewName ���� 
	//2.��ûó�� �޼ҵ��� ��ȯ�� String�� �����Ͽ� ��ȯ�� ���ڿ��� viewName ����
	//3.��ûó�� �޼ҵ��� ��ȯ�� ModelAndView�� �����Ͽ� ModelAndView �ν��Ͻ��� viewName�� �����Ͽ� ����
	
	//Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� �޼ҵ�
	//@RequestMapping : Ŭ���̾�Ʈ ��û������ �����޾� ó���ϴ� �޼ҵ带 �����ϴ� ������̼�
	// => ������̼��� value �Ӽ������� Ŭ���̾�Ʈ ��û���� ����(������)
	// => value �Ӽ� ��� name �Ӽ� ��� ����
	//�ٸ� @RequestMapping ������̼��� value �Ӽ����� �ߺ��� ��� Spring Bean ���� ���� �߻�
	@RequestMapping(value = "/hello")
	public void hello() {
		//��ûó��
		logger.info("/hello ��û >> hello() �޼ҵ� ȣ��");
	}
	
	//@RequestMapping ������̼ǿ� value �Ӽ��� ������ ��� �Ӽ����� ���� ����
	@RequestMapping("/helloViewName")
	public String helloViewName() {
		logger.info("/helloViewName ��û >> helloViewName() �޼ҵ� ȣ��");
		return "hello";
	}
	
	@RequestMapping("/helloMV")
	public ModelAndView helloModelAndView() {
		logger.info("/helloMV ��û >> helloModelAndView() �޼ҵ� ȣ��");
		/*
		ModelAndView mv=new ModelAndView();
		mv.setViewName("hello");
		*/
		ModelAndView mv=new ModelAndView("hello");
		return mv;
	}
}
