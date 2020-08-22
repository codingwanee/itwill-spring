package site.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Component("studentDAO")
//@Component("studentMybatisDAO")

@Repository("studentMybatisDAO")
public class AnnotationStudentMybatisDAO implements StudentDAO {
	public AnnotationStudentMybatisDAO() {
		System.out.println("### AnnotationStudentMybatisDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentMybatisDAO Ŭ������ insertStudent() �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentMybatisDAO Ŭ������ selectStudent() �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectAllStudent() {
		System.out.println("*** AnnotationStudentMybatisDAO Ŭ������ selectAllStudent() �޼ҵ� ȣ�� ***");
		return null;
	}

}
