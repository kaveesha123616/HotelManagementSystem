/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import dao.ProductDAO;
import model.Product;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ProductService {
    private ProductDAO productDAO;

public ProductService() {
    productDAO = new ProductDAO();
}
public boolean addProduct(Product product) {
    return productDAO.addProduct(product);
}
public boolean updateProduct(Product product) {
    return productDAO.updateProduct(product);
}
public boolean deleteProduct(int productId) {
    return productDAO.deleteProduct(productId);
}
public List<Product> getAllProducts() {
    return productDAO.getAllProducts();
}
    
}
