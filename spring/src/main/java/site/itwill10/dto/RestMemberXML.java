package site.itwill10.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//JavaBean(DTO) �ν��Ͻ��� ����� ȸ�������� XML ������ �ؽ�Ʈ ����Ÿ�� �ڵ� ��ȯ�ǵ��� ����
// => JAXB(Java Architecture for XML Binding) ����� �̿��Ͽ� �ν��Ͻ��� XML �ؽ�Ʈ ����Ÿ�� ��ȯ
// => �ʵ忡 ���� Getter �� Setter �޼ҵ尡 ���Ŀ� �°� ����
//JAXB ����� JDK9 �̻󿡼��� ������
// => Maven�� �̿��Ͽ� JAXB ����� �����ϴ� ���̺귯���� �����Ͽ� ����

//@XmlRootElement(name="elementName") : XML�� Root Element�� �����ϴ� ������̼�(�ʵ�)
//name �Ӽ� : ������Ʈ���� �Ӽ������� ���� => ������ ��� Ŭ�������� ������Ʈ������ �ڵ� ���� 
@XmlRootElement(name = "member")
//@XmlAccessorType(XmlAccessType type) : �ڽ� ������Ʈ�� �������� ǥ���� �������� �����ϴ� ������̼�(�ʼ�)
// => XmlAccessType(Enum) �ڷ����� ����ʵ� �� �ϳ��� �Ӽ������� ����
//XmlAccessType.FIELD : �ʵ带 �̿��Ͽ� �ڽ� ������Ʈ ����
// => �ʵ���� �ڵ����� �ڵ����� �ڽ� ������Ʈ�� �����Ǹ� �ʵ尪�� ������Ʈ ����(��������)���� ����
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"fieldName","fieldName",...}) : �ڽ� ������Ʈ�� ǥ���ϴ� ����� �����ϴ� ������̼�(����)
// => propOrder �Ӽ��� �ʵ带 �����Ͽ� �ڽ� ������Ʈ�� ���� ���� 
//@XmlType(propOrder = {"id","address","name"})
public class RestMemberXML {
	private String id;
	private String name;
	//@XmlElement(name="elementName") : �ڽ� ������Ʈ���� �����ϴ� ������̼�(����)
	// => ������̼��� ������� ���� ��� �ʵ���� �ڽ� ������Ʈ������ �ڵ� ����
	//@XmlElement(name = "addr")
	private String address;
	
	public RestMemberXML() {
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
