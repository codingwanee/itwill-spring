package site.itwill05.di;

import java.util.List;

public class StudentMybatisDAO implements StudentDAO {
	public StudentMybatisDAO() {
		System.out.println("### StudnetMybatisDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudnetMybatisDAO Ŭ������ insertStudent() �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudnetMybatisDAO Ŭ������ selectStudent() �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectAllStudent() {
		System.out.println("*** StudnetMybatisDAO Ŭ������ selectAllStudent() �޼ҵ� ȣ�� ***");
		return null;
	}
}
