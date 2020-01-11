/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.hospital.patientrole;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.enterprise.HospitalEnterprise;
import business.organization.Organization;
import business.organization.hospital.DoctorOrganization;
import business.organization.hospital.PatientOrganization;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequest;
import business.workqueue.WorkRequestDoctor;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import userinterface.chemist.workerrole.ViewEditDrugsOrderJpanel;
import userinterface.chemist.workerrole.WorkerWorkAreaJPanel;

/**
 *
 * @author JAINHEMANT
 */
public class ViewHistoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewHistoryJPanel
     */
    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem ecosystem;
    private static final Logger log = LogManager.getLogger(WorkerWorkAreaJPanel.class);

    public ViewHistoryJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise) {

        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.organization = (PatientOrganization) organization;
        this.enterprise = (HospitalEnterprise) enterprise;
        this.userAccount = userAccount;
        populateRequestTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        viewpresJButton = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        workRequestJTable.setBackground(new java.awt.Color(153, 255, 255));
        workRequestJTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        workRequestJTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Request ID", "Doctor Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jScrollPane1.setBounds(206, 98, 669, 245);

        viewpresJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewpresJButton.setText("View Prescription");
        viewpresJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewpresJButtonActionPerformed(evt);
            }
        });
        add(viewpresJButton);
        viewpresJButton.setBounds(360, 380, 270, 31);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/patient.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(2, 0, 1080, 710);
    }// </editor-fold>//GEN-END:initComponents

    private void viewpresJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewpresJButtonActionPerformed
        log.info("View Order");
        int selectedRow = workRequestJTable.getSelectedRow();
        boolean orderProc = false;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }
        WorkRequestDoctor request = (WorkRequestDoctor) workRequestJTable.getValueAt(selectedRow, 0);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("viewEditPatientDrug", new ViewEditDrugsPatientsOrderJpanel(userProcessContainer, request, orderProc));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewpresJButtonActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    public void populateRequestTable() {

        workRequestJTable.getTableHeader().setFont(new Font("Segoe UI", 1, 20));
        Organization org = null;
        for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization1 instanceof DoctorOrganization) {
                org = organization1;
                break;
            }
        }
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : org.getWorkQueue().getWorkRequestList()) {
            WorkRequestDoctor workRequestDrugs = (WorkRequestDoctor) request;
            if (workRequestDrugs.getSender() == userAccount) {

                Object[] row = new Object[3];
                row[0] = request;
                row[1] = request.getReceiver();
                row[2] = request.getStatus();
                model.addRow(row);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton viewpresJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
