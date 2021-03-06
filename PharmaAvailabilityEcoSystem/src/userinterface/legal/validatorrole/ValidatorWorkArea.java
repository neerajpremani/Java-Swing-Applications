/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.legal.validatorrole;

import business.drug.Drug;
import business.enterprise.ChemistEnterprise;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.organization.legal.ValidatorOrganization;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequest;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import java.awt.CardLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author JAINHEMANT
 */
public class ValidatorWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form ManagerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private ValidatorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private static final Logger log = LogManager.getLogger(ValidatorWorkArea.class);
    public static final String legalCheckApi = "http://localhost:3000/legalcheck/";

    public ValidatorWorkArea(JPanel userProcessContainer, UserAccount account, ValidatorOrganization organization, Enterprise enterprise) {
        initComponents();
        this.setSize(1200, 750);
        ((DefaultTableCellRenderer) workRequestJTable.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        title.setText("Validator: " + userAccount.getUsername());
        populateRequestTable();
    }

    public void populateRequestTable() {
        workRequestJTable.getTableHeader().setFont(new Font("Segoe UI", 1, 20));
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            WorkRequestDrugs workRequestDrugs = (WorkRequestDrugs) request;
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getStatus();
            row[2] = request.getReceiver();
            ChemistEnterprise chemistEnterprise = null;
            for (Enterprise enterprise : request.getEnterpriseStack()) {
                if (enterprise instanceof ChemistEnterprise) {
                    chemistEnterprise = (ChemistEnterprise) enterprise;
                }
            }
            row[3] = chemistEnterprise.getName();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        viewRequest = new javax.swing.JButton();
        reject = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        sendToSupplier = new javax.swing.JButton();
        approve = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(183, 248, 230));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                "Request ID", "Status", "Supplier", "Chemist"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 172, 669, 245));

        viewRequest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewRequest.setText("View");
        viewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewRequestActionPerformed(evt);
            }
        });
        kGradientPanel1.add(viewRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 427, 190, -1));

        reject.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        reject.setText("Reject");
        reject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectActionPerformed(evt);
            }
        });
        kGradientPanel1.add(reject, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 180, -1));

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Title");
        title.setAlignmentX(740.0F);
        title.setAlignmentY(245.0F);
        kGradientPanel1.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 554, -1));

        sendToSupplier.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendToSupplier.setText("Check Legal Status");
        sendToSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkStatus(evt);
            }
        });
        kGradientPanel1.add(sendToSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 462, 190, -1));

        approve.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        approve.setText("Approve");
        approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveActionPerformed(evt);
            }
        });
        kGradientPanel1.add(approve, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 180, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/legals.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-360, -160, 1660, 980));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("viewDrug", new Viewjpanel(userProcessContainer, request));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewRequestActionPerformed

    private void checkStatus(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkStatus
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        HttpURLConnection conn = null;
        try {
            String chemist = (String) workRequestJTable.getValueAt(selectedRow, 3);
            List<String> orderedDrugs = new ArrayList<>();
            for (Drug drug : request.getDrugsOrderList()) {
                orderedDrugs.add(drug.getName());
            }
            String legalCheckURL = legalCheckApi + chemist;
            URL url = new URL(legalCheckURL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                log.error("Failed : HTTP error code : "
                        + conn.getResponseCode());
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            JSONArray array = null;
            while ((output = br.readLine()) != null) {
                JSONParser parser = new JSONParser();
                Object JsonString = parser.parse(output);
                System.out.println(JsonString);
                array = (JSONArray) JsonString;
                break;
            }
            List<String> authorizedDrugs = new ArrayList<>();
            for (Object drug : array) {
                authorizedDrugs.add((String) drug);
            }
            boolean rightsToSellDrugs = true;
            String message = "Unauthorized to sell ";

            for (String drug : orderedDrugs) {
                if (!authorizedDrugs.contains(drug.toLowerCase())) {
                    rightsToSellDrugs = false;
                    message += drug + " ";
                }
            }
            if (rightsToSellDrugs) {
                JOptionPane.showMessageDialog(null, "Authorized to sell ordered drugs.");
                log.info("Authorized to sell ordered drugs.");
                return;
            } else {
                JOptionPane.showMessageDialog(null, message);
                log.info(message);
                return;
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Api connection failed.");
            log.error("Api connection failed.", e);
            return;
        } finally {
            conn.disconnect();
        }

    }//GEN-LAST:event_checkStatus

    private void rejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        request.setStatus(Constants.rejectedByLegal);
        JOptionPane.showMessageDialog(null, "Rejected");
        log.info("Rejected by legal");
        //Delete this order from all queues.
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof ValidatorOrganization) {
                //Remove the workrequest from this queue
                organization.getWorkQueue().deleteWorkRequest(request);
            }
        }
        organization.getWorkQueue().deleteWorkRequest(request);
        populateRequestTable();
    }//GEN-LAST:event_rejectActionPerformed

    private void approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        request.setStatus(Constants.acceptedByLegal);
        JOptionPane.showMessageDialog(null, "Approved");
        //Delete this order from all queues.
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof ValidatorOrganization) {
                //Remove the workrequest from this queue
                organization.getWorkQueue().deleteWorkRequest(request);
            }
        }
        log.info("Approved by legal");
        populateRequestTable();
    }//GEN-LAST:event_approveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approve;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton reject;
    private javax.swing.JButton sendToSupplier;
    private javax.swing.JLabel title;
    private javax.swing.JButton viewRequest;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
