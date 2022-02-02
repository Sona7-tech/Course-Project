package az.orient.course.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.orient.course.dao.DBHelper;
import az.orient.course.dao.PaymentDao;
import az.orient.course.model.Lesson;
import az.orient.course.model.Payment;
import az.orient.course.model.Student;
import az.orient.course.model.Teacher;

public class PaymentDaoImpl implements PaymentDao {

    @Override
    public List<Payment> getPaymentList() throws Exception {
        List<Payment> paymentList = new ArrayList<>();

        String sql = "SELECT P.ID, S.ID S_ID, S.NAME STUDENT_NAME, S.SURNAME STUDENT_SURNAME,\r\n"
                + "L.NAME LESSON_NAME, L.ID L_ID,\r\n"
                + "T.NAME TEACHER_NAME, T.ID T_ID, T.SURNAME TEACHER_SURNAME,\r\n"
                + "P.ID P_ID,\r\n"
                + "P.PAYMENT_AMOUNT,\r\n"
                + "P.PAYMENT_DATE\r\n"
                + "FROM PAYMENT P\r\n"
                + "INNER JOIN STUDENT S\r\n"
                + "ON P.STUDENT_ID = S.ID\r\n"
                + "INNER JOIN TEACHER T\r\n"
                + "ON P.TEACHER_ID = T.ID\r\n"
                + "INNER JOIN LESSON L\r\n"
                + "ON P.LESSON_ID = L.ID\r\n"
                + "WHERE P.ACTIVE = 1\r\n"
                + "ORDER BY P.ID";
        try (Connection c = DBHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getLong("P_ID"));
                Student student = new Student();
                student.setId(rs.getLong("S_ID"));
                student.setName(rs.getString("STUDENT_NAME"));
                student.setSurname(rs.getString("STUDENT_SURNAME"));

                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("T_ID"));
                teacher.setName(rs.getString("TEACHER_NAME"));
                teacher.setSurname(rs.getString("TEACHER_SURNAME"));
                Lesson lesson = new Lesson();
                lesson.setId(rs.getLong("L_ID"));
                lesson.setName(rs.getString("LESSON_NAME"));
                payment.setStudent(student);
                payment.setTeacher(teacher);
                payment.setLesson(lesson);
                payment.setAmount(rs.getDouble("PAYMENT_AMOUNT"));
                payment.setDate(rs.getDate("PAYMENT_DATE"));
                paymentList.add(payment);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return paymentList;
    }

    @Override
    public void addPayment(Payment payment) throws Exception {
        String sql = "INSERT INTO PAYMENT\n"
                + "VALUES(PAYMENT_SEQ.NEXTVAL,?,?,?,?,SYSDATE,1)";
        try (Connection c = DBHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, payment.getStudent().getId());
            ps.setLong(2, payment.getLesson().getId());
            ps.setLong(3, payment.getTeacher().getId());
            ps.setDouble(4, payment.getAmount());
            ps.execute();
            c.commit();

        }
    }

    @Override
    public Payment getPaymentbyId(Long paymentId) throws Exception {
        Payment payment = new Payment();

        String sql = "SELECT P.ID P_ID, S.ID S_ID, S.NAME STUDENT_NAME, S.SURNAME STUDENT_SURNAME,\r\n"
                + "L.NAME LESSON_NAME, L.ID L_ID,L.PRICE,\r\n"
                + "T.NAME TEACHER_NAME, T.ID T_ID, T.SURNAME TEACHER_SURNAME,\r\n"
                + "P.PAYMENT_AMOUNT,\r\n"
                + "P.PAYMENT_DATE\r\n"
                + "FROM PAYMENT P\r\n"
                + "INNER JOIN STUDENT S\r\n"
                + "ON P.STUDENT_ID = S.ID\r\n"
                + "INNER JOIN TEACHER T\r\n"
                + "ON P.TEACHER_ID = T.ID\r\n"
                + "INNER JOIN LESSON L\r\n"
                + "ON P.LESSON_ID = L.ID\r\n"
                + "WHERE P.ACTIVE = 1\r\n"
                + "AND P.ID = ?";
        try (Connection c = DBHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, paymentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                payment.setId(rs.getLong("P_ID"));
                Student student = new Student();
                student.setId(rs.getLong("S_ID"));
                student.setName(rs.getString("STUDENT_NAME"));
                student.setSurname(rs.getString("STUDENT_SURNAME"));

                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("T_ID"));
                teacher.setName(rs.getString("TEACHER_NAME"));
                teacher.setSurname(rs.getString("TEACHER_SURNAME"));
                Lesson lesson = new Lesson();
                lesson.setPrice(rs.getDouble("PRICE"));
                lesson.setId(rs.getLong("L_ID"));
                lesson.setName(rs.getString("LESSON_NAME"));
                payment.setStudent(student);
                payment.setTeacher(teacher);
                payment.setLesson(lesson);
                payment.setAmount(rs.getDouble("PAYMENT_AMOUNT"));
                payment.setDate(rs.getDate("PAYMENT_DATE"));

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return payment;
    }

    @Override
    public void updatePayment(Payment payment) throws Exception {
        String sql = "UPDATE PAYMENT SET STUDENT_ID = ?,TEACHER_ID = ?,LESSON_ID = ?,PAYMENT_AMOUNT = ? WHERE ID = ?";
        try (Connection c = DBHelper.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, payment.getStudent().getId());
            ps.setLong(2, payment.getTeacher().getId());
            ps.setLong(3, payment.getLesson().getId());
            ps.setDouble(4, payment.getAmount());
            ps.setLong(5, payment.getId());
            ps.execute();
            c.commit();

        }
    }

    @Override
    public void deletePayment(Long paymentId) throws Exception {
        	   String sql = "UPDATE PAYMENT SET ACTIVE = 0 "
                + " WHERE ID = ?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, paymentId);
            ps.execute();
            c.commit();

        }
    }

    @Override
    public List<Payment> searchPaymentData(String keyword) throws Exception {
        
         List<Payment> paymentList = new ArrayList<>();
		String sql = "SELECT P.ID, S.ID S_ID, S.NAME STUDENT_NAME, S.SURNAME STUDENT_SURNAME,\n" +
"                L.NAME LESSON_NAME, L.ID L_ID,\n" +
"                T.NAME TEACHER_NAME, T.ID T_ID, T.SURNAME TEACHER_SURNAME,\n" +
"                P.ID P_ID,\n" +
"                P.PAYMENT_AMOUNT,\n" +
"                P.PAYMENT_DATE\n" +
"                FROM PAYMENT P\n" +
"                INNER JOIN STUDENT S\n" +
"                ON P.STUDENT_ID = S.ID\n" +
"                INNER JOIN TEACHER T\n" +
"                ON P.TEACHER_ID = T.ID\n" +
"                INNER JOIN LESSON L\n" +
"                ON P.LESSON_ID = L.ID\n" +
"                WHERE P.ACTIVE = 1\n" +
"                AND (LOWER(S.NAME) LIKE LOWER(?) OR LOWER(S.SURNAME) LIKE LOWER(?) OR LOWER(L.NAME) LIKE LOWER(?) OR LOWER(T.NAME) LIKE LOWER(?) OR LOWER(T.SURNAME) LIKE LOWER(?) OR LOWER(PAYMENT_AMOUNT) LIKE LOWER(?)) ORDER BY P.ID";
		try(Connection c = DBHelper.getConnection();PreparedStatement ps =c.prepareStatement(sql);
				) {
			ps.setString(1, "%" + keyword + "%");
			ps.setString(2, "%" + keyword + "%");
			ps.setString(3, "%" + keyword + "%");
                        ps.setString(4, "%" + keyword + "%");
			ps.setString(5, "%" + keyword + "%");
			ps.setString(6, "%" + keyword + "%");
                        ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					Payment payment = new Payment();
					payment.setId(rs.getLong("ID"));
                                        payment.setAmount(rs.getDouble("PAYMENT_AMOUNT"));
                                        
                                        Student student = new Student();
                                        student.setId(rs.getLong("S_ID"));
                                        student.setName(rs.getString("STUDENT_NAME"));
                                        student.setSurname(rs.getString("STUDENT_SURNAME"));
                                        
                                        Lesson lesson = new Lesson();
                                        lesson.setId(rs.getLong("L_ID"));
                                        lesson.setName(rs.getString("LESSON_NAME"));
                                        
                                        Teacher teacher = new Teacher();
                                        teacher.setId(rs.getLong("T_ID"));
                                        teacher.setName(rs.getString("TEACHER_NAME"));
                                        teacher.setSurname(rs.getString("TEACHER_SURNAME"));
                                        payment.setStudent(student);
                                        payment.setLesson(lesson);
                                        payment.setTeacher(teacher);
					paymentList.add(payment);
				}
		

		} catch (Exception e) {

			e.printStackTrace();
		}
		return paymentList; 
    }

}
