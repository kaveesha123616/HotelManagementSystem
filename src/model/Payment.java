/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Payment {
    private int paymentId;
    private int saleId;
private double amount;
private String paymentMethod;
private String paymentDate;
public Payment() {
}
public int getPaymentId() {
    return paymentId;
}
public int getSaleId() {
    return saleId;
}

public double getAmount() {
    return amount;
}
public String getPaymentMethod() {
    return paymentMethod;
}
public String getPaymentDate() {
    return paymentDate;
}
public void setPaymentId(int paymentId) {
    this.paymentId = paymentId;
}
public void setSaleId(int saleId) {
    this.saleId = saleId;

}
public void setAmount(double amount) {
    this.amount = amount;
}
public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
}
public void setPaymentDate(String paymentDate) {
    this.paymentDate = paymentDate;
}
    
}
