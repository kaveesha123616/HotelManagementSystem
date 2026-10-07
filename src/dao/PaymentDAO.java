package dao;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Payment;

public class PaymentDAO {

    public boolean addPayment(Payment payment) {

        String sql = "INSERT INTO payments "
                + "(sale_id, amount, payment_method, payment_date) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, payment.getSaleId());
            pst.setDouble(2, payment.getAmount());
            pst.setString(3, payment.getPaymentMethod());
            pst.setString(4, payment.getPaymentDate());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public java.util.List<Payment> getAllPayments() {

        java.util.List<Payment> payments =
                new java.util.ArrayList<>();

        String sql = "SELECT * FROM payments";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             java.sql.ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                Payment payment = new Payment();

                payment.setPaymentId(
                        rs.getInt("payment_id"));

                payment.setSaleId(
                        rs.getInt("sale_id"));

                payment.setAmount(
                        rs.getDouble("amount"));

                payment.setPaymentMethod(
                        rs.getString("payment_method"));

                payment.setPaymentDate(
                        rs.getString("payment_date"));

                payments.add(payment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return payments;
    }

    public boolean updatePayment(Payment payment) {

        String sql = "UPDATE payments SET "
                + "sale_id = ?, amount = ?, payment_method = ?, "
                + "payment_date = ? "
                + "WHERE payment_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, payment.getSaleId());
            pst.setDouble(2, payment.getAmount());
            pst.setString(3, payment.getPaymentMethod());
            pst.setString(4, payment.getPaymentDate());
            pst.setInt(5, payment.getPaymentId());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePayment(int paymentId) {

        String sql =
                "DELETE FROM payments WHERE payment_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, paymentId);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}