package site.itwill.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import site.itwill10.dto.Student;
import site.itwill10.service.StudentService;

//JUnit 라이브러리는 모듈 단위의 프로그램(Service 클래스)을 테스트하는 용도로 사용
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration : WebApplicationContext 인스턴스(Spring Container)를
//이용하여 Bean Configuration File에 설정된 클래스를 Spring Bean으로 등록
// => SpringMVC 관련 클래스에 대한 테스트 프로그램을 작성할 때 사용
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
	,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class StudentServiceTest {
	private final static Logger logger=LoggerFactory.getLogger(MybatisTest.class);

	@Autowired
	private StudentService studentService;
	
	/*
	@Test
	public void testAddStudent() {
		Student student=new Student();
		student.setNo(8000);
		student.setName("홍길동");
		student.setPhone("010-8888-8888");
		student.setAddress("서울시 도봉구");
		student.setBirthday("1991-10-17");
		studentService.addStudent(student);
		logger.info("학생정보 추가 관련 기능 성공");
	}
	*/
	
	@Test
	public void testGetStudentList() {
		List<Student> studentList=studentService.getStudentList();
		for(Student student:studentList) {
			//logger.info(student.getNo()+","+student.getName()+","+student.getPhone()
			//	+","+student.getAddress()+","+student.getBirthday().substring(0,10));
			logger.info(student.toString());
		}
	}
}








