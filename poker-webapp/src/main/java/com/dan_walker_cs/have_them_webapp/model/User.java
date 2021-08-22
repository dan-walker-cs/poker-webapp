package com.dan_walker_cs.have_them_webapp.model;



import javax.persistence.*;

// ORM mapping - maps this class to a DB table
@Entity
// Table name in DB is 'users' - differs from class name
@Table(name = "users")
// This class is the blueprint for the system's user entities
public class User {

    // identifies this variable as the table's primary key
    @Id
    // specifies that values for this field are automatically generated (best practice for primary keys)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean active;
    private String username;
    private String password;
    private String roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public void setRoles(String roles) { this.roles = roles; }

    public String getRoles() { return roles; }
}
