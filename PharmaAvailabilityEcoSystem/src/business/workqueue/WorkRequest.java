/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workqueue;

import business.enterprise.Enterprise;
import business.useraccount.UserAccount;
import java.util.Date;
import java.util.Stack;

/**
 *
 * @author NEERAJ PREMANI
 */
public class WorkRequest {

    private String requestId;
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private String request;
    private Date requestDate;
    private Date resolveDate;
    private Stack<Enterprise> enterpriseStack;

    public enum workRequestType {
        
        Drugs("Drugs"),
        PatientRequests("PatientRequests");
        

        private String value;

        private workRequestType(String value) {
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

    public WorkRequest(String size) {
        this.requestDate = new Date();
        this.requestId = size;
        this.status = "";
        this.enterpriseStack = new Stack<>();
    }

    public String getRequestId() {
        return requestId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return requestId;
    }

    public Stack<Enterprise> getEnterpriseStack() {
        return enterpriseStack;
    }

    public void setEnterpriseStack(Stack<Enterprise> enterpriseStack) {
        this.enterpriseStack = enterpriseStack;
    }
}
