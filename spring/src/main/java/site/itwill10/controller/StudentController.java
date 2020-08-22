package site.itwill10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Student;
import site.itwill10.service.StudentService;

//Controller 클래스 : 클라이언트 요청을 처리하기 위한 메소드가 선언된 클래스
// => Service 클래스의 메소드를 호출하여 클라이언트 요청 처리
//@Controller : Controller 클래스를 Spring Bean으로 등록하기 위한 어노테이션
@Controller
//컨트롤러 클래스에 @RequestMapping 어노테이션을 선언하여 요청처리 메소드의 
//URL 주소 앞에 공통적으로 사용될 주소가 포함되도록 설정
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	//@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "student/add_student";
	}
	
	//@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student,Model model) {
		try {
			studentService.addStudent(student);
		} catch (Exception e) {
			model.addAttribute("message", "이미 사용중인 학번을 입력 하였습니다.");
			return "student/add_student";
		}
		return "redirect:/student/display";
	}
	
	//@RequestMapping("/student/display")
	@RequestMapping("/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/display_student";
	}
}