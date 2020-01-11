/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role.chemist;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.chemist.WorkerOrganization;
import business.role.Role;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.chemist.workerrole.WorkerWorkAreaJPanel;

/**
 *
 * @author JAINHEMANT
 */
public class WorkerRole extends Role {

    public WorkerRole(RoleType type) {
        super(type);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        //left
        return new WorkerWorkAreaJPanel(userProcessContainer, account, (WorkerOrganization) organization, enterprise);
    }

}
