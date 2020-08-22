package site.itwill08.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//Spring Framework에서 제공하는 DAO 모듈을 이용하여 DAO 클래스 작성 - Spring DAO
// => JdbcTemplate 클래스의 템플릿 메소드를 호출하여 DAO 클래스의 메소드 선언 
public class StudentSpringDAO implements StudentDAO {
	//JdbcTemplate 클래스의 Spring Bean를 인젝션하여 DAO 클래스의 메소드에서 사용
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
		// => INSERT,UPDATE,DELETE 명령을 전달하여 실행하고 처리행의 갯수를 반환하는 메소드
		// => SQL 명령의 InParameter(?)에는 메소드 호출시 값을 차례대로 나열하여 전달
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
			// => SELECT 명령을 전달하여 실행된 단일행 검색결과를 매핑처리하여 반환하는 메소드
			//매개변수에 전달되는 SELECT 명령은 반드시 단일행의 검색결과만을 제공
			//SELECT 명령의 InParameter(?)에는 Object 배열을 이용하여 값들을 전달
			// => Object 배열 생성시 {} 안에 전달값을 나열하여 선언
			//검색행의 컬럼값을 RowMapper 인스턴스를 이용하여 매핑처리 반환
			// => RowMapper 인스턴스는 RowMapper 인터페이스를 상속받은 클래스로 생성
			// => RowMapper 인터페이스를 상속받은 클래스는 제넥릭으로 반환될 결과 제공
			// => mapRow 메소드를 오버라이드 선언하여 매핑처리 후 결과 반환
			/*
			return jdbcTemplate.queryForObject(sql, new Object[]{no}, new RowMapper<StudentDTO>() {
				@Override
				public StudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					//DTO 인스턴스를 생성하여 ResultSet 인스턴스에 저장된 검색행의 컬럼값을 필드값으로 변경하여 반환 - 매핑처리
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
			//EmptyResultDataAccessException : SELECT 명령을 전달하여 
			//실행된 검색결과가 존재하지 않는 경우 발생되는 예외
			return null;
		}
	}

	@Override
	public List<StudentDTO> selectAllStudent() {
		String sql="select * from student order by no";
		//JdbcTemplate.query(String sql, Object[] args, RowMapper rowMapper)
		// => SELECT 명령을 전달하여 실행된 다중행 검색결과를 매핑처리하여 List 인스턴스로 반환하는 메소드
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

	//RowMapper 인터페이스를 상속받은 자식클래스 선언 - Inner Class
	// => 매핑처리하여 반환하는 기능을 클래스로 구현하여 재사용하도록 선언 
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
