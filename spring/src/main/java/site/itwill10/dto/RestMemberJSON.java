package site.itwill10.dto;

//JavaBean(DTO) 인스턴스에 저장된 회원정보를 JSON 형식의 텍스트 데이타로 자동 변환되도록 설정
// => Maven을 이용하여 jackson-databind 라이브러리를 빌드하면 자동으로 JSON 텍스트 데이타로 변환
public class RestMemberJSON {
	private String id;
	private String name;
	private String address;
	
	public RestMemberJSON() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
