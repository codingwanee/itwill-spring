package site.itwill05.di;

import java.util.List;

//Service 클래스 : 프로그램 작성에 필요한 기능을 제공하기 위한 메소드가 선언된 클래스 - 모듈, 컴퍼넌트
// => DAO 클래스의 메소드를 호출하여 필요한 기능을 제공하는 메소드 작성
public class StudentServiceImpl implements StudentService {
	//Service 클래스의 메소드에서 DAO 클래스의 메소드를 호출할 수 있도록 DAO 인스턴스를 저장하는 필드 선언
	
	//DAO 클래스를 이용하여 필드 선언 : DAO 클래스가 변경될 경우 필드 재선언
	// => DAO 클래스의 Service 클래스의 결합도가 높이 유지보수 효율성 감소
	//private StudentJdbcDAO studentJdbcDAO;//포함
	//private StudentMybatisDAO studentMybatisDAO;
	
	//DAO 인터페이스를 이용하여 필드 선언 : DAO 클래스가 변경되어도 필드 재선언 불필요
	// => DAO 인터페이스를 상속받아 자식클래스의 인스턴스 포함
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}

	/*
	public StudentServiceImpl(StudentDAO studentJdbcDAO) {
		super();
		this.studentJdbcDAO = studentJdbcDAO;
		System.out.println("### StudentServiceImpl 클래스의 매개변수(DAO)가 존재하는 생성자 호출 ###");
	}

	public StudentDAO getStudentJdbcDAO() {
		return studentJdbcDAO;
	}

	public void setStudentJdbcDAO(StudentDAO studentJdbcDAO) {
		this.studentJdbcDAO = studentJdbcDAO;
		System.out.println("+++ StudentServiceImpl 클래스의 setStudentJdbcDAO() 메소드 호출 +++");
	}
	*/
	
	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### StudentServiceImpl 클래스의 매개변수(DAO)가 존재하는 생성자 호출 ###");
	}
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("+++ StudentServiceImpl 클래스의 setStudentDAO() 메소드 호출 +++");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 addStudent() 메소드 호출 ***");
		//필드에 NULL이 저장된 경우 NullPointerException 발생
		// => 필드에는 DAO 클래스의 인스턴스가 반드시 저장되도록 설정
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 getStudent() 메소드 호출 ***");
		return studentDAO.selectStudent(num);		
	}
	
	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectAllStudent();
	}
}






