package site.itwill07.aop;

import java.util.List;

//�ٽɰ��ɸ��(�ٽɰ����ڵ尡 ����� �޼ҵ�)�� ����� Ŭ����
public class StudentDAOImpl implements StudentDAO {
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentDAOImpl Ŭ������ insertStudent() �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentDAOImpl Ŭ������ selectStudent() �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectAllStudent() {
		System.out.println("*** StudentDAOImpl Ŭ������ selectAllStudent() �޼ҵ� ȣ�� ***");
		return null;
	}

}
