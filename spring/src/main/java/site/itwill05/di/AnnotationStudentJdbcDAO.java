package site.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Component("studentDAO")
//@Component("studentJdbcDAO")

//@Repository : 클래스를 Spring Bean으로 등록하기 위한 어노테이션
// => DAO 클래스를 Spring Bean으로 등록할 경우 사용
@Repository("studentJdbcDAO")
public class AnnotationStudentJdbcDAO implements StudentDAO {
	public AnnotationStudentJdbcDAO() {
		System.out.println("### AnnotationStudentJdbcDAO 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스의 insertStudent() 메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스의 selectStudent() 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Student> selectAllStudent() {
		System.out.println("*** AnnotationStudentJdbcDAO 클래스의 selectAllStudent() 메소드 호출 ***");
		return null;
	}
}
