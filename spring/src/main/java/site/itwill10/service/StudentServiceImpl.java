package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.StudentDAO;
import site.itwill10.dto.Student;

//Service 클래스 : DAO 클래스의 메소드를 이용하여 프로그램에 필요한 기능을 제공
//@Service : Service 클래스을 Spring Bean으로 등록하기 위한 어노테이션
@Service
public class StudentServiceImpl implements StudentService {
	//Spring Bean으로 등록된 DAO 인스턴스를 인젝션하여 저장하기 위한 필드
	// => 필드의 자료형을 인터페이스로 선언하여 모든 자식 인스턴스를 인젝션하여 저장할 수 있도록 설정
	//Spring Bean으로 등록된 DAO 인스턴스가 여러 개인 경우 @Qualifier 
	//어노테이션을 이용하여 인젝션 될 Spring Bean 설정 - beanName 사용
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectAllStudent();
	}

}
