package com.revature.ers.models;

import javax.persistence.*;

@Entity
@Table(name = "ers_users", schema = "project_1")
//TODO add schema on application.properties and reference it on all tables
public class ErsUser {

    @Id @GeneratedValue
    @Column(name="ers_user_id")
    private int ersUserId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_role_id")
    private ErsUserRole ersUserRole;

    public int getErsUserId() {
        return ersUserId;
    }

    public void setErsUserId(int ersUserId) {
        this.ersUserId = ersUserId;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ErsUserRole getErsUserRole() {
        return ersUserRole;
    }

    public void setErsUserRole(ErsUserRole ersUserRole) {
        this.ersUserRole = ersUserRole;
    }

    @Override
    public String toString() {
        return "ErsUser{" +
                "ersUserId=" + ersUserId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", ersUserRole=" + ersUserRole +
                '}';
    }
}
