package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.Student;
import site.itwill10.mapper.StudentMapper;

//DAO 클래스 : DBMS 프로그램에 SQL 명령을 전달하여 결과를 제공받기 위한 클래스
//@Repository : DAO 클래스를 Spring Bean으로 등록하기 위한 어노테이션
@Repository
public class StudentMybatisDAO implements StudentDAO {
	//Spring Bean으로 등록된 SqlSession 인스턴스를 인젝션하여 저장하기 위한 필드
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertStudent(Student student) {
		return sqlSession.getMapper(StudentMapper.class).insertStudent(student);
	}

	@Override
	public List<Student> selectAllStudent() {
		return sqlSession.getMapper(StudentMapper.class).selectAllStudent();
	}
	
}
