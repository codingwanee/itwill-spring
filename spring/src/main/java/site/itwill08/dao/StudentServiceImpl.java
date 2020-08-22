package site.itwill08.dao;

import java.util.List;

public class StudentServiceImpl implements StudentService {
	//Bean Configuration File���� StudentDAO Ŭ���� ���� Spring Bean�� �ʵ忡 Injection
	// => Service Ŭ������ �޼ҵ带 �ۼ��� DAO Ŭ������ �޼ҵ� ȣ��
	// => �ʵ� �ڷ����� �������̽��� �����Ͽ� �ڽ� �ν��Ͻ��� ������ ���� ����
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
