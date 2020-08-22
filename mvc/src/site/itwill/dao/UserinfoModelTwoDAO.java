package site.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.itwill.dto.UserinfoDTO;

public class UserinfoModelTwoDAO extends JdbcDAO {
	private static UserinfoModelTwoDAO _dao;
	
	private UserinfoModelTwoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new UserinfoModelTwoDAO();
	}
	
	public static UserinfoModelTwoDAO getDAO() {
		return _dao;
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 저장하고 삽입행의 갯수를 반환하는 메소드
	public int addUserinfo(UserinfoDTO userinfo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into userinfo values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userinfo.getUserid());
			pstmt.setString(2, userinfo.getPassword());
			pstmt.setString(3, userinfo.getName());
			pstmt.setString(4, userinfo.getEmail());
			
			rows=pstmt.executeUpdate();
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 저장된 회원정보를 변경하고 변경행의 갯수를 반환하는 메소드
	public int modifyUserinfo(UserinfoDTO userinfo) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update userinfo set password=?,name=?,email=? where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userinfo.getPassword());
			pstmt.setString(2, userinfo.getName());
			pstmt.setString(3, userinfo.getEmail());
			pstmt.setString(4, userinfo.getUserid());
			
			rows=pstmt.executeUpdate();
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int removeUserinfo(String userid) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from userinfo where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rows=pstmt.executeUpdate();
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 검색하여 반환하는 메소드
	public UserinfoDTO getUserinfo(String userid) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserinfoDTO userinfo=null;
		try {
			con=getConnection();
			
			String sql="select * from userinfo where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				userinfo=new UserinfoDTO();
				userinfo.setUserid(rs.getString("userid"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setName(rs.getString("name"));
				userinfo.setEmail(rs.getString("email"));
			}	
		} finally {
			close(con, pstmt, rs);
		}
		return userinfo;
	}
	
	//USERINFO 테이블에 저장된 모든 회원정보를 검색하여 반환하는 메소드
	public List<UserinfoDTO> getUserinfoList() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<UserinfoDTO> userinfoList=new ArrayList<UserinfoDTO>();
		try {
			con=getConnection();
			
			String sql="select * from userinfo order by userid";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				UserinfoDTO userinfo=new UserinfoDTO();
				userinfo.setUserid(rs.getString("userid"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setName(rs.getString("name"));
				userinfo.setEmail(rs.getString("email"));
				userinfoList.add(userinfo);
			}	
		} finally {
			close(con, pstmt, rs);
		}
		return userinfoList;
	}
}