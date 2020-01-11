/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.drug.Drug;
import business.employee.Employee;
import business.enterprise.ChemistEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.EnterpriseDirectory;
import business.enterprise.LegalEnterprise;
import business.enterprise.ManufacturerEnterprise;
import business.enterprise.SupplierEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.OrganizationDirectory;
import business.role.AdminRole;
import business.role.Role;
import business.role.SystemAdminRole;
import business.role.chemist.ManagerRole;
import business.role.chemist.WorkerRole;
import business.role.legal.ValidatorRole;
import business.role.manufacturer.ProducerRole;
import business.role.supplier.ApproverRole;
import business.useraccount.UserAccount;
import commonutils.Helper;
import commonutils.PasswordUtility;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jaysh
 */
public class ConfigureASystem {

    private static final String emailID = "noreply.optimizeprime.pass@gmail.com";

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        //NetworkDirectory networkDirectory = new NetworkDirectory();
        system.networkDirectory.createAndAddNetwork("boston");
        system.networkDirectory.createAndAddNetwork("newyorkcity");

        for (Network network : system.getNetworkDirectory().getNetworkList()) {

            EnterpriseDirectory enterpriseDirectory = new EnterpriseDirectory();
            for (int entepriseCounter = 1; entepriseCounter < 2; entepriseCounter++) {
                addEnterpriseToDirectory(network, enterpriseDirectory, entepriseCounter);
            }
            network.setEnterpriseDirectory(enterpriseDirectory);
        }

        //system.networkDirectory = networkDirectory;
        //create an enterprise
        //initialize some organizations
        //have some employees
        //create user account
        Employee employee = system.getEmployeeDirectory().createEmployee("BROCODERS");

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("admin", "admin", "noreply.optimizeprime.pass@gmail.com", employee, new SystemAdminRole(Role.RoleType.Admin));

