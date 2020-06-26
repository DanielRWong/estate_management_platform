package com.benjaminbutton.json;

import java.util.List;

/**
 * @author WWX
 * @description
 * @date 2020-06-25 22:19
 * @modified By
 */
public class Permissions {
    private List<Permission> permissions;

    public Permissions() {
    }

    public Permissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Permissions{" +
                "permissions=" + permissions +
                '}';
    }
}
