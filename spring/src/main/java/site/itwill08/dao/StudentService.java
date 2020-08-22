package site.itwill08.dao;

import java.util.List;

public interface StudentService {
	void addStudent(StudentDTO student);
	void modifyStudent(StudentDTO student);
	void removeStudent(int no);
	StudentDTO getStudent(int no);
	List<StudentDTO> getStudentList();
}
