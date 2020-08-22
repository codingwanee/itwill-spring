package site.itwill08.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		System.out.println("=============================================================================");
		StudentService service=context.getBean("studentService", StudentService.class);
		/*
		StudentDTO student=new StudentDTO();
		student.setNo(6000);
		student.setName("∑Œ∫Û» ");
		student.setPhone("010-6666-6666");
		student.setAddress("¿Œ√µΩ√ ø˘πÃ±∏");
		student.setBirthday("1999-01-20");
		service.addStudent(student);
		*/
		
		/*
		StudentDTO searchStudent=service.getStudent(6000);
		searchStudent.setBirthday("2000-10-10");
		service.modifyStudent(searchStudent);
		*/
		
		//service.removeStudent(6000);
		
		List<StudentDTO> studentList=service.getStudentList();
		
		for(StudentDTO stu:studentList) {
			System.out.println(stu.getNo()+", "+stu.getName()+", "+stu.getPhone()
				+", "+stu.getAddress()+", "+stu.getBirthday().substring(0, 10));
		}
		System.out.println("=============================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
