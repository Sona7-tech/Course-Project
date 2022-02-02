package az.orient.course.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.course.dao.DBHelper;
import az.orient.course.dao.LessonDao;
import az.orient.course.model.Lesson;
import az.orient.course.model.Student;

public class LessonDaoImpl implements LessonDao {
    
    @Override
    public List<Lesson> getLessonList() throws Exception {
        
        List<Lesson> lessonList = new ArrayList<>();
        
        String sql = "SELECT ID, NAME, TIME, PRICE FROM LESSON\r\n" + "WHERE ACTIVE = 1";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);) {
            
            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(rs.getLong("ID"));
                lesson.setName(rs.getString("NAME"));
                lesson.setTime(rs.getInt("TIME"));
                lesson.setPrice(rs.getDouble("PRICE"));
                lessonList.add(lesson);
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }        
        
        return lessonList;
    }
    
    @Override
    public void addLesson(Lesson lesson) throws Exception {
        
        String sql = "INSERT INTO LESSON(ID,NAME,TIME,PRICE)"
                + "VALUES(STUDENT_SEQ.NEXTVAL,?,?,?)";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, lesson.getName());
            ps.setInt(2, lesson.getTime());
            ps.setDouble(3, lesson.getPrice());
            ps.execute();
            c.commit();
            
        }
        
    }
    
    @Override
    public Lesson getLessonbyId(Long lessonId) throws Exception {
        Lesson lesson = new Lesson();
        String sql = "SELECT ID L_ID, NAME, TIME, PRICE FROM LESSON\r\n" + "WHERE ACTIVE = 1 AND ID = ?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, lessonId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                lesson.setId(rs.getLong("L_ID"));
                lesson.setName(rs.getString("NAME"));
                lesson.setTime(rs.getInt("TIME"));
                lesson.setPrice(rs.getDouble("PRICE"));
                
            } else {
                lesson = null;
            }
            
        }        
        return lesson;
    }
    
    @Override
    public void updateLesson(Lesson lesson) throws Exception {
        String sql = "UPDATE LESSON SET NAME = ?, TIME = ?, PRICE = ? "
                + " WHERE ID = ?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, lesson.getName());
            ps.setInt(2, lesson.getTime());
            ps.setDouble(3, lesson.getPrice());
            ps.setLong(4, lesson.getId());
            ps.execute();
            c.commit();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLesson(Long lessonId) throws Exception {
           String sql = "UPDATE LESSON SET ACTIVE = 0 "
                + " WHERE ID = ?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, lessonId);
            ps.execute();
            c.commit();

        }
    }

    @Override
    public List<Lesson> searchLessonData(String keyword) throws Exception {
        List<Lesson> lessonList = new ArrayList<>();
		String sql = "SELECT ID,NAME,TIME,PRICE FROM LESSON WHERE ACTIVE = 1\r\n"
				+ "AND (LOWER(NAME) LIKE LOWER(?) OR LOWER(TIME) LIKE LOWER(?) OR LOWER(PRICE) LIKE LOWER(?)) ORDER BY ID";
		try(Connection c = DBHelper.getConnection();PreparedStatement ps =c.prepareStatement(sql);
				) {
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ps.setString(3, "%" + keyword + "%");
                        ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Lesson lesson = new Lesson();
					lesson.setId(rs.getLong("ID"));
					lesson.setName(rs.getString("NAME"));
                                        lesson.setTime(rs.getInt("TIME"));
                                        lesson.setPrice(rs.getDouble("PRICE"));
					lessonList.add(lesson);
				}
		

		} catch (Exception e) {

			e.printStackTrace();
		}
		return lessonList;
    }
    
}
