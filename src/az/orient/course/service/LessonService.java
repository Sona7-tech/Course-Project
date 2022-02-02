package az.orient.course.service;

import java.util.List;

import az.orient.course.model.Lesson;

public interface LessonService {

    List<Lesson> getLessonList() throws Exception;

    void addLesson(Lesson lesson) throws Exception;

    Lesson getLessonbyId(Long lessonId) throws Exception;

    void updateLesson(Lesson lesson) throws Exception;

    void deleteLesson(Long lessonId) throws Exception;

    List<Lesson> searchLessonData(String keyword) throws Exception;

}
