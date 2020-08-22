package site.itwill08.dao;

import java.util.List;

public class StudentServiceImpl implements StudentService {
	//Bean Configuration File에서 StudentDAO 클래스 관련 Spring Bean을 필드에 Injection
	// => Service 클래스의 메소드를 작성시 DAO 클래스의 메소드 호출
	// => 필드 자료형을 인터페이스로 선언하여 자식 인스턴스로 의존성 주입 가능
	private StudentDAO studentDAO;
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void addStudent(StudentDTO student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(StudentDTO student) {
		studentDAO.updateStudent(student);		
	}

	@Override
	public void removeStudent(int no) {
		studentDAO.deleteStudent(no);
	}

	@Override
	public StudentDTO getStudent(int no) {
		return studentDAO.selectStudent(no);
	}

	@Override
	public List<StudentDTO> getStudentList() {
		return studentDAO.selectAllStudent();
	}

}
