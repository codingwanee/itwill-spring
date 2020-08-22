package site.itwill.dto;

//DTO 클래스의 필드명은 테이블의 컬럼명과 동일하게 작성하는 것을 권장
// => 검색행의 컬럼값이 동일한 이름의 필드에 대한 Setter 메소드를 자동으로 호출하여 필드값으로 변경
public class MyMemberDTO {
	private String id;
	private String name;
	private String phone;
	private String email;
	
	public MyMemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
