/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.manufacturer.producerrole;

import business.EcoSystem;
import business.drug.Drug;
import business.enterprise.Enterprise;
import business.enterprise.SupplierEnterprise;
import business.organization.Organization;
import business.organization.manufacturer.ProducerOrganization;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequest;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author NEERAJ PREMANI
 */
public class ProducerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ApproverWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private ProducerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem ecosystem;

    private static final Logger log = LogManager.getLogger(ProducerWorkAreaJPanel.class);

    public ProducerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ProducerOrganization organization,
            Enterprise enterprise, EcoSystem ecosystem) {
        initComponents();
        this.setSize(1680, 1050);
        ((DefaultTableCellRenderer) workRequestJTable.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.ecosystem = ecosystem;
        title.setText("Manufacturer: " + userAccount.getUsername());
        populateRequestTable();
        log.info("Producer Work Area JPanel Loaded");
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
            row[2] = request.getSender();
            row[3] = request.getReceiver();
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

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignToMe = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        processOrderjButton = new javax.swing.JButton();
        completeOrderjButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(183, 248, 230));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));
        kGradientPanel1.setLayout(null);

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
                "Request ID", "Status", "Sender", "Receiver"
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
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        kGradientPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(119, 149, 669, 245);

        assignToMe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        assignToMe.setText("Assign To Me");
        assignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignToMeActionPerformed(evt);
            }
        });
        kGradientPanel1.add(assignToMe);
        assignToMe.setBounds(119, 404, 150, 31);

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setText("Producer Workarea");
        title.setAlignmentX(740.0F);
        title.setAlignmentY(245.0F);
        kGradientPanel1.add(title);
        title.setBounds(130, 80, 553, 32);

        processOrderjButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        processOrderjButton.setText("Process Order");
        processOrderjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processOrderjButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(processOrderjButton);
        processOrderjButton.setBounds(390, 410, 150, 31);

        completeOrderjButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        completeOrderjButton.setText("Complete Order");
        completeOrderjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeOrderjButtonActionPerformed(evt);
            }
        });
        kGradientPanel1.add(completeOrderjButton);
        completeOrderjButton.setBounds(630, 410, 160, 31);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/patient.jpg"))); // NOI18N
        jLabel5.setText("jLabel1");
        kGradientPanel1.add(jLabel5);
        jLabel5.setBounds(-140, -30, 1360, 820);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignToMeActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            log.info("User didn't select a row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        if (request.getReceiver() == null) {
            request.setReceiver(userAccount);
            populateRequestTable();
            log.info("Request successfully assigned!");
        } else {
            JOptionPane.showMessageDialog(null, "Already assinged to " + request.getReceiver());
            log.info("Already assinged to " + request.getReceiver());
            return;
        }

    }//GEN-LAST:event_assignToMeActionPerformed

    private void processOrderjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processOrderjButtonActionPerformed
        //We will update the price in the drug list and return as a part of the request
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            log.info("Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        Organization org = null;
        //request.getEnterpriseStack().add(this.enterprise);
        if (request.getReceiver() == userAccount) {

//            JOptionPane.showMessageDialog(null, "Request processed and returned to Supplier: " + supplier.getUsername());
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("ViewAndUpdateBidProducer", new ViewAndUpdateBidProducerjpanel(userProcessContainer, request, ecosystem));
            layout.next(userProcessContainer);
            log.info("Moving to the Process Order Screen");
        } else {
            JOptionPane.showMessageDialog(null, "This request is not assigned to you.");
            log.info("This request is not assigned to the user.");
        }
    }//GEN-LAST:event_processOrderjButtonActionPerformed

    private void completeOrderjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeOrderjButtonActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select row");
            log.info("Please select row");
            return;
        }

        WorkRequestDrugs request = (WorkRequestDrugs) workRequestJTable.getValueAt(selectedRow, 0);
        if (request.getStatus().equalsIgnoreCase(Constants.priceUpdatedByManufacturer)) {
            request.setStatus(Constants.processedByManufacturer);
            UserAccount supplier = request.getSender();
            request.setSender(request.getReceiver());
            request.setReceiver(supplier);
            JOptionPane.showMessageDialog(null, "Order completed successfully");
            log.info("Order completed successfully");

            //Delete this order from all queues.
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof ProducerOrganization) {
                    //Remove the workrequest from this queue
                    organization.getWorkQueue().deleteWorkRequest(request);
                }
            }

            SupplierEnterprise supplierEnterprise = null;
            //Add drug to supplier inventory
            for (Enterprise enterprise : request.getEnterpriseStack()) {
                if (enterprise instanceof SupplierEnterprise) {
                    supplierEnterprise = (SupplierEnterprise) enterprise;
                }
            }

            for (Drug drug : request.getDrugsOrderList()) {
                //check if drug exists in the supplier inventory
                boolean foundDrugInInventory = false;
                for (Drug suppDrug : supplierEnterprise.getInventory().getDrugStock()) {

                    if (drug.getName().equalsIgnoreCase(suppDrug.getName())) {
                        foundDrugInInventory = true;
                        suppDrug.setQuantity(suppDrug.getQuantity() + drug.getRequestCountFromMan());
                        suppDrug.setManufacturerPrice(drug.getManufacturerPrice());
                    }
                }

                if (!foundDrugInInventory) {
                    //Drug not found in inventory. Add this drug to inventory
                    Drug newDrug = new Drug();
                    newDrug.setName(drug.getName());
                    newDrug.setQuantity(drug.getRequestCountFromMan());
                    supplierEnterprise.getInventory().getDrugStock().add(newDrug);
                }

            }

            populateRequestTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please process the order first before completing it");
            log.info("Please process the order first before completing it");
            return;
        }

    }//GEN-LAST:event_completeOrderjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignToMe;
    private javax.swing.JButton completeOrderjButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton processOrderjButton;
    private javax.swing.JLabel title;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
