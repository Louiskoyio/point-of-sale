package dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao {

    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public User logIn(String username, String password) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE username = :username AND password = :password")
                    .addParameter("username", username)
                    .addParameter("password", password)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public void addNewUser(User user) {
        String sql = "INSERT INTO users (first_name,last_name,username,password,user_type,last_login,last_logout) VALUES (:first_name,:last_name,:username,:password,:user_type,:last_login,:last_logout)"; //if you change your model, be sure to update here as well!
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
           user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getUsers() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(User.class);
        }

    }

    @Override
    public User getUserById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(User.class); //fetch an individual item
        }
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE from users WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}