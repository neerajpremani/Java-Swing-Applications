/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.hospital.doctorrole;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.organization.chemist.WorkerOrganization;
import business.organization.hospital.DoctorOrganization;
import business.organization.hospital.PatientOrganization;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequest;
import business.workqueue.WorkRequestDoctor;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import userinterface.chemist.managerrole.AssignToSupplier;
import userinterface.chemist.managerrole.ManagerWorkAreaJPanel;
import userinterface.chemist.workerrole.WorkerWorkAreaJPanel;

/**
 *
 * @author JAINHEMANT
 */
public class ViewPatientRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewPatientRequestJPanel
     */
    
     private JPanel userProcessContainer;
     private DoctorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem ecosystem;
    private static final Logger log = LogManager.getLogger(WorkerWorkAreaJPanel.class);

    public ViewPatientRequestJPanel(JPanel userProcessContainer, UserAccount account, DoctorOrganization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        System.out.println("Doctor Pateint request  " +organization+ "  "+ userAccount+ "   "+ enterprise);
        workRequestJTable.getTableHeader().setFont(new Font("Segoe UI", 1, 20));
        populateDoctorTable();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sendToPatient = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxFilter = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignToMe = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        sendToPatient.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendToPatient.setText("Process");
        sendToPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToPatientActionPerformed(evt);
            }
        });
        add(sendToPatient);
        sendToPatient.setBounds(630, 390, 220, 31);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Filter Status By:");
        add(jLabel2);
        jLabel2.setBounds(140, 440, 130, 22);

        jComboBoxFilter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFilterActionPerformed(evt);
            }
        });
        add(jComboBoxFilter);
        jComboBoxFilter.setBounds(270, 440, 86, 28);

        workRequestJTable.setBackground(new java.awt.Color(153, 255, 255));
        workRequestJTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        workRequestJTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Patient ID", "Patient Name", "Doctor Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setGridColor(new java.awt.Color(0, 0, 0));
        workRequestJTable.setSelectionBackground(new java.awt.Color(153, 255, 255));
        workRequestJTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(168, 122, 669, 245);

        assignToMe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        assignToMe.setText("Assign To Me");
        assignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToMeActionPerformed(evt);
            }
        });
        add(assignToMe);
        assignToMe.setBounds(160, 390, 170, 31);

        backJButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/arrow-back-icon_1_40x40.png"))); // NOI18N
        backJButton1.setContentAreaFilled(false);
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        add(backJButton1);
        backJButton1.setBounds(20, 40, 50, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/doctor.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(-290, -140, 1490, 920);
    }// </editor-fold>//GEN-END:initComponents

    private void sendToPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToPatientActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        //        if (!(Constants.sentToSupplier).equalsIgnoreCase(request.getStatus())) {
            //            if (!(Constants.ManagerApprove).equalsIgnoreCase(request.getStatus())) {
                //                JOptionPane.showMessageDialog(null, "Request Approved can only be send to Supplier");
                //                return;
                //            } else {
                if (request.getReceiver().equals(userAccount)) {
                    if ((Constants.ManagerApprove).equalsIgnoreCase(request.getStatus())) {
                        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                        userProcessContainer.add("ChooseSupplier", new AssignToSupplier(userProcessContainer, ecosystem, request, this.enterprise));
                        layout.next(userProcessContainer);
                        log.info("Request send to supplier");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid action.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Request not assign to you.");
                    return;
                }
    }//GEN-LAST:event_sendToPatientActionPerformed

    private void jComboBoxFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFilterActionPerformed
        // TODO add your handling code here:
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(((DefaultTableModel) workRequestJTable.getModel()));
        if (jComboBoxFilter.getSelectedItem() != null) {
            if (!jComboBoxFilter.getSelectedItem().toString().equalsIgnoreCase("All")) {
                sorter.setRowFilter(RowFilter.regexFilter(jComboBoxFilter.getSelectedItem().toString()));
                workRequestJTable.setRowSorter(sorter);
            } else {
                workRequestJTable.setRowSorter(null);
            }
        }
    }//GEN-LAST:event_jComboBoxFilterActionPerformed

    private void assignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToMeActionPerformed

        log.info("Request Assign to Doctor");
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDoctor wreqDoctor = (WorkRequestDoctor)workRequestJTable.getValueAt(selectedRow, 0);
        //WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        if (wreqDoctor.getReceiver() == null) {
            if ((Constants.patientSendForApproval).equals(wreqDoctor.getStatus())) {
                wreqDoctor.setReceiver(userAccount);
              //  populateRequestTable();
                populateDoctorTable();
            } else {
                JOptionPane.showMessageDialog(null, "Request is processed");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Already assinged to " + wreqDoctor.getReceiver());
            return;
        }
    }//GEN-LAST:event_assignToMeActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignToMe;
    private javax.swing.JButton backJButton1;
    private javax.swing.JComboBox jComboBoxFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sendToPatient;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables

     public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            WorkRequestDoctor workRequestDrugs = (WorkRequestDoctor) request;
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getStatus();
            row[2] = request.getSender();
            row[3] = request.getReceiver();
            model.addRow(row);
        }
    }

    private void populateDoctorTable() {
        
         DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        int count =0;
          System.out.println(organization.getWorkQueue().getWorkRequestList());
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            
            
            System.out.println(request +"Hello");
            WorkRequestDoctor workReqDoc = (WorkRequestDoctor) request;
            Object[] row = new Object[4];
            row[0] = workReqDoc;
            count++;
            row[1] = request.getSender();
            row[2] = request.getReceiver();
            row[3] = request.getStatus();
            model.addRow(row);
        }
        
    }
}
        
        
        
        
        
//        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
//
//        model.setRowCount(0);
//        List<UserAccount> orgPatient = new ArrayList<>();
//        int count = 0;
//        
//        
//        
//        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
//            //System.out.println(emp);
//            if (org instanceof PatientOrganization) {
//                orgPatient = org.getUserAccountDirectory().getUserAccountListValues();
//              System.out.println(orgPatient);
//            }
//            
//            for(UserAccount usr: orgPatient)
//            {
//                
//                
//                
//            Object[] row = new Object[4];
//            row[0] = count;
//            count++;
//            row[1] = usr.getSender();
//            row[2] = request.getSender();
//            row[3] = request.getReceiver();
//            model.addRow(row);
//                Object[] row = new Object[2];
//                row[0] = count;
//                count++;
//                row[1] = usr;
//
//                //    row[2] = request.getStatus();
//                model.addRow(row);
//            }
//
//        }
//    }