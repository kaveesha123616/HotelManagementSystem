/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dao.PaymentDAO;
import model.Payment;

/**
 *
 * @author ASUS
 */
public class PaymentService {
    private PaymentDAO paymentDAO;

public PaymentService() {
    paymentDAO = new PaymentDAO();
}

public boolean addPayment(Payment payment) {
    return paymentDAO.addPayment(payment);
}
public java.util.List<Payment> getAllPayments() {
    return paymentDAO.getAllPayments();
}
public boolean updatePayment(Payment payment) {
    return paymentDAO.updatePayment(payment);
}
public boolean deletePayment(int paymentId) {
    return paymentDAO.deletePayment(paymentId);
}
    
}
