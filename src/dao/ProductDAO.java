/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import database.DBConnection;
import model.Product;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ProductDAO {
   private Connection con;

public ProductDAO() {
    try {
        con = DBConnection.getConnection();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public boolean addProduct(Product product) {

    String sql = "INSERT INTO products "
            + "(product_name, category, buying_price, selling_price, quantity, status) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    try {
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, product.getProductName());
        ps.setString(2, product.getCategory());
        ps.setDouble(3, product.getBuyingPrice());
        ps.setDouble(4, product.getSellingPrice());
        ps.setInt(5, product.getQuantity());
        ps.setString(6, product.getStatus());

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean updateProduct(Product product) {

    String sql = "UPDATE products SET "
            + "product_name=?, category=?, buying_price=?, "
            + "selling_price=?, quantity=?, status=? "
            + "WHERE product_id=?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, product.getProductName());
        ps.setString(2, product.getCategory());
        ps.setDouble(3, product.getBuyingPrice());
        ps.setDouble(4, product.getSellingPrice());
        ps.setInt(5, product.getQuantity());
        ps.setString(6, product.getStatus());
        ps.setInt(7, product.getProductId());

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean deleteProduct(int productId) {

    String sql = "DELETE FROM products WHERE product_id=?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, productId);

        ps.executeUpdate();

        return true;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public List<Product> getAllProducts() {

    List<Product> productList = new ArrayList<>();

    String sql = "SELECT * FROM products";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Product product = new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("category"),
                    rs.getDouble("buying_price"),
                    rs.getDouble("selling_price"),
                    rs.getInt("quantity"),
                    rs.getString("status")
            );

            productList.add(product);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return productList;
}
}
