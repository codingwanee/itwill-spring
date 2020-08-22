package site.itwill05.di;

import java.util.List;

public class StudentMybatisDAO implements StudentDAO {
	public StudentMybatisDAO() {
		System.out.println("### StudnetMybatisDAO 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudnetMybatisDAO 클래스의 insertStudent() 메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudnetMybatisDAO 클래스의 selectStudent() 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Student> selectAllStudent() {
		System.out.println("*** StudnetMybatisDAO 클래스의 selectAllStudent() 메소드 호출 ***");
		return null;
	}
}
