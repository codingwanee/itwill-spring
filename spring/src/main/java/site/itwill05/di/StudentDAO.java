package site.itwill05.di;

import java.util.List;

//�л����� ���� DAO Ŭ������ �ݵ�� ��ӹ޾ƾ� �Ǵ� �������̽�
// => �ν��Ͻ� ���� ���յ��� ���� ���������� ȿ������ ���� ��Ű�� ���� ����
public interface StudentDAO {
	int insertStudent(Student student);
	Student selectStudent(int num);
	List<Student> selectAllStudent();
}