package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Member;

@Controller
public class JoinController {
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	/*
	//�Է��±��� �̸��� �Ű������� �̸��� �ٸ��� �����ص� 400 ���� �̹߻�
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(String id, String passwd, String name, String email
		, String phone1, String phone2, String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_result";
	}
	*/
	
	/*
	//�Է��±��� �̸��� �Ű������� �̸��� �ٸ��� ������ ��� �Ű������� 
	//�Է°��� ���޵Ǿ� ������� �ʾ� 400 ���� �߻�
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
		, @RequestParam String name, @RequestParam String email
		, @RequestParam String phone1, @RequestParam String phone2
		, @RequestParam String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_result";
	}
	*/
	
	/*
	//@ModelAttribute ������̼��� �Է°��� ���޹޾� �����ϴ� �Ű�������
	//������ ��� �Է°��� ���������� �ڵ����� �����ϴ� ��� ����
	//@ModelAttribute ������̼��� value �Ӽ��� �Ӽ������� �����Ӽ��� ����
	// => value �Ӽ��� ������ ��� �⺻������ �Ű������� �ڷ����� �����Ӽ������� �ڵ� ���� - ù���ڴ� �ҹ��ڷ� ��ȯ
	// => value �Ӽ��� ������ ��� �Ӽ����� ���� ����
	//�Է��±��� name �Ӽ����� @ModelAttribute ������̼��� value �Ӽ�����
	//���� ���� ��� �Ű������� ���� ���޵��� �ʾ� ������ - 400 ���� �̹߻�
	// => @ModelAttribute ������̼��� value �Ӽ��� ������ ��� �Ӽ����� �Է��±��� name �Ӽ����� �����ϰ� ����
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute(value = "id") String id
		, @ModelAttribute("passwd") String passwd, @ModelAttribute("name") String name
		, @ModelAttribute("email") String email, @ModelAttribute("phone1") String phone1
		, @ModelAttribute("phone2") String phone2, @ModelAttribute("phone3") String phone3) {
		return "join_result";
	}
	*/
	
	/*
	//�Է��±��� ��� �Է°��� Map �ν��Ͻ��� ��ҷ� �ڵ� ����
	// => @RequestParam ������̼��� ������ ��� ��Ұ� ���� ��(Empty) Map �ν��Ͻ��� ����
	// => �Է��±��� name �Ӽ����� MapKey�� �Ǹ� �Է°��� MapValue�� �ڵ� ����
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@RequestParam Map<String, String> memberMap, Model model) {
		model.addAttribute("memberMap", memberMap);
		return "join_result";
	}
	*/
	
	/*
	//JavaBean Ŭ������ �Ű������� �����ϸ� Spring Container�� ���� JavaBean �ν��Ͻ��� �����Ͽ� �ڵ� ����
	// => �Է��±��� name �Ӽ����� ���� �̸��� �ʵ忡 �Է°��� �ڵ� ����   
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(Member member, Model model) {
		model.addAttribute("member", member);
		return "join_result";
	}
	*/
	
	/*
	//@ModelAttribute ������̼��� �����ϸ� �ڵ����� ���������� �ν��Ͻ� ����
	// => @ModelAttribute ������̼��� �������� �ʾƵ� �ڵ����� ������̼� ����
	// => JavaBean Ŭ������ �̸��� �ڵ����� �����Ӽ������� ���� - ù���ڴ� �ҹ��ڷ� ��ȯ
	//Command ��ü : Spring Container�� ���� �ڵ� �����Ǿ� �Է°��� �ʵ忡 ����Ǵ� ��ü
	// => Command ��ü�� �ڵ����� ���������� �����Ǿ� ��� ����
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		return "join_result";
	}
	*/
	
	/*
	//@ModelAttribute ������̼��� value �Ӽ��� �Ӽ������� �����Ӽ��� ���� ����
	// => value �Ӽ� ��� name �Ӽ� ��� ����
	// => value �Ӽ��� ������ ��� �Ӽ����� ���� ����
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member) {
		return "join_result";
	}
	*/
	
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member, Model model) {
		if(member.getId().equals("abc")) {
			model.addAttribute("message", "�̹� ������� ���̵��Դϴ�.");
			return "join_form";
		}
		return "join_result";
	}
}