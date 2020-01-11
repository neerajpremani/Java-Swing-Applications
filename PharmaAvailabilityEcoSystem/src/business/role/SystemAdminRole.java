/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.sysadminrole.SystemAdminWorkAreaJPanel;

/**
 *
 * @author JAINHEMANT
 */
public class SystemAdminRole extends Role {

    public SystemAdminRole(RoleType type) {
        super(type);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system, Network network) {
        System.out.println("Creating work area for system admin role");
        return new SystemAdminWorkAreaJPanel(userProcessContainer, system);
    }

}
