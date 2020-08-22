package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.StudentDAO;
import site.itwill10.dto.Student;

//Service Ŭ���� : DAO Ŭ������ �޼ҵ带 �̿��Ͽ� ���α׷��� �ʿ��� ����� ����
//@Service : Service Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
@Service
public class StudentServiceImpl implements StudentService {
	//Spring Bean���� ��ϵ� DAO �ν��Ͻ��� �������Ͽ� �����ϱ� ���� �ʵ�
	// => �ʵ��� �ڷ����� �������̽��� �����Ͽ� ��� �ڽ� �ν��Ͻ��� �������Ͽ� ������ �� �ֵ��� ����
	//Spring Bean���� ��ϵ� DAO �ν��Ͻ��� ���� ���� ��� @Qualifier 
	//������̼��� �̿��Ͽ� ������ �� Spring Bean ���� - beanName ���
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectAllStudent();
	}

}
