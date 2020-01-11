/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role.hospital;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.hospital.DoctorOrganization;
import business.organization.chemist.ManagerOrganization;
import business.role.Role;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.chemist.managerrole.ManagerWorkAreaJPanel;
import userinterface.hospital.doctorrole.DoctorWorkAreaJPanel;

/**
 *
 * @author JAINHEMANT
 */
public class DoctorRole extends Role {

    public DoctorRole(RoleType type) {
        super(type);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new DoctorWorkAreaJPanel(userProcessContainer, account, (DoctorOrganization) organization, enterprise, business);
    }

}