        return system;
    }

    public static void addEnterpriseToDirectory(Network network, EnterpriseDirectory enterpriseDirectory, int i) {
        //Add enterprisedirectory and create enterprises

        Enterprise chemistEnterprise = enterpriseDirectory.createAndAddEnterprise(network.getName().substring(0, 1) + "Chemist" + i,
                Enterprise.EnterpriseType.Chemist);
        String name = network.getName().substring(0, 1) + "chementadmin" + i;
        Employee chemistAdminEmployee = chemistEnterprise.getEmployeeDirectory().createEmployee(name);
        chemistEnterprise.getUserAccountDirectory().createUserAccount(name,
                PasswordUtility.createPassword(name), emailID, chemistAdminEmployee, new AdminRole(Role.RoleType.Admin));
        ChemistEnterprise tempcChemistEnterprise = (ChemistEnterprise) chemistEnterprise;
        tempcChemistEnterprise.getInventory().setDrugStock(generateInventory());

        name = network.getName().substring(0, 1) + "suppentadmin" + i;
        Enterprise supplierEnterprise = enterpriseDirectory.createAndAddEnterprise(network.getName().substring(0, 1) + "Supplier" + i,
                Enterprise.EnterpriseType.Supplier);
        Employee supplierAdminEmployee = supplierEnterprise.getEmployeeDirectory().createEmployee(name);
        supplierEnterprise.getUserAccountDirectory().createUserAccount(name,
                PasswordUtility.createPassword(name), emailID, supplierAdminEmployee, new AdminRole(Role.RoleType.Admin));
        SupplierEnterprise tempSupplierEnterprise = (SupplierEnterprise) supplierEnterprise;
        tempSupplierEnterprise.getInventory().setDrugStock(generateInventory());

        name = network.getName().substring(0, 1) + "legalentadmin" + i;
        Enterprise legalEnterprise = enterpriseDirectory.createAndAddEnterprise(network.getName().substring(0, 1) + "Legal" + i,
                Enterprise.EnterpriseType.Legal);
        Employee legalAdminEmployee = legalEnterprise.getEmployeeDirectory().createEmployee(name);
        legalEnterprise.getUserAccountDirectory().createUserAccount(name,
                PasswordUtility.createPassword(name), emailID, legalAdminEmployee, new AdminRole(Role.RoleType.Admin));

        name = network.getName().substring(0, 1) + "manuentadmin" + i;
        Enterprise manufacturerEnterprise = enterpriseDirectory.createAndAddEnterprise(network.getName().substring(0, 1) + "Manufacturer" + i, Enterprise.EnterpriseType.Manufacturer);
        Employee manufacturerAdminEmployee = manufacturerEnterprise.getEmployeeDirectory().createEmployee(name);
        manufacturerEnterprise.getUserAccountDirectory().createUserAccount(name,
                PasswordUtility.createPassword(name), emailID, manufacturerAdminEmployee, new AdminRole(Role.RoleType.Admin));

        //Enterprises have been added now. Let's populate Organizations in the Enterprise
        for (Enterprise enterprise : enterpriseDirectory.getEnterpriseList()) {
            OrganizationDirectory organizationDirectory = new OrganizationDirectory();
            //Adding organizations to the different enterprises
            for (int organizationCounter = 1; organizationCounter < 3; organizationCounter++) {
                addOrganizationToDirectory(organizationDirectory, enterprise, organizationCounter, network.getName());
            }

            enterprise.setOrganizationDirectory(organizationDirectory);

        }

    }

    public static void addOrganizationToDirectory(OrganizationDirectory organizationDirectory, Enterprise enterprise, int j, String networkName) {
        //Adding Admin in all the enterprises by default

        if (enterprise instanceof ChemistEnterprise) {
            //Adding Worker and Manager in Chemist Enterprise
            Organization worker = organizationDirectory.createOrganization(networkName.substring(0, 1) + "Worker" + j, Organization.OrganizationType.Worker);
            for (int employeeCounter = 0; employeeCounter < 2; employeeCounter++) {
                String name = networkName.substring(0, 1) + "worker" + Helper.nextNumGenerator();
                Employee workerEmp = worker.getEmployeeDirectory().createEmployee(name);
                Role workerRole = new WorkerRole(Role.RoleType.Worker);
                worker.getUserAccountDirectory().createUserAccount(name, PasswordUtility.createPassword(name), emailID, workerEmp, workerRole);

            }
            Organization manager = organizationDirectory.createOrganization(networkName.substring(0, 1) + "Manager" + j, Organization.OrganizationType.Manager);
            for (int employeeCounter = 0; employeeCounter < 2; employeeCounter++) {
                String name = networkName.substring(0, 1) + "manager" + Helper.nextNumGenerator();
                Employee managerEmp = manager.getEmployeeDirectory().createEmployee(name);
                Role managerRole = new ManagerRole(Role.RoleType.Manager);
                manager.getUserAccountDirectory().createUserAccount(name, PasswordUtility.createPassword(name), emailID, managerEmp, managerRole);
            }

        } else if (enterprise instanceof SupplierEnterprise) {
            //Adding Approver and Manager in Supplier Enterprise
            Organization approver = organizationDirectory.createOrganization(networkName.substring(0, 1) + "Approver" + j, Organization.OrganizationType.Approver);

            for (int employeeCounter = 0; employeeCounter < 2; employeeCounter++) {
                String name = networkName.substring(0, 1) + "approver" + Helper.nextNumGenerator();
                Employee approverEmp = approver.getEmployeeDirectory().createEmployee(name);
                Role approverRole = new ApproverRole(Role.RoleType.Approver);
                approver.getUserAccountDirectory().createUserAccount(name, PasswordUtility.createPassword(name), emailID, approverEmp, approverRole);
            }
        } else if (enterprise instanceof LegalEnterprise) {
            //Adding Validator in Legal Enterprise

            Organization validator = organizationDirectory.createOrganization(networkName.substring(0, 1) + "Validator" + j, Organization.OrganizationType.Validator);
            for (int employeeCounter = 0; employeeCounter < 2; employeeCounter++) {
                String name = networkName.substring(0, 1) + "validator" + Helper.nextNumGenerator();
                Employee validatorEmp = validator.getEmployeeDirectory().createEmployee(name);
                Role validatorRole = new ValidatorRole(Role.RoleType.Validator);
                validator.getUserAccountDirectory().createUserAccount(name, PasswordUtility.createPassword(name), emailID, validatorEmp, validatorRole);
            }
        } else if (enterprise instanceof ManufacturerEnterprise) {
            //Adding Producer in Manufacturer Enterprise
            Organization producer = organizationDirectory.createOrganization(networkName.substring(0, 1) + "Producer" + j, Organization.OrganizationType.Producer);
            for (int employeeCounter = 0; employeeCounter < 2; employeeCounter++) {
                String name = networkName.substring(0, 1) + "producer" + Helper.nextNumGenerator();
                Employee producerEmp = producer.getEmployeeDirectory().createEmployee(name);
                Role producerRole = new ProducerRole(Role.RoleType.Producer);
                producer.getUserAccountDirectory().createUserAccount(name, PasswordUtility.createPassword(name), emailID, producerEmp, producerRole);

            }
        }
    }

    public static List<Drug> generateInventory() {
        List<Drug> drugStock = new ArrayList<>();
        List<String> drugs = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            drugs.add("drug" + i);
        }
        Random random = new Random();
//        random.nextInt(10);
        int sizeOfInventory = (random.ints(4, 10)).findAny().getAsInt();
        for (int j = 1; j <= sizeOfInventory; j++) {
            String drugName = drugs.get(random.nextInt(10));
            if (drugStock.stream().noneMatch(d -> d.getName().equals(drugName))) {
                Drug drug = new Drug();
                drug.setName(drugName);
                drug.setQuantity(random.nextInt(30));
                drugStock.add(drug);
            }

        }
        return drugStock;
    }

}
