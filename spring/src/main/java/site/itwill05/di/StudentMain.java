package site.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("05-1_di.xml");
		System.out.println("=========================================================================");
		Student student1=context.getBean("student1", Student.class);
		System.out.println(student1);//Student Ŭ������ toString() �޼ҵ� �ڵ� ȣ��
		System.out.println("=========================================================================");
		Student student2=context.getBean("student2", Student.class);
		System.out.println(student2);
		System.out.println("=========================================================================");
		Student student3=context.getBean("student3", Student.class);
		System.out.println(student3);
		System.out.println("=========================================================================");
		Student student4=context.getBean("student4", Student.class);
		System.out.println(student4);
		System.out.println("=========================================================================");
		Student student5=context.getBean("student5", Student.class);
		System.out.println(student5);
		System.out.println("=========================================================================");
		//Spring Container�κ��� Service Ŭ������ Spring Bean���� �����޾� ����
		//StudentServiceImpl studentServiceImpl=context.getBean("studentServiceImpl",StudentServiceImpl.class);
		//StudentService studentService=context.getBean("studentServiceImpl",StudentServiceImpl.class);
		StudentService studentService=context.getBean("studentServiceImpl",StudentService.class);
		
		//�������� Spring Bean�� �޼ҵ� ȣ��
		/*
		studentServiceImpl.addStudent(null);
		studentServiceImpl.getStudent(0);
		studentServiceImpl.getStudentList();
		*/
		studentService.addStudent(null);
		studentService.getStudent(0);
		studentService.getStudentList();
		System.out.println("=========================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}




