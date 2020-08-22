package site.itwill05.di;

import java.util.List;

//학생정보 관련 Service 클래스가 반드시 상속 받아야 되는 인터페이스
public interface StudentService {
	void addStudent(Student student);
	Student getStudent(int num);
	List<Student> getStudentList();
}