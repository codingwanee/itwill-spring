package site.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import site.itwill.dto.StudentDTO;

public class StudentDAO {
	private static StudentDAO _dao;
	
	private StudentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new StudentDAO();
	}
	
	public static StudentDAO getDAO() {
		return _dao;
	}
	
	//SqlSessionFactory 인스턴스를 반환하는 메소드
	//SqlSessionFactory 인스턴스 : SqlSession 인스턴스를 생성하여 제공하기 위한 인스턴스
	private SqlSessionFactory getSqlSessionFactory() {
		String resource="mybatis-config.xml";
		InputStream inputStream=null;
		try {
			//mybatis 주환경설정 파일을 읽기 위한 입력스트림을 생성하여 저장
			//Resources.getResourceAsStream(String resource)
			// => 리소스(XML) 파일을 읽기 위한 입력스트림을 생성하여 반환하는 메소드
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		
		//SqlSessionFactoryBuilder : SqlSessionFactory 인스턴스를 생성하여 제공하는 클래스
		//SqlSessionFactoryBuilder.build(InputStream inputStream)
		// => mybatis 주환경설정 파일에서 제공하는 정보를 이용하여 SqlSessionFactory 인스턴스 생성하여 반환하는 메소드
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	// => SqlSession 인스턴스로 Mapper 파일에 등록된 SQL 명령을 사용하여 메소드 작성
	public List<StudentDTO> getStudentList() {
		//SqlSessionFactory.openSession()
		// => SqlSession 인스턴스를 생성하여 반환하는 메소드
		//SqlSession 인스턴스 : Mapper 파일에 등록된 SQL 명령을 DBMS 서버에 전달하여
		//실행하고 결과를 자동 매핑하여 반환하는 인스턴스 
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		try {
			//SqlSession.selectList(String elementId) : SELECT 명령을 Mapper 파일에 얻어와 
			//전달 실행하여 발생된 결과를 List 인스턴스로 생성하여 반환하는 메소드
			return sqlSession.selectList("site.itwill.mapper.StudentMapper.getStudentList");
		} finally {
			//SqlSession.close() : SqlSession 인스턴스를 제거하는 메소드
			sqlSession.close();
		}
	}
}












