package site.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import site.itwill.dto.UserinfoDTO;

public class UserinfoModelOneDAO extends JdbcDAO {
	private static UserinfoModelOneDAO _dao;
	
	private UserinfoModelOneDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new UserinfoModelOneDAO();
	}
	
	public static UserinfoModelOneDAO getDAO() {
		return _dao;
	}
	
	//ȸ�������� ���޹޾� USERINFO ���̺� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int addUserinfo(UserinfoDTO userinfo) {
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
		} catch (SQLException e) {
			System.out.println("[����]addUserinfo() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//ȸ�������� ���޹޾� USERINFO ���̺� ����� ȸ�������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int modifyUserinfo(UserinfoDTO userinfo) {
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
		} catch (SQLException e) {
			System.out.println("[����]modifyUserinfo() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	public int removeUserinfo(String userid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from userinfo where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[����]removeUserinfo() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public UserinfoDTO getUserinfo(String userid) {
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
		} catch (SQLException e) {
			System.out.println("[����]getUserinfo() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return userinfo;
	}
	
	//USERINFO ���̺� ����� ��� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<UserinfoDTO> getUserinfoList() {
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
		} catch (SQLException e) {
			System.out.println("[����]getUserinfoList() �޼ҵ��� SQL ���� = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return userinfoList;
	}
}