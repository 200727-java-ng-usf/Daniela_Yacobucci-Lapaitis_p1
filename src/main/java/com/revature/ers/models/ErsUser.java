package com.revature.ers.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dtos.Principal;

//TODO add schema on application.properties and reference it on all tables
public class ErsUser {

    private int ersUserId;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

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

    public static ErsUser JSONtoObj(String ersUserJSON) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ErsUser ersUser = mapper.readValue(ersUserJSON, ErsUser.class);
        return ersUser;
    }
}
