package dao;

import database.DBConnection;
import model.Sale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {

    private Connection con;

    public SaleDAO() {
        try {
            con = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add Sale
    public boolean addSale(Sale sale) {

        String sql = "INSERT INTO sales "
                + "(customer_id, employee_id, sale_date, total_amount, payment_status) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, sale.getCustomerId());
            pst.setInt(2, sale.getEmployeeId());
            pst.setString(3, sale.getSaleDate());
            pst.setDouble(4, sale.getTotalAmount());
            pst.setString(5, sale.getPaymentStatus());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update Sale
    public boolean updateSale(Sale sale) {

        String sql = "UPDATE sales SET "
                + "customer_id=?, employee_id=?, sale_date=?, "
                + "total_amount=?, payment_status=? "
                + "WHERE sale_id=?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, sale.getCustomerId());
            pst.setInt(2, sale.getEmployeeId());
            pst.setString(3, sale.getSaleDate());
            pst.setDouble(4, sale.getTotalAmount());
            pst.setString(5, sale.getPaymentStatus());
            pst.setInt(6, sale.getSaleId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete Sale
    public boolean deleteSale(int saleId) {

        String sql = "DELETE FROM sales WHERE sale_id=?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, saleId);

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get All Sales
    public List<Sale> getAllSales() {

        List<Sale> sales = new ArrayList<>();

        String sql = "SELECT * FROM sales";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Sale sale = new Sale(
                        rs.getInt("sale_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("employee_id"),
                        rs.getString("sale_date"),
                        rs.getDouble("total_amount"),
                        rs.getString("payment_status")
                );

                sales.add(sale);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sales;
    }
}