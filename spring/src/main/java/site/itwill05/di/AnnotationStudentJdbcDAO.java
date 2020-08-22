package site.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Component("studentDAO")
//@Component("studentJdbcDAO")

//@Repository : Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
// => DAO Ŭ������ Spring Bean���� ����� ��� ���
@Repository("studentJdbcDAO")
public class AnnotationStudentJdbcDAO implements StudentDAO {
	public AnnotationStudentJdbcDAO() {
		System.out.println("### AnnotationStudentJdbcDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ insertStudent() �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ selectStudent() �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectAllStudent() {
		System.out.println("*** AnnotationStudentJdbcDAO Ŭ������ selectAllStudent() �޼ҵ� ȣ�� ***");
		return null;
	}
}
