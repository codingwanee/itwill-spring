package site.itwill05.di;

import java.util.List;

//Service Ŭ���� : ���α׷� �ۼ��� �ʿ��� ����� �����ϱ� ���� �޼ҵ尡 ����� Ŭ���� - ���, ���۳�Ʈ
// => DAO Ŭ������ �޼ҵ带 ȣ���Ͽ� �ʿ��� ����� �����ϴ� �޼ҵ� �ۼ�
public class StudentServiceImpl implements StudentService {
	//Service Ŭ������ �޼ҵ忡�� DAO Ŭ������ �޼ҵ带 ȣ���� �� �ֵ��� DAO �ν��Ͻ��� �����ϴ� �ʵ� ����
	
	//DAO Ŭ������ �̿��Ͽ� �ʵ� ���� : DAO Ŭ������ ����� ��� �ʵ� �缱��
	// => DAO Ŭ������ Service Ŭ������ ���յ��� ���� �������� ȿ���� ����
	//private StudentJdbcDAO studentJdbcDAO;//����
	//private StudentMybatisDAO studentMybatisDAO;
	
	//DAO �������̽��� �̿��Ͽ� �ʵ� ���� : DAO Ŭ������ ����Ǿ �ʵ� �缱�� ���ʿ�
	// => DAO �������̽��� ��ӹ޾� �ڽ�Ŭ������ �ν��Ͻ� ����
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}

	/*
	public StudentServiceImpl(StudentDAO studentJdbcDAO) {
		super();
		this.studentJdbcDAO = studentJdbcDAO;
		System.out.println("### StudentServiceImpl Ŭ������ �Ű�����(DAO)�� �����ϴ� ������ ȣ�� ###");
	}

	public StudentDAO getStudentJdbcDAO() {
		return studentJdbcDAO;
	}

	public void setStudentJdbcDAO(StudentDAO studentJdbcDAO) {
		this.studentJdbcDAO = studentJdbcDAO;
		System.out.println("+++ StudentServiceImpl Ŭ������ setStudentJdbcDAO() �޼ҵ� ȣ�� +++");
	}
	*/
	
	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### StudentServiceImpl Ŭ������ �Ű�����(DAO)�� �����ϴ� ������ ȣ�� ###");
	}
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("+++ StudentServiceImpl Ŭ������ setStudentDAO() �޼ҵ� ȣ�� +++");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ addStudent() �޼ҵ� ȣ�� ***");
		//�ʵ忡 NULL�� ����� ��� NullPointerException �߻�
		// => �ʵ忡�� DAO Ŭ������ �ν��Ͻ��� �ݵ�� ����ǵ��� ����
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudent() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);		
	}
	
	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectAllStudent();
	}
}






