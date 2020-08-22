package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.Student;
import site.itwill10.mapper.StudentMapper;

//DAO Ŭ���� : DBMS ���α׷��� SQL ����� �����Ͽ� ����� �����ޱ� ���� Ŭ����
//@Repository : DAO Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
@Repository
public class StudentMybatisDAO implements StudentDAO {
	//Spring Bean���� ��ϵ� SqlSession �ν��Ͻ��� �������Ͽ� �����ϱ� ���� �ʵ�
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
