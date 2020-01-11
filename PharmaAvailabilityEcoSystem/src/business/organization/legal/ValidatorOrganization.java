/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.legal;

import business.organization.Organization;
import business.role.Role;
import business.role.legal.ValidatorRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaysh
 */
public class ValidatorOrganization extends Organization {

    public ValidatorOrganization(String name, OrganizationType type, String id) {
        super(name, id);
    }

    @Override
    public List<Role> getSupportedRole() {
        List<Role> roles = new ArrayList<>();
        roles.add(new ValidatorRole(Role.RoleType.Validator));
        return roles;
    }

}
