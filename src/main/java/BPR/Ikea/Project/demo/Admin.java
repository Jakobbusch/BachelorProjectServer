package BPR.Ikea.Project.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    /**
     * empty controller
     */
    public Admin() {
    }

    /**
     * Controller for admin
     * @param username
     * @param password
     */
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * To get username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * To set username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * To get password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * To set password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
