package dao;

import database.DBConnection;
import model.SaleDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SaleDetailDAO {

    // Add Sale Detail
    public boolean addSaleDetail(SaleDetail detail) {

        String sql = "INSERT INTO sale_details "
                + "(sale_id, product_id, quantity, unit_price, subtotal) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, detail.getSaleId());
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

    // Get All Sale Details
    public List<SaleDetail> getAllSaleDetails() {

        List<SaleDetail> details = new ArrayList<>();

        String sql = "SELECT * FROM sale_details";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                SaleDetail detail = new SaleDetail();

                detail.setDetailId(rs.getInt("detail_id"));
                detail.setSaleId(rs.getInt("sale_id"));
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

    // Update Sale Detail
    public boolean updateSaleDetail(SaleDetail detail) {

        String sql = "UPDATE sale_details SET "
                + "sale_id = ?, "
                + "product_id = ?, "
                + "quantity = ?, "
                + "unit_price = ?, "
                + "subtotal = ? "
                + "WHERE detail_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, detail.getSaleId());
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

    // Delete Sale Detail
    public boolean deleteSaleDetail(int detailId) {

        String sql =
                "DELETE FROM sale_details WHERE detail_id = ?";

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