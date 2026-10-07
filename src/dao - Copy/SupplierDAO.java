
package dao;

import database.DBConnection;
import model.Supplier;


import database.DBConnection;
import model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {

    private Connection con;

    public SupplierDAO() {
        try {
            con = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add Supplier
    public boolean addSupplier(Supplier supplier) {

        String sql = "INSERT INTO suppliers (supplier_name, address, phone) VALUES (?, ?, ?)";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, supplier.getName());
            pst.setString(2, supplier.getAddress());
            pst.setString(3, supplier.getPhone());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update Supplier
    public boolean updateSupplier(Supplier supplier) {

        String sql = "UPDATE suppliers SET supplier_name=?, address=?, phone=? WHERE supplier_id=?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, supplier.getName());
            pst.setString(2, supplier.getAddress());
            pst.setString(3, supplier.getPhone());
            pst.setInt(4, supplier.getId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete Supplier
    public boolean deleteSupplier(int id) {

       String sql = "DELETE FROM suppliers WHERE supplier_id=?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, id);

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get All Suppliers
    public List<Supplier> getAllSuppliers() {

        List<Supplier> suppliers = new ArrayList<>();

        String sql = "SELECT * FROM suppliers";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Supplier supplier = new Supplier(
                        rs.getInt("supplier_id"),
                        rs.getString("supplier_name"),
                        rs.getString("address"),
                        rs.getString("phone")
                );

                suppliers.add(supplier);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return suppliers;
    }
}

