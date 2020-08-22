package site.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

//Spring Framework에서 제공하는 DAO 모듈을 이용하여 DAO 클래스 작성 - Spring DAO
// => JdbcDaoSupport 클래스를 상속받아 DAO 클래스 선언
//JdbcDaoSupport : JdbcTemplate 클래스를 필드로 포함하는 클래스
// => JdbcDaoSupport 클래스의 getJdbcTemplate() 메소드로 JdbcTemplate 인스턴스를 반환받아 사용
public class StudentSpringSupportDAO extends JdbcDaoSupport implements StudentDAO {
	@Override
	public int insertStudent(StudentDTO student) {
		String sql="insert into student values(?,?,?,?,?)";
		return getJdbcTemplate().update(sql,student.getNo(),student.getName()
			,student.getPhone(),student.getAddress(),student.getBirthday());
	}

	@Override
	public int updateStudent(StudentDTO student) {
		String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
		return getJdbcTemplate().update(sql, student.getName(),student.getPhone()
			,student.getAddress(),student.getBirthday(),student.getNo());
	}

	@Override
	public int deleteStudent(int no) {
		return getJdbcTemplate().update("delete from student where no=?", no);
	}

	@Override
	public StudentDTO selectStudent(int no) {
		try {
			String sql="select * from student where no=?";
			return getJdbcTemplate().queryForObject(sql, new Object[]{no}, new StudentRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<StudentDTO> selectAllStudent() {
		String sql="select * from student order by no";
		return getJdbcTemplate().query(sql, new StudentRowMapper());
	}

	public class StudentRowMapper implements RowMapper<StudentDTO> {
		@Override
		public StudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentDTO student=new StudentDTO();
			student.setNo(rs.getInt("no"));
			student.setName(rs.getString("name"));
			student.setPhone(rs.getString("phone"));
			student.setAddress(rs.getString("address"));
			student.setBirthday(rs.getString("birthday"));
			return student;
		}
	}
}
