package com.revature.ers.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dtos.Principal;

import javax.persistence.*;

@Entity
@Table(name = "ers_users", schema = "project_1")
//TODO add schema on application.properties and reference it on all tables
public class ErsUser {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
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

    @Column(name="status")
    private boolean status;

    //empty constructor
    public ErsUser(){

    }

    //no id, no status, no password
    public ErsUser(String username, String firstName, String lastName, String email, ErsUserRole ersUserRole) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ersUserRole = ersUserRole;
    }

    //no id, no password
    public ErsUser(String username, String firstName, String lastName, String email, ErsUserRole ersUserRole, boolean status) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ersUserRole = ersUserRole;
        this.status = status;
    }

    // no id
    public ErsUser(String username, String password, String firstName, String lastName, String email, ErsUserRole ersUserRole, boolean status) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ersUserRole = ersUserRole;
        this.status = status;
    }

    // all
    public ErsUser(int ersUserId, String username, String password, String firstName, String lastName, String email, ErsUserRole ersUserRole, boolean status) {
        this.ersUserId = ersUserId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.ersUserRole = ersUserRole;
        this.status = status;
    }

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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
                ", status=" + status +
                '}';
    }

    public static ErsUser JSONtoObj(String ersUserJSON) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ErsUser ersUser = mapper.readValue(ersUserJSON, ErsUser.class);
        return ersUser;
    }
}
