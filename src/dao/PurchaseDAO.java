package dao;

import database.DBConnection;
import model.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO {

    private Connection con;

    public PurchaseDAO() {
        try {
            con = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addPurchase(Purchase purchase) {

        String sql = "INSERT INTO purchases "
                + "(supplier_id, employee_id, purchase_date, total_amount) "
                + "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, purchase.getSupplierId());
            pst.setInt(2, purchase.getEmployeeId());
            pst.setString(3, purchase.getPurchaseDate());
            pst.setDouble(4, purchase.getTotalAmount());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePurchase(Purchase purchase) {

        String sql = "UPDATE purchases SET "
                + "supplier_id=?, employee_id=?, purchase_date=?, "
                + "total_amount=? WHERE purchase_id=?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, purchase.getSupplierId());
            pst.setInt(2, purchase.getEmployeeId());
            pst.setString(3, purchase.getPurchaseDate());
            pst.setDouble(4, purchase.getTotalAmount());
            pst.setInt(5, purchase.getPurchaseId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePurchase(int purchaseId) {

        String sql = "DELETE FROM purchases WHERE purchase_id=?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, purchaseId);

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Purchase> getAllPurchases() {

        List<Purchase> purchases = new ArrayList<>();

        String sql = "SELECT * FROM purchases";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Purchase purchase = new Purchase(
                        rs.getInt("purchase_id"),
                        rs.getInt("supplier_id"),
                        rs.getInt("employee_id"),
                        rs.getString("purchase_date"),
                        rs.getDouble("total_amount")
                );

                purchases.add(purchase);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return purchases;
    }
}