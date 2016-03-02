package database;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;

@ManagedBean(name="user")
@RequestScoped
public class User {

    private int id;
    private String username;
    private String password;
    private Date created_date;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUsername() {return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id: " + id
                + ", username: " + username
                + ", password: " + password
                + "}";

    }
}
