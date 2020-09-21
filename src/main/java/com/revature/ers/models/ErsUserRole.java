package com.revature.ers.models;

import javax.persistence.*;

@Entity
@Table(name = "ers_user_roles", schema = "project_1")
public class ErsUserRole {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name")
    private String roleName;

    public ErsUserRole(){

    }

    public ErsUserRole(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "ErsUserRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    //TODO display 'Fin mngr' as 'Finance Manager'
}
