package dao;

import database.DBConnection;
import model.PurchaseDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDetailDAO {

    public boolean addPurchaseDetail(PurchaseDetail detail) {

        String sql = "INSERT INTO purchase_details "
                + "(purchase_id, product_id, quantity, unit_price, subtotal) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, detail.getPurchaseId());
            pst.setInt(2, detail.getProductId());
            pst.setInt(3, detail.getQuantity());
            pst.setDouble(4, detail.getUnitPrice());
            pst.setDouble(5, detail.getSubtotal());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PurchaseDetail> getAllPurchaseDetails() {

        List<PurchaseDetail> details = new ArrayList<>();

        String sql = "SELECT * FROM purchase_details";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                PurchaseDetail detail = new PurchaseDetail();

                detail.setDetailId(rs.getInt("detail_id"));
                detail.setPurchaseId(rs.getInt("purchase_id"));
                detail.setProductId(rs.getInt("product_id"));
                detail.setQuantity(rs.getInt("quantity"));
                detail.setUnitPrice(rs.getDouble("unit_price"));
                detail.setSubtotal(rs.getDouble("subtotal"));

                details.add(detail);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return details;
    }

    public boolean updatePurchaseDetail(PurchaseDetail detail) {

        String sql = "UPDATE purchase_details SET "
                + "purchase_id = ?, "
                + "product_id = ?, "
                + "quantity = ?, "
                + "unit_price = ?, "
                + "subtotal = ? "
                + "WHERE detail_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, detail.getPurchaseId());
            pst.setInt(2, detail.getProductId());
            pst.setInt(3, detail.getQuantity());
            pst.setDouble(4, detail.getUnitPrice());
            pst.setDouble(5, detail.getSubtotal());
            pst.setInt(6, detail.getDetailId());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePurchaseDetail(int detailId) {

        String sql =
                "DELETE FROM purchase_details WHERE detail_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, detailId);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}