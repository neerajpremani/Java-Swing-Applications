/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role.legal;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.legal.ValidatorOrganization;
import business.role.Role;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import userinterface.legal.validatorrole.ValidatorWorkArea;

/**
 *
 * @author JAINHEMANT
 */
public class ValidatorRole extends Role {

    public ValidatorRole(RoleType type) {
        super(type);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        //left
        return new ValidatorWorkArea(userProcessContainer,account,(ValidatorOrganization)organization,enterprise);
    }

}
