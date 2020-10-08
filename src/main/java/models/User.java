package models;

public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private String user_type;
    private String last_login;
    private String last_logout;

    public User(String first_name, String last_name, String username, String password, String user_type, String last_login, String last_logout) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        this.last_login = last_login;
        this.last_logout = last_logout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getLast_logout() {
        return last_logout;
    }

    public void setLast_logout(String last_logout) {
        this.last_logout = last_logout;
    }
}
