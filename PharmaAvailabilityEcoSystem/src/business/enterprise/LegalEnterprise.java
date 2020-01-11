/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.role.Role;
import java.util.List;

/**
 *
 * @author JAINHEMANT
 */
public class LegalEnterprise extends Enterprise {

    public LegalEnterprise(String name, EnterpriseType type, String id) {
        super(name, type, id);
    }

    @Override
    public List<Role> getSupportedRole() {
        return null;
    }

}
