package dao;

import models.User;

import java.util.List;

public interface UserDao {

    User logIn(String username, String password);
    void addNewUser(User user);
    List<User> getUsers();
    User getUserById(int id);
    void deleteUser(int id);

}
