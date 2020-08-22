package site.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import site.itwill.dto.MyMemberDTO;

//XML Mapper(MyMemberXMLMapper.xml)�� ��ϵ� SQL ������ �̿��Ͽ� �ۼ��� DAO Ŭ����
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
	
	//ȸ�������� ���޹޾� MYMEMBER ���̺��� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int addMember(MyMemberDTO member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		try {
			//SqlSession.insert(String elementId[,Object parameterValue])
			// => INSERT ������ ��ϵ� ������Ʈ�� �̿��Ͽ� SQL ���� ���� �� �������� ������ ��ȯ�ϴ� �޼ҵ�
			int rows=sqlSession.insert("site.itwill.mapper.MyMemberXMLMapper.insertMember",member);
			
			//Mybatis Framework�� �⺻������ AutoCommit ����� ��Ȱ��ȭ ó���� �� SQL ���� ����
			// => DML ������ �����Ͽ� ���� �� �ݵ�� TCL ���� �޼ҵ� ȣ��
			//SqlSession.commit() : Ʈ������ ���� ����(COMMIT)�� �����Ͽ� �����ϴ� �޼ҵ�
			//SqlSession.rollback() : Ʈ������ ��� ����(ROLLBACK)�� �����Ͽ� �����ϴ� �޼ҵ�
			if(rows>0) sqlSession.commit();
			else sqlSession.rollback();
			
			return rows;
		} finally {
			sqlSession.close();
		}
	}
	
	//ȸ�������� ���޹޾� MYMEMBER ���̺��� ����� ȸ�������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int modifyMember(MyMemberDTO member) {
		//SqlSessionFactory.openSession(boolean autoCommit)
		// => SqlSession �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => false : AutoCommit ��� ��Ȱ��ȭ(�⺻), true : AutoCommit ��� Ȱ��
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.update(String elementId[,Object parameterValue])
			// => UPDATE ������ ��ϵ� ������Ʈ�� �̿��Ͽ� SQL ���� ���� �� �������� ������ ��ȯ�ϴ� �޼ҵ�
			return sqlSession.update("site.itwill.mapper.MyMemberXMLMapper.updateMember", member);
		} finally {
			sqlSession.close();
		}
	}
	
	//���̵� ���޹޾� MYMEMBER ���̺��� ����� ȸ�������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int removeMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.delete(String elementId[,Object parameterValue])
			// => DELETE ������ ��ϵ� ������Ʈ�� �̿��Ͽ� SQL ���� ���� �� �������� ������ ��ȯ�ϴ� �޼ҵ�
			return sqlSession.delete("site.itwill.mapper.MyMemberXMLMapper.deleteMember", id);
		} finally {
			sqlSession.close();
		}
	}
	
	//���̵� ���޹޾� MYMEMBER ���̺��� ����� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public MyMemberDTO getMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.selectOne(String elementId[,Object parameterValue])
			// => SELECT ������ ��ϵ� ������Ʈ�� �̿��Ͽ� SQL ���� ���� �� �������� ����� �ϳ��� ��ȯ�ϴ� �޼ҵ�
			// => SELECT ���� ���࿡ ���� �˻����� �÷����� ������ �Ǵ� JavaBean(DTO) Ŭ������ �ʵ尪���� �����Ͽ� ��ȯ 
			return sqlSession.selectOne("site.itwill.mapper.MyMemberXMLMapper.selectMember", id);
		} finally {
			sqlSession.close();
		}
	}
	
	//MYMEMBER ���̺��� ����� ��� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<MyMemberDTO> getMemberList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.selectList(String elementId[,Object parameterValue])
			// => SELECT ������ ��ϵ� ������Ʈ�� �̿��Ͽ� SQL ���� ���� �� �������� ����� List Ÿ������ ��ȯ�ϴ� �޼ҵ�
			return sqlSession.selectList("site.itwill.mapper.MyMemberXMLMapper.selectAllMember");
		} finally {
			sqlSession.close();
		}
	}
}