package site.itwill05.di;

import java.util.List;

//import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Component("studentService")

//@Service : Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
// => Service Ŭ������ Spring Bean���� ����� ��� ���
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	/*
	//@Resource : Spring Bean�� �ڵ� ������ ����� �����ϱ� ���� ������̼�
	// => JDK ���̺귯������ �����ϴ� ������̼�
	@Resource
	private StudentDAO studentDAO;
	*/

	//@Autowired : Spring Bean�� �ڵ� ������ ����� �����ϱ� ���� ������̼�
	// => Spring ���̺귯������ �����ϴ� ������̼�
	// => bean ������Ʈ�� autowire �Ӽ��� byType �Ӽ����� ������ ����� ����
	// => Setter Injection�� �̿��Ͽ� ������ ������ ������ Setter �޼ҵ� ���� �ڵ����� ������ ����
	//������)�ʵ��� �ڷ����� �������̽��� ��� �ڽ�Ŭ������ Spring Bean�� ���� �� ��ϵ� ��� ������ ���� �߻�
	//�ذ�-1)�ڽ�Ŭ������ Spring Bean�� ���� �� ��ϵ� ��� byName �Ӽ������� �ڵ� ������
	// => �������� Spring Bean �� �������ϰ��� �ϴ� Spring Bean�� beanName�� �ʵ��̸��� �����ϰ� ����
	//�ذ�-2)@Qualifier ������̼��� �̿��Ͽ� ������ �ϰ��� �ϴ� Spring Bean�� ���� ����
	@Autowired
	//@Qualifier : beanName�� �����Ͽ� ���ϴ� Spring Bean�� �����ǵǵ��� �����ϴ� ������̼�
	// => @Autowired ������̼ǿ� ���ӵ� ������̼�
	//@Qualifier("studentJdbcDAO")
	@Qualifier("studentMybatisDAO")
	private StudentDAO studentDAO;
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	/*
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	*/

	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ addStudent() �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudent() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectAllStudent();
	}

}
