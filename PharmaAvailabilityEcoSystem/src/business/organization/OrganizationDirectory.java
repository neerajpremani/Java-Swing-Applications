/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.organization.Organization.OrganizationType;
import business.organization.chemist.ManagerOrganization;
import business.organization.chemist.WorkerOrganization;
import business.organization.hospital.DoctorOrganization;
import business.organization.hospital.PatientOrganization;
import business.organization.legal.ValidatorOrganization;
import business.organization.manufacturer.ProducerOrganization;
import business.organization.supplier.ApproverOrganization;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author NEERAJ PREMANI
 */
public class OrganizationDirectory {

    private List<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(String name, OrganizationType type) {
        System.out.println(name + "   "+ type);
        Organization organization = null;
        UUID uuid = UUID.randomUUID();
        if (type.getValue().equals(OrganizationType.Admin.getValue())) {
            organization = new AdminOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Worker.getValue())) {
            organization = new WorkerOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Manager.getValue())) {
            organization = new ManagerOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Approver.getValue())) {
            organization = new ApproverOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Validator.getValue())) {
            organization = new ValidatorOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Producer.getValue())) {
            organization = new ProducerOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Doctor.getValue())) {
            organization = new DoctorOrganization(name, type, uuid.toString());
        } else if (type.getValue().equals(OrganizationType.Patient.getValue())) {
            organization = new PatientOrganization(name, type, uuid.toString());
        }
        organizationList.add(organization);
        return organization;
    }

    public void removeOrganization(Organization organization) {
        organizationList.remove(organization);
    }
}
