package site.itwill05.di;

import java.util.List;

//�л����� ���� Service Ŭ������ �ݵ�� ��� �޾ƾ� �Ǵ� �������̽�
public interface StudentService {
	void addStudent(Student student);
	Student getStudent(int num);
	List<Student> getStudentList();
}