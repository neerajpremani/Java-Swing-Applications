/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.network.NetworkDirectory;
import business.organization.Organization;
import business.role.Role;
import business.role.Role.RoleType;
import business.role.SystemAdminRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jaysh
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    NetworkDirectory networkDirectory;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {

        super("EcoSystem", "ecosystem_id");
        networkDirectory = new NetworkDirectory();
    }

//    public boolean checkIfUserIsUnique(String userName) {
//        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
//            return false;
//        }
//        for (Network network : networkList) {
//
//        }
//        return true;
//    }
    public NetworkDirectory getNetworkDirectory() {
        return networkDirectory;
    }

//    public void setNetworkDirectory(NetworkDirectory networkDirectory) {
//        this.networkDirectory = networkDirectory;
//    }
    @Override
    public List<Role> getSupportedRole() {
        List<Role> roleList = new ArrayList();
        roleList.add(new SystemAdminRole(RoleType.Admin));
        return roleList;
    }
}
