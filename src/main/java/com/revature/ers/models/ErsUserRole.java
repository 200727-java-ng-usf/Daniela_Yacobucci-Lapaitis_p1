package com.revature.ers.models;

public enum ErsUserRole {

    // values declared within enums are constants and are comma separated

    ADMIN("Admin"),//.ordinal=0
    FINANCE_MANAGER("Fin Mngr"),
    EMPLOYEE("Employee"),
    INACTIVE("Inactive");

    public String roleName;

    ErsUserRole(String Name) {
        this.roleName = Name;
    }

    public static int getIDFromName(String name) {

        ErsUserRole currentRole = ErsUserRole.getByName(name);

        if(currentRole.ordinal() >= 0 && currentRole.ordinal() <= 4 )
        {
            return currentRole.ordinal();
        } else {
            return 3;
        }

    }

    public static int getDBIDFromName(String name) {

        ErsUserRole currentRole = ErsUserRole.getByName(name);

        if(currentRole.ordinal() + 1 > 0 && currentRole.ordinal() + 1 < 4 )
        {
            return currentRole.ordinal()+1;
        } else {
            return 4;
        }

    }

    public static ErsUserRole getByID(int id) {

        for (ErsUserRole role : ErsUserRole.values()) {
            if(role.ordinal() == id) {
                return role;
            }
        }

        return null;
    }

    public static ErsUserRole getByDBID(int id) {

        for (ErsUserRole role : ErsUserRole.values()) {
            if(role.ordinal() + 1== id) {
                return role;
            }
        }

        return null;
    }

    public static ErsUserRole getByName(String name) {

        for (ErsUserRole role : ErsUserRole.values()) {
            if (role.roleName.equals(name)) {
                return role;
            }
        }

        return INACTIVE;

    }

    @Override
    public String toString() {
        return roleName;
    }
}