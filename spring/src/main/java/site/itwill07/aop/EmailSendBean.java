package site.itwill07.aop;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

//�̸����� �����ϴ� ����� �����ϴ� �޼ҵ尡 ����� Ŭ����
public class EmailSendBean {
	//�̸��� ������ ���� JavaMailSender �ν��Ͻ��� �����ϱ� ���� �ʵ�
	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	//�̸����� �����ϴ� �޼ҵ�
	// => �޴� ����� �̸��� �ּ�, ����, ������ �Ű������� ���޹޾� ����
	// => �޴� ����� �̸��� �ּ� ��ȯ
	public String sendEmail(String email, String subject, String content) {
		//JavaMailSender.createMimeMessage() : MimeMessage �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => MimeMessage : �̸��� ���ۿ� �ʿ��� ������ �����ϱ� ���� Ŭ����
		MimeMessage message=mailSender.createMimeMessage();
		
		try {
			//MimeMessage.setSubject(String subject) : �̸��� ������ �����ϴ� �޼ҵ�
			message.setSubject(subject);
			
			//MimeMessage.setText(String text) : �̸��� ������ �����ϴ� �޼ҵ�
			message.setText(content);
			
			//MimeMessage.setRecipients(RecipientType type, InternetAddress email)
			// => �޴� ����� ���� ������ �����ϴ� �޼ҵ� - �޴� ����� �̸��� �ּ� ����
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
			
			//JavaMailSender.send(MimeMessage message) : �̸����� �����ϴ� �޼ҵ�
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return email;
	}
}







