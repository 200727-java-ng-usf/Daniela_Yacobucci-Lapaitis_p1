package com.revature.ers.dtos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.models.ErsUser;

import java.util.Objects;

public class Principal {

    private int id;
    private String username;
    private String roleName;
    private int roleId;

    public Principal() {
        super();
    }

    public Principal(ErsUser ersUser) {
        this.id = ersUser.getErsUserId();
        this.username = ersUser.getUsername();
        this.roleName = ersUser.getErsUserRole().getRoleName();
        this.roleId = ersUser.getErsUserRole().getRoleId();
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role) {
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Principal principal = (Principal) o;
        return id == principal.id &&
                roleId == principal.roleId &&
                Objects.equals(username, principal.username) &&
                Objects.equals(roleName, principal.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, roleName, roleId);
    }

    @Override
    public String toString() {
        return "Principal{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleId=" + roleId +
                '}';
    }

    //Convenience methods
    public String stringify() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public static Principal JSONtoObj(String principalJSON) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Principal principalObject = mapper.readValue(principalJSON, Principal.class);
        return principalObject;
    }

}
