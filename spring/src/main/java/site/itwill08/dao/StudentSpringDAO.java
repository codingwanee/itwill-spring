package site.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//Spring Framework���� �����ϴ� DAO ����� �̿��Ͽ� DAO Ŭ���� �ۼ� - Spring DAO
// => JdbcTemplate Ŭ������ ���ø� �޼ҵ带 ȣ���Ͽ� DAO Ŭ������ �޼ҵ� ���� 
public class StudentSpringDAO implements StudentDAO {
	//JdbcTemplate Ŭ������ Spring Bean�� �������Ͽ� DAO Ŭ������ �޼ҵ忡�� ���
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertStudent(StudentDTO student) {
		String sql="insert into student values(?,?,?,?,?)";
		//JdbcTemplate.update(String sql,Object...args) 
		// => INSERT,UPDATE,DELETE ����� �����Ͽ� �����ϰ� ó������ ������ ��ȯ�ϴ� �޼ҵ�
		// => SQL ����� InParameter(?)���� �޼ҵ� ȣ��� ���� ���ʴ�� �����Ͽ� ����
		return jdbcTemplate.update(sql,student.getNo(),student.getName()
			,student.getPhone(),student.getAddress(),student.getBirthday());
	}

	@Override
	public int updateStudent(StudentDTO student) {
		String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
		return jdbcTemplate.update(sql, student.getName(),student.getPhone()
			,student.getAddress(),student.getBirthday(),student.getNo());
	}

	@Override
	public int deleteStudent(int no) {
		return jdbcTemplate.update("delete from student where no=?", no);
	}

	@Override
	public StudentDTO selectStudent(int no) {
		try {
			String sql="select * from student where no=?";
			//JdbcTemplate.queryForObject(String sql, Object[] args, RowMapper rowMapper)
			// => SELECT ����� �����Ͽ� ����� ������ �˻������ ����ó���Ͽ� ��ȯ�ϴ� �޼ҵ�
			//�Ű������� ���޵Ǵ� SELECT ����� �ݵ�� �������� �˻�������� ����
			//SELECT ����� InParameter(?)���� Object �迭�� �̿��Ͽ� ������ ����
			// => Object �迭 ������ {} �ȿ� ���ް��� �����Ͽ� ����
			//�˻����� �÷����� RowMapper �ν��Ͻ��� �̿��Ͽ� ����ó�� ��ȯ
			// => RowMapper �ν��Ͻ��� RowMapper �������̽��� ��ӹ��� Ŭ������ ����
			// => RowMapper �������̽��� ��ӹ��� Ŭ������ ���ظ����� ��ȯ�� ��� ����
			// => mapRow �޼ҵ带 �������̵� �����Ͽ� ����ó�� �� ��� ��ȯ
			/*
			return jdbcTemplate.queryForObject(sql, new Object[]{no}, new RowMapper<StudentDTO>() {
				@Override
				public StudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					//DTO �ν��Ͻ��� �����Ͽ� ResultSet �ν��Ͻ��� ����� �˻����� �÷����� �ʵ尪���� �����Ͽ� ��ȯ - ����ó��
					StudentDTO student=new StudentDTO();
					student.setNo(rs.getInt("no"));
					student.setName(rs.getString("name"));
					student.setPhone(rs.getString("phone"));
					student.setAddress(rs.getString("address"));
					student.setBirthday(rs.getString("birthday"));
					return student;
				}
			});
			*/
			
			return jdbcTemplate.queryForObject(sql, new Object[]{no}, new StudentRowMapper());
		} catch (EmptyResultDataAccessException e) {
			//EmptyResultDataAccessException : SELECT ����� �����Ͽ� 
			//����� �˻������ �������� �ʴ� ��� �߻��Ǵ� ����
			return null;
		}
	}

	@Override
	public List<StudentDTO> selectAllStudent() {
		String sql="select * from student order by no";
		//JdbcTemplate.query(String sql, Object[] args, RowMapper rowMapper)
		// => SELECT ����� �����Ͽ� ����� ������ �˻������ ����ó���Ͽ� List �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		/*
		return jdbcTemplate.query(sql,new RowMapper<StudentDTO>() {
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
		});
		*/
		
		return jdbcTemplate.query(sql, new StudentRowMapper());
	}

	//RowMapper �������̽��� ��ӹ��� �ڽ�Ŭ���� ���� - Inner Class
	// => ����ó���Ͽ� ��ȯ�ϴ� ����� Ŭ������ �����Ͽ� �����ϵ��� ���� 
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
