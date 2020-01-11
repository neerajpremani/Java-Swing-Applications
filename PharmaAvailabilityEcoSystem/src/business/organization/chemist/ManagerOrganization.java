/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.chemist;

import business.organization.Organization;
import business.role.Role;
import business.role.chemist.ManagerRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEERAJ PREMANI
 */
public class ManagerOrganization extends Organization {

    public ManagerOrganization(String name, OrganizationType type, String id) {
        super(name, id);
    }

    @Override
    public List<Role> getSupportedRole() {
        List<Role> roles = new ArrayList();
        roles.add(new ManagerRole(Role.RoleType.Manager));
        return roles;
    }
}
