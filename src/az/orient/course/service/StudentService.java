package az.orient.course.service;

import java.util.List;

import az.orient.course.model.Student;

public interface StudentService {

	List<Student> getStudentList() throws Exception;
	
	void addStudent(Student st) throws Exception;
	
    Student getStudentbyId(Long studentId) throws Exception;
	
	void updateStudent(Student student) throws Exception;
	
	void deleteStudent(Long studentId) throws Exception;
	
	List<Student> searchStudentData(String keyword) throws Exception;
}
