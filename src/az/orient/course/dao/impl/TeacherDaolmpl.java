package az.orient.course.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.course.dao.DBHelper;
import az.orient.course.dao.TeacherDao;
import az.orient.course.model.Student;
import az.orient.course.model.Teacher;

public class TeacherDaolmpl implements TeacherDao {

    @Override
    public List<Teacher> getTeacherList() throws Exception {

        List<Teacher> teacherList = new ArrayList<>();
        String sql = "SELECT ID, NAME, SURNAME, DOB, ADDRESS, PHONE, WORK_EXPERIENCE FROM TEACHER\r\n" + "WHERE ACTIVE = 1";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("ID"));
                teacher.setName(rs.getString("NAME"));
                teacher.setSurname(rs.getString("SURNAME"));
                teacher.setDob(rs.getDate("DOB"));
                teacher.setAddress(rs.getString("ADDRESS"));
                teacher.setPhone(rs.getString("PHONE"));
                teacher.setWorkExperience(rs.getInt("WORK_EXPERIENCE"));
                teacherList.add(teacher);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return teacherList;
    }

    @Override
    public void addTeacher(Teacher t) throws Exception {
        String sql = "INSERT INTO TEACHER(ID, NAME, SURNAME, DOB, ADDRESS, PHONE,WORK_EXPERIENCE)\n"
                + "VALUES(TEACHER_SEQ.NEXTVAL, ?,?,?,?,?,?)";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, t.getName());
            ps.setString(2, t.getSurname());
            ps.setDate(3, new java.sql.Date(t.getDob().getTime()));
            ps.setString(4, t.getAddress());
            ps.setString(5, t.getPhone());
            ps.setInt(6, t.getWorkExperience());
            ps.execute();
            c.commit();

        }
    }

    @Override
    public void deleteTeacher(Long teacherId) throws Exception {

        String sql = "UPDATE TEACHER SET ACTIVE = 0 "
                + " WHERE ID = ?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, teacherId);
            ps.execute();
            c.commit();

        }
    }

    @Override
    public void updateTeacher(Teacher teacher) throws Exception {
        
        String sql = "UPDATE TEACHER SET NAME = ?, SURNAME = ?, DOB = ?, ADDRESS = ?, PHONE = ?, WORK_EXPERIENCE = ? "
                + " WHERE ID = ?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurname());
            ps.setDate(3, new java.sql.Date(teacher.getDob().getTime()));
            ps.setString(4, teacher.getAddress());
            ps.setString(5, teacher.getPhone());
            ps.setInt(6, teacher.getWorkExperience());
            ps.setLong(7, teacher.getId());
            ps.execute();
            c.commit();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public Teacher getTeacherbyId(Long teacherId) throws Exception {
       
       Teacher teacher = new Teacher();
		String sql = "SELECT ID T_ID, NAME, SURNAME, DOB, ADDRESS, PHONE, WORK_EXPERIENCE FROM TEACHER  WHERE ACTIVE = 1 AND ID = ?";
		try(Connection c = DBHelper.getConnection(); PreparedStatement ps=c.prepareStatement(sql)) {
                                ps.setLong(1, teacherId);
			        ResultSet rs  = ps.executeQuery();
				

				if(rs.next()) {
					teacher.setId(rs.getLong("T_ID"));
					teacher.setName(rs.getString("NAME"));
					teacher.setSurname(rs.getString("SURNAME"));
					teacher.setDob(rs.getDate("DOB"));
					teacher.setAddress(rs.getString("ADDRESS"));
					teacher.setPhone(rs.getString("PHONE"));
                                        teacher.setWorkExperience(rs.getInt("WORK_EXPERIENCE"));
				}
				else {
					teacher = null;
				}
			

		} 
		return teacher;
    }

    @Override
    public List<Teacher> searchTeacherData(String keyword) throws Exception {
        List<Teacher> teacherList = new ArrayList<>();
		String sql = "SELECT ID,NAME,SURNAME,DOB,ADDRESS,PHONE,WORK_EXPERIENCE FROM TEACHER WHERE ACTIVE = 1\r\n"
				+ "AND (LOWER(NAME) LIKE LOWER(?) OR LOWER(SURNAME) LIKE LOWER(?) OR LOWER(ADDRESS) LIKE LOWER(?) OR LOWER(PHONE) LIKE LOWER(?) OR LOWER(WORK_EXPERIENCE) LIKE LOWER(?)) ORDER BY ID";
		try(Connection c = DBHelper.getConnection();PreparedStatement ps =c.prepareStatement(sql);
				) {
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ps.setString(3, "%" + keyword + "%");
			ps.setString(4, "%" + keyword + "%");
                        ps.setString(5, "%" + keyword + "%");
                        ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Teacher teacher = new Teacher();
					teacher.setId(rs.getLong("ID"));
					teacher.setName(rs.getString("NAME"));
					teacher.setSurname(rs.getString("SURNAME"));
					teacher.setDob(rs.getDate("DOB"));
					teacher.setAddress(rs.getString("ADDRESS"));
					teacher.setPhone(rs.getString("PHONE"));
                                        teacher.setWorkExperience(rs.getInt("WORK_EXPERIENCE"));
					teacherList.add(teacher);
				}
		

		} catch (Exception e) {

			e.printStackTrace();
		}
		return teacherList;
    }

}
