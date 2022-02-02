package az.orient.course.service.impl;

import java.util.List;

import az.orient.course.dao.LessonDao;
import az.orient.course.dao.PaymentDao;
import az.orient.course.model.Payment;
import az.orient.course.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
    
    private PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public List<Payment> getPaymentList() throws Exception {
        
        return paymentDao.getPaymentList();
    }
    
    @Override
    public void addPayment(Payment payment) throws Exception {
        paymentDao.addPayment(payment);
    }
    
    @Override
    public Payment getPaymentbyId(Long paymentId) throws Exception {
        return paymentDao.getPaymentbyId(paymentId);
        
    }

    @Override
    public void updatePayment(Payment payment) throws Exception {
       paymentDao.updatePayment(payment);
    }

    @Override
    public void deletePayment(Long paymentId) throws Exception {
       paymentDao.deletePayment(paymentId);
    }

    @Override
    public List<Payment> searchPaymentData(String keyword) throws Exception {
       return paymentDao.searchPaymentData(keyword);
    }
    
}
