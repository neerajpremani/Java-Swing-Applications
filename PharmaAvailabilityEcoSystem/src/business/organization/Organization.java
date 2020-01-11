/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.employee.EmployeeDirectory;
import business.role.Role;
import business.useraccount.UserAccountDirectory;
import business.workqueue.WorkQueue;
import java.util.List;

/**
 *
 * @author NEERAJ PREMANI
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    //left
    //use UUID
    private String organizationID;
    //private static int counter = 0;
    private OrganizationType organizationType;

    public Organization(String name, String id) {
        this.name = name;
        //left
        workQueue = new WorkQueue();
        this.employeeDirectory = new EmployeeDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
        this.organizationID = id;
        //++counter;
    }

    public enum OrganizationType {
        Admin("Admin Organization"),//Common for all
        Manager("Manager Organization"), //Chemist
        Worker("Worker Organization"), //Chemist
        Approver("Approver Organization"), //Supplier
        Validator("Validator Organization"), //Legal
        Producer("Producer Organization"), //Manufacturer
        Doctor("Doctor Organization"), //Hospital
        Patient("Patient Organization"); //Hospital

        private String value;

        private OrganizationType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //left
    public abstract List<Role> getSupportedRole();

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public String getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    @Override
    public String toString() {
        return name;
    }

    public OrganizationType getOrganizationType() {
        return organizationType;
    }

}
