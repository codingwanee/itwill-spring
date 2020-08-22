package site.itwill10.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

//JavaBean(DTO) 인스턴스에 저장된 회원정보를 XML 형식의 텍스트 데이타로 자동 변환되도록 설정
// => JAXB(Java Architecture for XML Binding) 기능을 이용하여 인스턴스를 XML 텍스트 데이타로 변환
// => 필드에 대한 Getter 및 Setter 메소드가 형식에 맞게 선언
//JAXB 기능은 JDK9 이상에서는 미지원
// => Maven를 이용하여 JAXB 기능을 제공하는 라이브러리를 빌드하여 포함

//@XmlRootElement(name="elementName") : XML의 Root Element를 설정하는 어노테이션(필드)
//name 속성 : 엘리먼트명을 속성값으로 설정 => 생략된 경우 클래스명을 엘리먼트명으로 자동 설정 
@XmlRootElement(name = "member")
//@XmlAccessorType(XmlAccessType type) : 자식 엘리먼트를 무엇으로 표현할 것인지를 설정하는 어노테이션(필수)
// => XmlAccessType(Enum) 자료형의 상수필드 중 하나를 속성값으로 설정
//XmlAccessType.FIELD : 필드를 이용하여 자식 엘리먼트 설정
// => 필드명이 자동으로 자동으로 자식 엘리먼트로 설정되며 필드값이 엘리먼트 내용(응답정보)으로 구현
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"fieldName","fieldName",...}) : 자식 엘리먼트를 표현하는 방법를 설정하는 어노테이션(선택)
// => propOrder 속성에 필드를 나열하여 자식 엘리먼트의 순서 설정 
//@XmlType(propOrder = {"id","address","name"})
public class RestMemberXML {
	private String id;
	private String name;
	//@XmlElement(name="elementName") : 자식 엘리먼트명을 설정하는 어노테이션(선택)
	// => 어노테이션을 사용하지 않은 경우 필드명을 자식 엘리먼트명으로 자동 설정
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
