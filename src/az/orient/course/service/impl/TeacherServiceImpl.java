package az.orient.course.service.impl;

import java.util.List;

import az.orient.course.dao.TeacherDao;
import az.orient.course.model.Teacher;
import az.orient.course.service.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	private TeacherDao teacherDao;
	
	public TeacherServiceImpl(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public List<Teacher> getTeacherList() throws Exception {
		// TODO Auto-generated method stub
		return teacherDao.getTeacherList();
	}

	@Override
	public void addTeacher(Teacher t) throws Exception {
		
		 teacherDao.addTeacher(t);
		
	}

    @Override
    public void deleteTeacher(Long teacherId) throws Exception {
        teacherDao.deleteTeacher(teacherId);
    }

    @Override
    public void updateTeacher(Teacher teacher) throws Exception {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public Teacher getTeacherbyId(Long teacherId) throws Exception {
       return teacherDao.getTeacherbyId(teacherId);
    }

    @Override
    public List<Teacher> searchTeacherData(String keyword) throws Exception {
        return teacherDao.searchTeacherData(keyword);
    }
	
	 

}
