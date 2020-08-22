package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import site.itwill10.dto.Hewon;

@Controller
//@SessionAttributes : ��Ʈ�ѷ��� ����� ��� ��ûó�� �޼ҵ�� �� 
//���������� �����Ͽ� ����� �ν��Ͻ��� �����ϱ� ���� ������̼�
// => Model�� �̿��Ͽ� �ν��Ͻ��� ������ ��� Request Scope�� �����ϴ� ���� �ƴ� Session Scope�� ����
// => �ٸ� ������ ó���� �ʿ��� ������ �����ϴ� �۾��� ���� - ���� ó���� ���
//value �Ӽ� : Session Scope�� ������ �ν��Ͻ��� �����Ӽ����� �Ӽ������� ����
@SessionAttributes(value = "hewon")
public class SessionController {
	//���̵� ���޹޾� ȸ�������� �˻��Ͽ� �����ϴ� ��ûó�� �޼ҵ�
	// => JSP ������ ������ ȸ������ ���
	@RequestMapping("/hewon_view")
	public String hewonView(Model model) {
		//���̵� �����Ͽ� �ش� ���̵��� ȸ�������� ��ȯ�ϴ� Service Ŭ������ �޼ҵ� ȣ��
		Hewon hewon=getHewon("abc");
		
		//Model�� �̿��Ͽ� �ν��Ͻ��� ������ ��� �⺻������ Request Scope�� ���  
		//model.addAttribute("hewon", hewon);
		//�����Ӽ����� �����ϸ� ���� �ν��Ͻ��� Ŭ�������� �����Ӽ������� �ڵ� ����
		// => Ŭ�������� ù���ڴ� �ҹ��ڷ� ��ȯ�Ǿ� ���
		//@SessionAttributes ������̼ǿ� ���� Session Scope�� �ν��Ͻ� ����
		model.addAttribute(hewon);
		
		//���� JSP ���� �̵�
		return "session/hewon_view";
	}
	
	/*
	//���̵� ���޹޾� ȸ�������� �˻��Ͽ� �����ϴ� ��ûó�� �޼ҵ�
	// => JSP ������ ������ ȸ�������� �Է��±׿� ���
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate(@RequestParam String id,Model model) {
		//���̵� �����Ͽ� �ش� ���̵��� ȸ�������� ��ȯ�ϴ� Service Ŭ������ �޼ҵ� ȣ��		Hewon hewon=getHewon(id);
		Hewon hewon=getHewon(id);
		
		model.addAttribute(hewon);
		
		//���� JSP ���� �̵�
		return "session/hewon_update";
	}
	*/
	
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate() {
		//@SessionAttributes ������̼ǿ� ���� ������ �ν��Ͻ��� ������������ ���
		return "session/hewon_update";
	}
	
	//�Էµ� ����ȸ�������� ���޹޾� ȸ�������� �����ϴ� ��ûó�� �޼ҵ�
	//�Ű������� Command ��ü�� ����� ��� @SessionAttributes ������̼ǿ�
	//���� ������ �ν��Ͻ��� �����ϸ� �Ű������� �����Ͽ� ����
	// => �Է°��� ���޵Ǹ� Setter �޼ҵ带 �ڵ� ȣ���Ͽ� �ʵ尪 ����
	//SessionStatus : @SessionAttributes ������̼ǿ� ���� ������ �ν��Ͻ��� 
	//���������� �����޾� ����ϱ� ���� �ν��Ͻ�
	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String hewonUpdate(@ModelAttribute Hewon hewon, SessionStatus status) {
		//ȸ�������� �����Ͽ� �����ϴ� Service Ŭ������ �޼ҵ� ȣ�� - ����
		
		//�Է°��� ��� @SessionAttributes ������̼ǿ� ���� ������ �ν��Ͻ��� �ʵ尪 ���
		System.out.println("���̵� = "+hewon.getId());
		
		//SessionStatus.setComplete() : @SessionAttributes ������̼ǿ� 
		//���� ������ �ν��Ͻ��� �����ϴ� �޼ҵ�
		status.setComplete();
		
		//���� JSP ���� �̵�
		return "session/hewon_view";
	}
	
	private Hewon getHewon(String id) {
		Hewon hewon=new Hewon();
		hewon.setId(id);
		hewon.setPasswd("123456");
		hewon.setName("ȫ�浿");
		hewon.setEmail("abc@itwill.site");
		hewon.setGender("����");
		return hewon;
	}
}