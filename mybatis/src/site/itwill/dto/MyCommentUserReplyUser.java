package site.itwill.dto;

import java.util.List;

//MYCOMMENT ���̺�� MYUSER ���̺�, MYREPLY ���̺��� �˻� ����� �����ϱ� ���� �ڹٺ� Ŭ����
public class MyCommentUserReplyUser {
	//MYCOMMENT ���̺��� �Խñ۹�ȣ�� �����ϱ� ���� �ʵ�
	private int commentNo;
	
	//MYCOMMENT ���̺��� �Խñ� ������ �����ϱ� ���� �ʵ� - ���� �ν��Ͻ�
	private MyComment1 comment;
	
	//MYUSER ���̺��� ȸ������(�Խñ� �ۼ���)�� �����ϱ� ���� �ʵ� - ���� �ν��Ͻ�
	private MyUser user;
	
	//MYREPLY ���̺��� ��۸���� �����ϱ� ���� �ʵ� - List �ν��Ͻ�
	// => �������(MYREPLY ���̺�)�� ȸ������(MYUSER ���̺� - ��� �ۼ���)�� ��ҷ� ���� 
	private List<MyReplyUser> replies;
	
	public MyCommentUserReplyUser() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public MyComment1 getComment() {
		return comment;
	}

	public void setComment(MyComment1 comment) {
		this.comment = comment;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public List<MyReplyUser> getReplies() {
		return replies;
	}

	public void setReplies(List<MyReplyUser> replies) {
		this.replies = replies;
	}
}





