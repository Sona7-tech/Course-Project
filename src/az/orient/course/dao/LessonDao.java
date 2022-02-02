package az.orient.course.dao;

import java.util.List;

import az.orient.course.model.Lesson;
import az.orient.course.model.Student;

public interface LessonDao {

    List<Lesson> getLessonList() throws Exception;

    void addLesson(Lesson lesson) throws Exception;

    Lesson getLessonbyId(Long lessonId) throws Exception;

    void updateLesson(Lesson lesson) throws Exception;

    void deleteLesson(Long lessonId) throws Exception;
    
     List<Lesson> searchLessonData(String keyword) throws Exception;

}
