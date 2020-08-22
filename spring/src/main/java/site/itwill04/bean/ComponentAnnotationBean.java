package site.itwill04.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component : Ŭ������ Spring Bean���� ����ϴ� ������̼�
// => Ŭ�����̸��� �ڵ����� beanName���� ���� - ù���ڴ� �빮�ڿ��� �ҹ��ڷ� ��ȯ
//@Component
//@Component(value="beanName") �������� beanName ���� ���� ���� - value Ű���� ���� ����
@Component("cab")
//bean ������Ʈ �Ӽ��� ������ ����� �����ϴ� ������̼� ��� ���� - @Lazy, @Scope
@Lazy
@Scope("prototype")
public class ComponentAnnotationBean {
	public ComponentAnnotationBean() {
		System.out.println("### ComponentAnnotationBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public void display() {
		System.out.println("*** ComponentAnnotationBean Ŭ������ display() �޼ҵ� ȣ�� ***");
	}
}
