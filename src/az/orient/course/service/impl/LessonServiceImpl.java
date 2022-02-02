package az.orient.course.service.impl;

import java.util.List;

import az.orient.course.dao.LessonDao;
import az.orient.course.dao.StudentDao;
import az.orient.course.model.Lesson;
import az.orient.course.service.LessonService;

public class LessonServiceImpl implements LessonService{
	
	private LessonDao lessonDao;
	public LessonServiceImpl(LessonDao lessonDao) {
		this.lessonDao = lessonDao;
	}
	@Override
	public List<Lesson> getLessonList() throws Exception {
		
		return lessonDao.getLessonList();
	}

    @Override
    public void addLesson(Lesson lesson) throws Exception {
        lessonDao.addLesson(lesson);
    }

    @Override
    public Lesson getLessonbyId(Long lessonId) throws Exception {
        return lessonDao.getLessonbyId(lessonId);
    }

    @Override
    public void updateLesson(Lesson lesson) throws Exception {
        lessonDao.updateLesson(lesson);
    }

    @Override
    public void deleteLesson(Long lessonId) throws Exception {
        lessonDao.deleteLesson(lessonId);
    }

    @Override
    public List<Lesson> searchLessonData(String keyword) throws Exception {
        return lessonDao.searchLessonData(keyword);
    }
  
	

}
