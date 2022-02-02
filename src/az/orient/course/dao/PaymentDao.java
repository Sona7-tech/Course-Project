package az.orient.course.dao;

import java.util.List;

import az.orient.course.model.Lesson;
import az.orient.course.model.Payment;

public interface PaymentDao {

    List<Payment> getPaymentList() throws Exception;

    void addPayment(Payment payment) throws Exception;

    Payment getPaymentbyId(Long paymentId) throws Exception;

    void updatePayment(Payment payment) throws Exception;

    void deletePayment(Long paymentId) throws Exception;
    
     List<Payment> searchPaymentData(String keyword) throws Exception;
}
