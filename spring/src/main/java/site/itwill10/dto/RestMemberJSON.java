package site.itwill10.dto;

//JavaBean(DTO) �ν��Ͻ��� ����� ȸ�������� JSON ������ �ؽ�Ʈ ����Ÿ�� �ڵ� ��ȯ�ǵ��� ����
// => Maven�� �̿��Ͽ� jackson-databind ���̺귯���� �����ϸ� �ڵ����� JSON �ؽ�Ʈ ����Ÿ�� ��ȯ
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
