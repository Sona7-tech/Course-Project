package az.orient.course.dao;

import java.util.List;

import az.orient.course.model.Teacher;

public interface TeacherDao {

    List<Teacher> getTeacherList() throws Exception;

    void addTeacher(Teacher t) throws Exception;

    void deleteTeacher(Long teacherId) throws Exception;

    void updateTeacher(Teacher teacher) throws Exception;

    Teacher getTeacherbyId(Long teacherId) throws Exception;
    
    List<Teacher> searchTeacherData(String keyword) throws Exception;

}
