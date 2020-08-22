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

//JUnit ���̺귯���� ��� ������ ���α׷�(Service Ŭ����)�� �׽�Ʈ�ϴ� �뵵�� ���
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration : WebApplicationContext �ν��Ͻ�(Spring Container)��
//�̿��Ͽ� Bean Configuration File�� ������ Ŭ������ Spring Bean���� ���
// => SpringMVC ���� Ŭ������ ���� �׽�Ʈ ���α׷��� �ۼ��� �� ���
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
		student.setName("ȫ�浿");
		student.setPhone("010-8888-8888");
		student.setAddress("����� ������");
		student.setBirthday("1991-10-17");
		studentService.addStudent(student);
		logger.info("�л����� �߰� ���� ��� ����");
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








