package site.itwill05.di;

import java.util.List;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Component("studentService")

//@Service : 클래스를 Spring Bean으로 등록하기 위한 어노테이션
// => Service 클래스를 Spring Bean으로 등록할 경우 사용
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	/*
	//@Resource : Spring Bean의 자동 인젝션 기능을 제공하기 위한 어노테이션
	// => JDK 라이브러리에서 제공하는 어노테이션
	@Resource
	private StudentDAO studentDAO;
	*/

	//@Autowired : Spring Bean의 자동 인젝션 기능을 제공하기 위한 어노테이션
	// => Spring 라이브러리에서 제공하는 어노테이션
	// => bean 엘리먼트의 autowire 속성의 byType 속성값과 동일한 기능을 제공
	// => Setter Injection을 이용하여 의존성 주입을 하지만 Setter 메소드 없이 자동으로 인젝션 구현
	//문제점)필드의 자료형이 인터페이스인 경우 자식클래스의 Spring Bean이 여러 개 등록된 경우 인젝션 예외 발생
	//해결-1)자식클래스의 Spring Bean이 여러 개 등록된 경우 byName 속성값으로 자동 인젝션
	// => 여러개의 Spring Bean 중 인젝션하고자 하는 Spring Bean의 beanName를 필드이름과 동일하게 변경
	//해결-2)@Qualifier 어노테이션을 이용하여 인젝션 하고자 하는 Spring Bean을 직접 설정
	@Autowired
	//@Qualifier : beanName의 설정하여 원하는 Spring Bean이 인젝션되도록 지원하는 어노테이션
	// => @Autowired 어노테이션에 종속된 어노테이션
	//@Qualifier("studentJdbcDAO")
	@Qualifier("studentMybatisDAO")
	private StudentDAO studentDAO;
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	
	/*
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	*/

	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 addStudent() 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudent() 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectAllStudent();
	}

}
