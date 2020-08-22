package site.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import site.itwill.dto.MyMemberDTO;

//XML Mapper(MyMemberXMLMapper.xml)에 등록된 SQL 명령을 이용하여 작성한 DAO 클래스
public class MyMemberXMLDAO {
	private static MyMemberXMLDAO _dao;
	
	private MyMemberXMLDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyMemberXMLDAO();
	}
	
	public static MyMemberXMLDAO getDAO() {
		return _dao;
	}
	
	private SqlSessionFactory getSqlSessionFactory() {
		String resource="mybatis-config.xml";
		InputStream inputStream=null;
		try {
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//회원정보를 전달받아 MYMEMBER 테이블에 저장하고 삽입행의 갯수를 반환하는 메소드
	public int addMember(MyMemberDTO member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		try {
			//SqlSession.insert(String elementId[,Object parameterValue])
			// => INSERT 명령이 등록된 엘리먼트를 이용하여 SQL 명령 실행 후 삽입행의 갯수를 반환하는 메소드
			int rows=sqlSession.insert("site.itwill.mapper.MyMemberXMLMapper.insertMember",member);
			
			//Mybatis Framework는 기본적으로 AutoCommit 기능이 비활성화 처리된 후 SQL 명령 실행
			// => DML 명령을 전달하여 실행 후 반드시 TCL 관련 메소드 호출
			//SqlSession.commit() : 트렌젝션 적용 명령(COMMIT)을 전달하여 실행하는 메소드
			//SqlSession.rollback() : 트렌젝션 취소 명령(ROLLBACK)을 전달하여 실행하는 메소드
			if(rows>0) sqlSession.commit();
			else sqlSession.rollback();
			
			return rows;
		} finally {
			sqlSession.close();
		}
	}
	
	//회원정보를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 변경하고 변경행의 갯수를 반환하는 메소드
	public int modifyMember(MyMemberDTO member) {
		//SqlSessionFactory.openSession(boolean autoCommit)
		// => SqlSession 인스턴스를 생성하여 반환하는 메소드
		// => false : AutoCommit 기능 비활성화(기본), true : AutoCommit 기능 활성
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.update(String elementId[,Object parameterValue])
			// => UPDATE 명령이 등록된 엘리먼트를 이용하여 SQL 명령 실행 후 변경행의 갯수를 반환하는 메소드
			return sqlSession.update("site.itwill.mapper.MyMemberXMLMapper.updateMember", member);
		} finally {
			sqlSession.close();
		}
	}
	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int removeMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.delete(String elementId[,Object parameterValue])
			// => DELETE 명령이 등록된 엘리먼트를 이용하여 SQL 명령 실행 후 삭제행의 갯수를 반환하는 메소드
			return sqlSession.delete("site.itwill.mapper.MyMemberXMLMapper.deleteMember", id);
		} finally {
			sqlSession.close();
		}
	}
	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 검색하여 반환하는 메소드
	public MyMemberDTO getMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.selectOne(String elementId[,Object parameterValue])
			// => SELECT 명령이 등록된 엘리먼트를 이용하여 SQL 명령 실행 후 단일행의 결과를 하나만 반환하는 메소드
			// => SELECT 명령 실행에 대한 검색행의 컬럼값을 변수값 또는 JavaBean(DTO) 클래스의 필드값으로 매핑하여 반환 
			return sqlSession.selectOne("site.itwill.mapper.MyMemberXMLMapper.selectMember", id);
		} finally {
			sqlSession.close();
		}
	}
	
	//MYMEMBER 테이블에 저장된 모든 회원정보를 검색하여 반환하는 메소드
	public List<MyMemberDTO> getMemberList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.selectList(String elementId[,Object parameterValue])
			// => SELECT 명령이 등록된 엘리먼트를 이용하여 SQL 명령 실행 후 다중행의 결과를 List 타입으로 반환하는 메소드
			return sqlSession.selectList("site.itwill.mapper.MyMemberXMLMapper.selectAllMember");
		} finally {
			sqlSession.close();
		}
	}
}