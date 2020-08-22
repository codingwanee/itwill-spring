package site.itwill07.aop;

import java.util.List;

//�ٽɰ��ɸ��(�ٽɰ����ڵ尡 ����� �޼ҵ�)�� ����� Ŭ����
public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ addStudent() �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudent() �޼ҵ� ȣ�� ***");
		//throw new RuntimeException();//���ܹ߻�
		return studentDAO.selectStudent(num);
	}
	
	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectAllStudent();
	}
}






