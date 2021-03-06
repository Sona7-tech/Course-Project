/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.orient.course.gui;

import az.orient.course.model.Lesson;
import az.orient.course.model.LoginUser;
import az.orient.course.model.Payment;
import az.orient.course.model.Student;
import az.orient.course.model.Teacher;
import az.orient.course.service.LessonService;
import az.orient.course.service.PaymentService;
import az.orient.course.service.StudentService;
import az.orient.course.service.TeacherService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class MainFrame extends javax.swing.JFrame {

    private StudentService studentService;
    private TeacherService teacherService;
    private LessonService lessonService;
    private PaymentService paymentService;
    private LoginUser loginUser;
    private String globBtnName = "";

    public MainFrame() {
        initComponents();
    }

    public MainFrame(StudentService studentService) {
        initComponents();
        this.studentService = studentService;
        //showStudentData();
    }

    public MainFrame(StudentService studentService, TeacherService teacherService, LessonService lessonService, PaymentService paymentService, LoginUser loginUser) {
        initComponents();
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.lessonService = lessonService;
        this.paymentService = paymentService;
        this.loginUser = loginUser;
        jLabel2.setText(loginUser.getName() + " " + loginUser.getSurname());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        teacherDataBtn = new javax.swing.JButton();
        paymentDataBtn = new javax.swing.JButton();
        studentDataBtn = new javax.swing.JButton();
        lessonDataBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        newBtn = new javax.swing.JButton();
        keyWordText = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        LogOutBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        teacherDataBtn.setText("Teacher Data");
        teacherDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherDataBtnActionPerformed(evt);
            }
        });

        paymentDataBtn.setText("Payment Data");
        paymentDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentDataBtnActionPerformed(evt);
            }
        });

        studentDataBtn.setText("Student Data");
        studentDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDataBtnActionPerformed(evt);
            }
        });

        lessonDataBtn.setText("Lesson Data");
        lessonDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessonDataBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teacherDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paymentDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(studentDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lessonDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(studentDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(teacherDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lessonDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(paymentDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        keyWordText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keyWordTextKeyReleased(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        LogOutBtn.setText("Log Out");
        LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Welcome");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(keyWordText, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBtn)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogOutBtn)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keyWordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)
                    .addComponent(LogOutBtn)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDataBtnActionPerformed
        try {
            showStudentData(studentService.getStudentList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        globBtnName = "student";
        keyWordText.setText("");
    }//GEN-LAST:event_studentDataBtnActionPerformed

    private void teacherDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherDataBtnActionPerformed
        try {
            showTeacherData(teacherService.getTeacherList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        globBtnName = "teacher";
        keyWordText.setText("");
    }//GEN-LAST:event_teacherDataBtnActionPerformed

    private void lessonDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessonDataBtnActionPerformed
        try {
            showLessonData(lessonService.getLessonList());
            globBtnName = "lesson";
            keyWordText.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lessonDataBtnActionPerformed

    private void paymentDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentDataBtnActionPerformed
        try {
            showPaymentData(paymentService.getPaymentList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        globBtnName = "payment";
        keyWordText.setText("");
    }//GEN-LAST:event_paymentDataBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        switch (globBtnName) {
            case "student":
                NewStudentFrame newStudentFrame = new NewStudentFrame(studentService);
                newStudentFrame.setVisible(true);
                break;
            case "teacher":
                NewTeacherFrame newTeacherFrame = new NewTeacherFrame(teacherService);
                newTeacherFrame.setVisible(true);
                break;
            case "lesson":
                NewLessonFrame newLessonFrame = new NewLessonFrame(lessonService);
                newLessonFrame.setVisible(true);
                break;
            case "payment":
                NewPaymentFrame newPaymentFrame = new NewPaymentFrame(paymentService, studentService, lessonService, teacherService);
                newPaymentFrame.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please, select menu");
        }
    }//GEN-LAST:event_newBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int rowIndex = jTable1.getSelectedRow();
        if (rowIndex != -1) {
            Long selectedId = (Long) jTable1.getValueAt(rowIndex, 0);
            switch (globBtnName) {
                case "student":
                    EditStudentFrame editStudentFrame = new EditStudentFrame(studentService, selectedId);
                    editStudentFrame.setVisible(true);
                    break;
                case "teacher":
                    EditTeacherFrame editTeacherFrame = new EditTeacherFrame(teacherService, selectedId);
                    editTeacherFrame.setVisible(true);
                    break;
                case "lesson":
                    EditLessonFrame editLessonFrame = new EditLessonFrame(lessonService, selectedId);
                    editLessonFrame.setVisible(true);
                    break;
                case "payment":
                    EditPaymentFrame editPaymentFrame = new EditPaymentFrame(paymentService, studentService, lessonService, teacherService, selectedId);
                    editPaymentFrame.setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please, select menu");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please, select menu");
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            editBtnActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int rowIndex = jTable1.getSelectedRow();
        try {
            if (rowIndex != -1) {
                Long selectedId = (Long) jTable1.getValueAt(rowIndex, 0);
                switch (globBtnName) {
                    case "student":
                        int isConfirmMessage = JOptionPane.showConfirmDialog(null, "Are you sure? ", "Delete Student", JOptionPane.YES_NO_OPTION);
                        if (isConfirmMessage == JOptionPane.YES_OPTION) {
                            studentService.deleteStudent(selectedId);
                            JOptionPane.showMessageDialog(null, "Student has been successfully deleted!");
                            showStudentData(studentService.getStudentList());
                        }
                        break;
                    case "teacher":
                        int isCfirmMessage = JOptionPane.showConfirmDialog(null, "Are you sure? ", "Delete Student", JOptionPane.YES_NO_OPTION);
                        if (isCfirmMessage == JOptionPane.YES_OPTION) {
                            teacherService.deleteTeacher(selectedId);
                            JOptionPane.showMessageDialog(null, "Teacher has been successfully deleted!");
                            showTeacherData(teacherService.getTeacherList());
                        }
                        break;
                    case "lesson":
                        int isConMessage = JOptionPane.showConfirmDialog(null, "Are you sure? ", "Delete Lesson", JOptionPane.YES_NO_OPTION);
                        if (isConMessage == JOptionPane.YES_OPTION) {
                            lessonService.deleteLesson(selectedId);
                            JOptionPane.showMessageDialog(null, "Lesson has been successfully deleted!");
                            showLessonData(lessonService.getLessonList());
                        }
                        break;
                    case "payment":
                        int confirmMessage = JOptionPane.showConfirmDialog(null, "Are you sure? ", "Delete Payment", JOptionPane.YES_NO_OPTION);
                        if (confirmMessage == JOptionPane.YES_OPTION) {
                            paymentService.deletePayment(selectedId);
                            JOptionPane.showMessageDialog(null, "Payment has been successfully deleted!");
                            showPaymentData(paymentService.getPaymentList());
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Please, select menu");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please, select menu");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problem! Student has not been successfully deleted!");
            e.printStackTrace();
        }

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed

        try {
            String keyWord = keyWordText.getText();
            switch (globBtnName) {
                case "student":
                    List<Student> studentList = studentService.searchStudentData(keyWord);
                    showStudentData(studentList);
                    break;
                case "teacher":
                    List<Teacher> teacherList = teacherService.searchTeacherData(keyWord);
                    showTeacherData(teacherList);
                    break;
                case "lesson":
                    List<Lesson> lessonList = lessonService.searchLessonData(keyWord);
                    showLessonData(lessonList);
                    break;
                case "payment":
                    List<Payment> paymentList = paymentService.searchPaymentData(keyWord);
                    showPaymentData(paymentList);
                    break;
                default:

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutBtnActionPerformed
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutBtnActionPerformed

    private void keyWordTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyWordTextKeyReleased
        searchBtnActionPerformed(null);
    }//GEN-LAST:event_keyWordTextKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField keyWordText;
    private javax.swing.JButton lessonDataBtn;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton paymentDataBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton studentDataBtn;
    private javax.swing.JButton teacherDataBtn;
    // End of variables declaration//GEN-END:variables

    private void showStudentData(List<Student> studentList) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        jTable1.setModel(model);
        model.addColumn("???");
        model.addColumn("Name");
        model.addColumn("Surname");
        model.addColumn("Address");
        model.addColumn("Date of Birth");
        model.addColumn("Phone");
        try {
            //List<Student> studentList = studentService.getStudentList();
            for (Student student : studentList) {
                Object[] data = new Object[]{
                    student.getId(), student.getName(), student.getSurname(), student.getAddress(), student.getDob(), student.getPhone()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showTeacherData(List<Teacher> teacherList) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        jTable1.setModel(model);
        model.addColumn("???");
        model.addColumn("Name");
        model.addColumn("Surname");
        model.addColumn("Address");
        model.addColumn("Phone");
        model.addColumn("Date of Birth");
        model.addColumn("Work Experience");

        try {
            //List<Teacher> teacherList = teacherService.getTeacherList();
            for (Teacher teacher : teacherList) {
                Object[] data = new Object[]{
                    teacher.getId(), teacher.getName(), teacher.getSurname(), teacher.getAddress(), teacher.getPhone(), teacher.getDob(),
                    teacher.getWorkExperience()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showLessonData(List<Lesson> lessonList) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        jTable1.setModel(model);
        model.addColumn("???");
        model.addColumn("Lesson name");
        model.addColumn("Lesson time");
        model.addColumn("Lesson price");

        try {
            // List<Lesson> lessonList = lessonService.getLessonList();
            for (Lesson lesson : lessonList) {

                Object[] data = new Object[]{
                    lesson.getId(), lesson.getName(), lesson.getTime(), lesson.getPrice()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showPaymentData(List<Payment> paymentList) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        jTable1.setModel(model);
        model.addColumn("???");
        model.addColumn("Student Fullname");
        model.addColumn("Lesson name");
        model.addColumn("Teacher Fullname");
        model.addColumn("Amount");
        model.addColumn("Payment Date");

        try {
            //List<Payment> paymentList = paymentService.getPaymentList();
            for (Payment payment : paymentList) {
                Object[] data = new Object[]{
                    payment.getId(), payment.getStudent().getName() + " " + payment.getStudent().getSurname(), payment.getLesson().getName(),
                    payment.getTeacher().getName() + " " + payment.getTeacher().getSurname(), payment.getAmount(), payment.getDate()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
