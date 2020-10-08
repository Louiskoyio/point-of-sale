package dao;

import models.Product;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oProductDao implements ProductDao {

    private final Sql2o sql2o;

    public Sql2oProductDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void addNewProduct(Product user) {

    }

    @Override
    public List<Product> getProducts() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM products")
                    .executeAndFetch(Product.class);
        }
    }

    @Override
    public Product getProductById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM products WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Product.class); //fetch an individual item
        }
    }

    @Override
    public void deleteProduct(int id) {
        String sql = "DELETE from products WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void updateProduct(int id) {
        String sql = "UPDATE products SET  WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
