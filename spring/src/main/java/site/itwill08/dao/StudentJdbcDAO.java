package site.itwill08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//Bean Configuration File에서 Spring Bean으로 등록된 클래스는 기본적으로 싱글톤으로 제공
// => 싱글톤 디자인 패턴이 적용된 클래스로 작성 불필요
public class StudentJdbcDAO implements StudentDAO {
	//Bean Configuration File에서 DataSource 관련 Spring Bean을 필드에 Injection => Spring DI
	// => DAO 클래스의 메소드에서 Connection 인스턴스를 제공받아 사용 
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int insertStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=dataSource.getConnection();
			
			String sql="insert into student values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStudent() 메소드 SQL 오류 = "+e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
		return rows;
	}

	@Override
	public int updateStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=dataSource.getConnection();
			
			String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateStudent() 메소드 SQL 오류 = "+e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
		return rows;
	}

	@Override
	public int deleteStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=dataSource.getConnection();
			
			String sql="delete from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteStudent() 메소드 SQL 오류 = "+e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
		return rows;
	}

	@Override
	public StudentDTO selectStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StudentDTO student=null;
		try {
			con=dataSource.getConnection();
			
			String sql="select * from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				student=new StudentDTO();
				//검색행의 컬럼값을 인스턴스 필드값으로 변경 - 매핑작업
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectStudent() 메소드 SQL 오류 = "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
		return student;
	}

	@Override
	public List<StudentDTO> selectAllStudent() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<StudentDTO>();
		try {
			con=dataSource.getConnection();
			
			String sql="select * from student order by no";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllStudent() 메소드 SQL 오류 = "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {}
		}
		return studentList;
	}

}





