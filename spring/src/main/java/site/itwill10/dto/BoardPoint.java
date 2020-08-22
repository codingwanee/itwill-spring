package site.itwill10.dto;

/*
이름      널?       유형           
------- -------- ------------ 
NUM     NOT NULL NUMBER       
SUBJECT          VARCHAR2(50) 
WRITER           VARCHAR2(20)
*/

//BOARDPOINT 테이블의 정보(게시글 정보)를 저장하기 위한 클래스
public class BoardPoint {
	private int num;
	private String subject;
	private String writer;
	
	public BoardPoint() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
}
