package az.orient.course.service.impl;

import java.util.List;

import az.orient.course.dao.StudentDao;
import az.orient.course.model.Student;
import az.orient.course.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> getStudentList() throws Exception {
		
		return studentDao.getStudentList();
	}

	@Override
	public void addStudent(Student st) throws Exception {
		
		studentDao.addStudent(st);
		
	}

	@Override
	public Student getStudentbyId(Long studentId) throws Exception {
		
		return studentDao.getStudentbyId(studentId);
	}

	@Override
	public void updateStudent(Student student) throws Exception {
		
		 studentDao.updateStudent(student);
		
	}

	@Override
	public void deleteStudent(Long studentId) throws Exception {
		 studentDao.deleteStudent(studentId);
		
	}

	@Override
	public List<Student> searchStudentData(String keyword) throws Exception {
		
		return studentDao.searchStudentData(keyword);
	}

}
