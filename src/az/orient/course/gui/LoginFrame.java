/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.course.gui;

import az.orient.course.dao.LessonDao;
import az.orient.course.dao.LoginUserDao;
import az.orient.course.dao.PaymentDao;
import az.orient.course.dao.StudentDao;
import az.orient.course.dao.TeacherDao;
import az.orient.course.dao.impl.LessonDaoImpl;
import az.orient.course.dao.impl.LoginUserDaoImpl;
import az.orient.course.dao.impl.PaymentDaoImpl;
import az.orient.course.dao.impl.StudentDaolmpl;
import az.orient.course.dao.impl.TeacherDaolmpl;
import az.orient.course.model.LoginUser;
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

/**
 *
 * @author Lenovo
 */
public class LoginFrame extends javax.swing.JFrame {

        StudentDao studentDao = new StudentDaolmpl();
        StudentService studentService = new StudentServiceImpl(studentDao);
        TeacherDao teacherDao = new TeacherDaolmpl();
        TeacherService teacherService = new TeacherServiceImpl(teacherDao);
        LessonDao lessonDao = new LessonDaoImpl();
        LessonService lessonService = new LessonServiceImpl(lessonDao);
        PaymentDao paymentDao = new PaymentDaoImpl();
        PaymentService paymentService = new PaymentServiceImpl(paymentDao);
         LoginUserDao loginUserDao = new LoginUserDaoImpl();
        LoginUserService loginUserService = new LoginUserServiceImpl(loginUserDao);
    public LoginFrame() {
        initComponents();
        errorMsg.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JPasswordField();
        LogInBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        errorMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Userame");

        jLabel2.setText("Password");

        LogInBtn.setText("Log In");
        LogInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInBtnActionPerformed(evt);
            }
        });

        ClearBtn.setText("Clear");
        ClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBtnActionPerformed(evt);
            }
        });

        errorMsg.setForeground(new java.awt.Color(255, 51, 51));
        errorMsg.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(LogInBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorMsg)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(passwordTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addComponent(usernameTxt))
                    .addComponent(ClearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(errorMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LogInBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInBtnActionPerformed
        String username = usernameTxt.getText();
        String password = passwordTxt.getText();
        try {
            if(username !=null && !username.isEmpty() && password != null && !password.isEmpty()){
            LoginUser loginUser  =   loginUserService.login(username, password);
            if(loginUser != null){
                errorMsg.setVisible(false);
                MainFrame mainFrame = new MainFrame(studentService, teacherService, lessonService, paymentService,loginUser);
                mainFrame.setVisible(true);
                this.dispose();
            }
            else{
               errorMsg.setVisible(true);
               errorMsg.setText("Username or Password is invalid!");
            }
        }
        else{
            errorMsg.setVisible(true);
            errorMsg.setText("Username or Password is empty!");
        } 
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_LogInBtnActionPerformed

    private void ClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBtnActionPerformed
       usernameTxt.setText("");
       passwordTxt.setText("");
    }//GEN-LAST:event_ClearBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton LogInBtn;
    private javax.swing.JLabel errorMsg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
}