package az.orient.course.main;

import az.orient.course.dao.LessonDao;
import az.orient.course.dao.LoginUserDao;
import az.orient.course.dao.PaymentDao;
import java.sql.*;
import java.util.Locale;

import az.orient.course.dao.StudentDao;
import az.orient.course.dao.TeacherDao;
import az.orient.course.dao.impl.LessonDaoImpl;
import az.orient.course.dao.impl.LoginUserDaoImpl;
import az.orient.course.dao.impl.PaymentDaoImpl;
import az.orient.course.dao.impl.StudentDaolmpl;
import az.orient.course.dao.impl.TeacherDaolmpl;
import az.orient.course.gui.LoginFrame;
import az.orient.course.gui.MainFrame;
import az.orient.course.model.Student;
import az.orient.course.service.LessonService;
import az.orient.course.service.LoginUserService;
import az.orient.course.service.PaymentService;
import az.orient.course.service.StudentService;
import az.orient.course.service.TeacherService;
import az.orient.course.service.impl.LessonServiceImpl;
import az.orient.course.service.impl.LoginUserServiceImpl;
import az.orient.course.service.impl.PaymentServiceImpl;
import az.orient.course.service.impl.StudentServiceImpl;
import az.orient.course.service.impl.TeacherServiceImpl;

public class MainClass {

    public static void main(String[] args) {
       
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
           // MainFrame mainFrame = new MainFrame(studentService,teacherService,lessonService,paymentService);
           // mainFrame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

}
