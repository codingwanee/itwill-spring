package site.itwill10.dto;

//JavaBean : 입력태그의 입력값을 저장할 목적의 클래스
// => DAO 클래스에서 정보를 전달할 목적으로 사용될 경우 DTO 클래스라고 함
//입력태그의 name 속성값과 동일한 이름으로 필드 선언
// => 입력값을 같은 이름의 필드의 Setter를 자동 호출하여 저장
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String phone1;
	private String phone2;
	private String phone3;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
}
