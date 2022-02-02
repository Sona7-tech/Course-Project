package az.orient.course.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.course.dao.DBHelper;
import az.orient.course.dao.StudentDao;
import az.orient.course.model.Student;

public class StudentDaolmpl implements StudentDao {

	@Override
	public List<Student> getStudentList() throws Exception {

		List<Student> studentList = new ArrayList<>();
		Connection c = null; // baza ile elaqe yaradir
		PreparedStatement ps = null;// sql-i run etmek ucun istifade olunur
		ResultSet rs = null; // sql-den qayidan neticeni zounde saxlayir
		String sql = "SELECT ID, NAME, SURNAME, DOB, ADDRESS, PHONE FROM STUDENT\r\n" + "WHERE ACTIVE = 1";
		try {

			c = DBHelper.getConnection();
			if (c != null) {

				ps = c.prepareStatement(sql);
				rs = ps.executeQuery(sql);
				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getLong("ID"));
					student.setName(rs.getString("NAME"));
					student.setSurname(rs.getString("SURNAME"));
					student.setDob(rs.getDate("DOB"));
					student.setAddress(rs.getString("ADDRESS"));
					student.setPhone(rs.getString("PHONE"));
					studentList.add(student);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (c != null) {

				c.close();
			}
			if (ps != null) {

				ps.close();
			}
			if (rs != null) {

				rs.close();
			}
		}
		return studentList;

	}

	@Override
	public void addStudent(Student st) throws Exception {
		
		String sql ="INSERT INTO STUDENT(ID,NAME,SURNAME,DOB,ADDRESS,PHONE)"
				+ "VALUES(STUDENT_SEQ.NEXTVAL,?,?,?,?,?)";
		try(Connection c=DBHelper.getConnection();PreparedStatement ps = c.prepareStatement(sql);){
			ps.setString(1, st.getName());
			ps.setString(2, st.getSurname());
			ps.setDate(3, new java.sql.Date(st.getDob().getTime()));
			ps.setString(4, st.getAddress());
			ps.setString(5, st.getPhone());
			ps.execute();
			c.commit();
			
		}
		
	}

	@Override
	public Student getStudentbyId(Long studentId) throws Exception {
		Student student = new Student();
		String sql = "SELECT ID S_ID, NAME, SURNAME, DOB, ADDRESS, PHONE FROM STUDENT\r\n" + "WHERE ACTIVE = 1 AND ID = ?";
		try(Connection c = DBHelper.getConnection(); PreparedStatement ps=c.prepareStatement(sql)) {
                                ps.setLong(1, studentId);
			        ResultSet rs  = ps.executeQuery();
				

				if(rs.next()) {
					student.setId(rs.getLong("S_ID"));
					student.setName(rs.getString("NAME"));
					student.setSurname(rs.getString("SURNAME"));
					student.setDob(rs.getDate("DOB"));
					student.setAddress(rs.getString("ADDRESS"));
					student.setPhone(rs.getString("PHONE"));
				}
				else {
					student = null;
				}
			

		} 
		return student;
	}

	@Override
	public void updateStudent(Student student) throws Exception {
		String sql = "UPDATE STUDENT SET NAME = ?, SURNAME = ?, DOB = ?, ADDRESS = ?, PHONE = ? "
                + " WHERE ID = ?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setDate(3, new java.sql.Date(student.getDob().getTime()));
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getPhone());
            ps.setLong(6, student.getId());
            ps.execute();
            c.commit();

        } catch (Exception e) {

            e.printStackTrace();
        }	
	}

	@Override
	public void deleteStudent(Long studentId) throws Exception {
            
		   String sql = "UPDATE STUDENT SET ACTIVE = 0 "
                + " WHERE ID = ?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, studentId);
            ps.execute();
            c.commit();

        }
		
	}

	@Override
	public List<Student> searchStudentData(String keyword) throws Exception {
		
		List<Student> studentList = new ArrayList<>();
		String sql = "SELECT ID,NAME,SURNAME,DOB,ADDRESS,PHONE FROM STUDENT WHERE ACTIVE = 1\r\n"
				+ "AND (LOWER(NAME) LIKE LOWER(?) OR LOWER(SURNAME) LIKE LOWER(?) OR LOWER(ADDRESS) LIKE LOWER(?) OR LOWER(PHONE) LIKE LOWER(?)) ORDER BY ID";
		try(Connection c = DBHelper.getConnection();PreparedStatement ps =c.prepareStatement(sql);
				) {
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ps.setString(3, "%" + keyword + "%");
			ps.setString(4, "%" + keyword + "%");
                        ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getLong("ID"));
					student.setName(rs.getString("NAME"));
					student.setSurname(rs.getString("SURNAME"));
					student.setDob(rs.getDate("DOB"));
					student.setAddress(rs.getString("ADDRESS"));
					student.setPhone(rs.getString("PHONE"));
					studentList.add(student);
				}
		

		} catch (Exception e) {

			e.printStackTrace();
		}
		return studentList;
	}

}
