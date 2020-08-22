package site.itwill08.dao;

import java.util.List;

public interface StudentDAO {
	int insertStudent(StudentDTO student);
	int updateStudent(StudentDTO student);
	int deleteStudent(int no);
	StudentDTO selectStudent(int no);
	List<StudentDTO> selectAllStudent();
}
