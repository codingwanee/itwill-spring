<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="site.itwill.el.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] nameArray={"홍길동","임꺽정","전우치","일지매","장길산"};
	request.setAttribute("nameArray", nameArray);
	
	Student[] studentArray={new Student(1000,"홍길동")
			,new Student(2000,"임꺽정"),new Student(3000,"전우치")
			,new Student(4000,"일지매"),new Student(5000,"장길산")};
	request.setAttribute("studentArray", studentArray);
	
	List<Student> studentList=new ArrayList<Student>();
	studentList.add(new Student(1000,"홍길동"));
	studentList.add(new Student(2000,"임꺽정"));
	studentList.add(new Student(3000,"전우치"));
	studentList.add(new Student(4000,"일지매"));
	studentList.add(new Student(5000,"장길산"));
	request.setAttribute("studentList", studentList);
	
	Map<String,Student> studentMap=new HashMap<String,Student>();
	studentMap.put("stu1", new Student(1000,"홍길동"));
	studentMap.put("stu2", new Student(2000,"임꺽정"));
	studentMap.put("stu3", new Student(3000,"전우치"));
	studentMap.put("stu4", new Student(4000,"일지매"));
	studentMap.put("stu5", new Student(5000,"장길산"));
	request.setAttribute("studentMap", studentMap);
	
	request.getRequestDispatcher("core_forEach_use.jsp").forward(request, response);
%>



