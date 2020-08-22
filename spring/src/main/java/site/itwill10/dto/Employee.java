package site.itwill10.dto;

public class Employee {
	//필드의 자료형이 숫자형인 경우 자동으로 입력값이 변환되어 저장
	// => 입력값이 존재하지 않을 경우 숫자형으로 변환할 수 없으므로 400 에러 발생
	private int num;
	private String name;
	/*
	private String phone1;
	private String phone2;
	private String phone3;
	*/
	private Phone phone;//포함관계
	private String email;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
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
	*/

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
