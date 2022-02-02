package az.orient.course.service;

import java.util.List;

import az.orient.course.model.Student;
import az.orient.course.model.Teacher;

public interface TeacherService {

    List<Teacher> getTeacherList() throws Exception;

    void addTeacher(Teacher teacher) throws Exception;

    void deleteTeacher(Long teacherId) throws Exception;

    void updateTeacher(Teacher teacher) throws Exception;

    Teacher getTeacherbyId(Long teacherId) throws Exception;
    
    List<Teacher> searchTeacherData(String keyword) throws Exception;

}
