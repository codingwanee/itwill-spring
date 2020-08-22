package site.itwill10.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//회원목록을 저장하는 List 필드가 선언된 클래스
@XmlRootElement(name = "member_list")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestMemberListXML {
	//List 인스턴스에 저장된 요소를 자식 엘리먼트로 표현
	// => 요소갯수만틈 자식 엘리먼트가 생성
	@XmlElement(name = "member")
	private List<RestMemberXML> restMemberList;
	
	public RestMemberListXML() {
		// TODO Auto-generated constructor stub
	}

	public List<RestMemberXML> getRestMemberList() {
		return restMemberList;
	}

	public void setRestMemberList(List<RestMemberXML> restMemberList) {
		this.restMemberList = restMemberList;
	}
}
