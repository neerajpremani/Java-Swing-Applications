/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.role.AdminRole;
import business.role.Role;
import business.role.Role.RoleType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEERAJ PREMANI
 */
public class AdminOrganization extends Organization {

    public AdminOrganization(String name, OrganizationType type, String id) {
        super(name, id);
    }

    @Override
    public List<Role> getSupportedRole() {
        List<Role> roles = new ArrayList();
        roles.add(new AdminRole(RoleType.Admin));
        return roles;
    }

}
