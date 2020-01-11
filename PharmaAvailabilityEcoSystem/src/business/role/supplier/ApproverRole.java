/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role.supplier;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.supplier.ApproverOrganization;
import business.role.Role;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.supplier.approverrole.ApproverWorkAreaJPanel;

/**
 *
 * @author NEERAJ PREMANI
 */
public class ApproverRole extends Role {

    public ApproverRole(RoleType type) {
        super(type);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new ApproverWorkAreaJPanel(userProcessContainer,account,(ApproverOrganization)organization,enterprise,business, network);
    }

}
