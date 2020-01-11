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

/**
 *
 * @author JAINHEMANT
 */
public abstract class Role {

    private RoleType roleType;

    public Role(RoleType type) {
        this.roleType = type;
    }

    public enum RoleType {

        Admin("Admin"),
        Worker("Worker"),
        Manager("Manager"),
        Approver("Approver"),
        Validator("Validator"),
        Doctor("Doctor"),
        Patient("Patient"),
        Producer("Producer");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            EcoSystem business,
            Network network);

    @Override
    public String toString() {
        //Need to verify this
        return getRoleType().value;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

}
