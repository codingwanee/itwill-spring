package site.itwill05.di;

import java.util.List;

//DAO Ŭ���� : ���� �����ü(DataSource - DBMS)�� ������ ����,����,����,�˻� ����� �޼ҵ尡 ����� Ŭ����
// => �����ü�� ���� �Ǵ� ����� ���� ���� ���� DAO Ŭ���� ����
//DAO Ŭ���� ����� �������̽��� ��ӹ޾� �ۼ�
// => DAO Ŭ������ ����ϴ� Service Ŭ�������� ���յ��� ���߾� ���������� ȿ���� ����
public class StudentJdbcDAO implements StudentDAO {
	public StudentJdbcDAO() {
		System.out.println("### StudentJdbcDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentJdbcDAO Ŭ������ insertStudent() �޼ҵ� ȣ�� ***");
		return 0;
	}
	
	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentJdbcDAO Ŭ������ selectStudent() �޼ҵ� ȣ�� ***");
		return null;
	}
	
	@Override
	public List<Student> selectAllStudent() {
		System.out.println("*** StudentJdbcDAO Ŭ������ selectAllStudent() �޼ҵ� ȣ�� ***");
		return null;
	}
}
