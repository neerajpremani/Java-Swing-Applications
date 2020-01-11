/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.manufacturer;

import business.organization.Organization;
import business.role.Role;
import business.role.Role.RoleType;
import business.role.manufacturer.ProducerRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaysh
 */
public class ProducerOrganization extends Organization {

    public ProducerOrganization(String name, OrganizationType type, String id) {
        super(name, id);
    }

    @Override
    public List<Role> getSupportedRole() {
        List<Role> roles = new ArrayList();
        roles.add(new ProducerRole(RoleType.Producer));
        return roles;
    }

}
