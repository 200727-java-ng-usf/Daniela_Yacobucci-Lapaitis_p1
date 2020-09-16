package com.revature.ers.dtos;

import com.revature.ers.models.ErsUser;

import java.util.Objects;

public class UserView {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String roleName;

    public UserView(ErsUser ersUser) {
        this.id = ersUser.getErsUserId();
        this.username = ersUser.getUsername();
        this.firstName = ersUser.getFirstName();
        this.lastName = ersUser.getLastName();
        this.email = ersUser.getEmail();
        //this.roleName = ersUser.getErsUserRole().get;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserView userView = (UserView) o;
        return id == userView.id &&
                Objects.equals(username, userView.username) &&
                Objects.equals(firstName, userView.firstName) &&
                Objects.equals(lastName, userView.lastName) &&
                Objects.equals(email, userView.email) &&
                Objects.equals(roleName, userView.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, email, roleName);
    }

    @Override
    public String toString() {
        return "UserView{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
