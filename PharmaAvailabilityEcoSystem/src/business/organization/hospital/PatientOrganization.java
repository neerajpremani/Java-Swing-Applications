/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization.hospital;

import business.organization.Organization;
import business.role.Role;
import business.role.chemist.ManagerRole;
import business.role.hospital.PatientRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEERAJ PREMANI
 */
public class PatientOrganization extends Organization {
     public PatientOrganization(String name, Organization.OrganizationType type, String id) {
        super(name, id);
    }

    @Override
    public List<Role> getSupportedRole() {
        List<Role> roles = new ArrayList();
        roles.add(new PatientRole(Role.RoleType.Patient));
        return roles;
    }
}
