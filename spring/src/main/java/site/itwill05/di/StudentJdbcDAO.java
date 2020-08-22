package site.itwill05.di;

import java.util.List;

//DAO 클래스 : 정보 저장매체(DataSource - DBMS)에 정보의 삽입,삭제,변경,검색 기능의 메소드가 선언된 클래스
// => 저장매체의 종류 또는 방법에 따라 여러 개의 DAO 클래스 존재
//DAO 클래스 선언시 인터페이스를 상속받아 작성
// => DAO 클래스를 사용하는 Service 클래스와의 결합도를 낮추어 유지보수의 효율성 증가
public class StudentJdbcDAO implements StudentDAO {
	public StudentJdbcDAO() {
		System.out.println("### StudentJdbcDAO 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentJdbcDAO 클래스의 insertStudent() 메소드 호출 ***");
		return 0;
	}
	
	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentJdbcDAO 클래스의 selectStudent() 메소드 호출 ***");
		return null;
	}
	
	@Override
	public List<Student> selectAllStudent() {
		System.out.println("*** StudentJdbcDAO 클래스의 selectAllStudent() 메소드 호출 ***");
		return null;
	}
}
