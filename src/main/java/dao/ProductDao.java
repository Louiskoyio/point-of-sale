package dao;

import models.Product;

import java.util.List;

public interface ProductDao {
    void addNewProduct(Product user);
    List<Product> getProducts();
    Product getProductById(int id);
    void deleteProduct(int id);
    void updateProduct(int id);
}
