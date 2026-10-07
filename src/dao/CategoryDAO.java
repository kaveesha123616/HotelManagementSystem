package dao;

import database.DBConnection;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private Connection con;

    public CategoryDAO() {
        try {
            con = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addCategory(Category category) {

        String sql = "INSERT INTO categories (category_name) VALUES (?)";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, category.getCategoryName());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCategory(Category category) {

        String sql = "UPDATE categories SET category_name=? WHERE category_id=?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, category.getCategoryName());
            pst.setInt(2, category.getCategoryId());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCategory(int categoryId) {

        String sql = "DELETE FROM categories WHERE category_id=?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, categoryId);

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Category> getAllCategories() {

        List<Category> categories = new ArrayList<>();

        String sql = "SELECT * FROM categories";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Category category = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name")
                );

                categories.add(category);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }
}