/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.chemist.managerrole;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.enterprise.SupplierEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.supplier.ApproverOrganization;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author jaysh
 */
public class AssignToSupplier extends javax.swing.JPanel {

    /**
     * Creates new form AssignToSupplier
     */
    private JPanel userProcessContainer;
    private EcoSystem ecosystem;
    private WorkRequestDrugs request;
    private Enterprise enterprise;
    private static final Logger log = LogManager.getLogger(AssignToSupplier.class);

    public AssignToSupplier(JPanel userProcessContainer, EcoSystem ecosystem, WorkRequestDrugs request, Enterprise enterprise) {
        initComponents();
        networkDropdown.removeAllItems();
        enterpriseDropdown.removeAllItems();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.request = request;
        this.enterprise = enterprise;
        List<Network> networkList = ecosystem.getNetworkDirectory().getNetworkList();
        networkList.stream().forEach(network -> networkDropdown.addItem(network.getName()));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        networkDropdown = new javax.swing.JComboBox<>();
        enterpriseDropdown = new javax.swing.JComboBox<>();
        backJButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 750));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(183, 248, 230));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));
        kGradientPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("     Choose Supplier");
        jLabel1.setAlignmentX(740.0F);
        jLabel1.setAlignmentY(245.0F);
        kGradientPanel1.add(jLabel1);
        jLabel1.setBounds(200, 110, 490, 48);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel2.setText("Enterprise:");
        jLabel2.setAlignmentX(740.0F);
        jLabel2.setAlignmentY(245.0F);
        kGradientPanel1.add(jLabel2);
        jLabel2.setBounds(321, 237, 120, 30);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel3.setText("Network:");
        jLabel3.setAlignmentX(740.0F);
        jLabel3.setAlignmentY(245.0F);
        kGradientPanel1.add(jLabel3);
        jLabel3.setBounds(322, 196, 100, 30);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton1);
        jButton1.setBounds(450, 290, 120, 33);

        networkDropdown.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        networkDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkDropdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                networkDropdownItemStateChanged(evt);
            }
        });
        networkDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkDropdownActionPerformed(evt);
            }
        });
        kGradientPanel1.add(networkDropdown);
        networkDropdown.setBounds(459, 196, 161, 28);

        enterpriseDropdown.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enterpriseDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseDropdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                enterpriseDropdownItemStateChanged(evt);
            }
        });
        enterpriseDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseDropdownActionPerformed(evt);
            }
        });
        kGradientPanel1.add(enterpriseDropdown);
        enterpriseDropdown.setBounds(459, 237, 161, 28);

        backJButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        backJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/arrow-back-icon_1_40x40.png"))); // NOI18N
        backJButton1.setContentAreaFilled(false);
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(backJButton1);
        backJButton1.setBounds(20, 40, 50, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/chem.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        kGradientPanel1.add(jLabel5);
        jLabel5.setBounds(-400, -90, 1710, 1100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        List<Network> networkList = ecosystem.getNetworkDirectory().getNetworkList();
        String networkName = networkDropdown.getSelectedItem().toString();
        Network networkSelected = networkList.stream()
                .filter(network -> networkName.equals(network.getName()))
                .findAny()
                .orElse(null);
        if (networkDropdown.getSelectedItem() != null && enterpriseDropdown.getSelectedItem() != null) {
            String enterpriseName = enterpriseDropdown.getSelectedItem().toString();
            List<Enterprise> enterpriseList = networkSelected.getEnterpriseDirectory().getEnterpriseList().stream().
                    filter(enterprise -> enterprise instanceof SupplierEnterprise).collect(Collectors.toList());
            Enterprise enterpriseSelected = enterpriseList.stream()
                    .filter(enterprise -> enterpriseName.equals(enterprise.getName()))
                    .findAny()
                    .orElse(null);
            Organization org = null;
            boolean isWorkRequestAssigned = false;
            for (Organization organization : enterpriseSelected.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof ApproverOrganization) {
                    org = organization;
                    isWorkRequestAssigned = true;
                    org.getWorkQueue().getWorkRequestList().add(request);
                }
            }
            if (isWorkRequestAssigned) {
                request.setStatus(Constants.sentToSupplier);
                request.setSender(request.getReceiver());
                request.setReceiver(null);
                request.getEnterpriseStack().push(this.enterprise);
                JOptionPane.showMessageDialog(null, "Request send to supplier");
//                userProcessContainer.remove(this);
//                Component[] componentArray = userProcessContainer.getComponents();
//                Component component = componentArray[componentArray.length - 1];
//                RequestSupplierOrSendChemistWorker reqSuppChem = (RequestSupplierOrSendChemistWorker) component;
//                reqSuppChem.populateRequestTable();
//                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//                layout.previous(userProcessContainer);
                log.info("Request Send to supplier");
            } else {
                JOptionPane.showMessageDialog(null, "No Supplier organizations exists in the selected Enterprise. Request assingment failed");
                log.info("No Supplier organizations exists in the selected Enterprise. Request assingment failed");
                return;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Request cannot be fulfilled");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void networkDropdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_networkDropdownItemStateChanged
        // TODO add your handling code here:
        Network networkSelected = null;
        enterpriseDropdown.removeAllItems();
        if (ecosystem != null) {
            List<Network> networkList = ecosystem.getNetworkDirectory().getNetworkList();
            String networkName = networkDropdown.getSelectedItem().toString();
            networkSelected = networkList.stream()
                    .filter(network -> networkName.equals(network.getName()))
                    .findAny()
                    .orElse(null);
        }
        List<Enterprise> enterpriseList = null;
        if (networkSelected != null) {
            enterpriseList = networkSelected.getEnterpriseDirectory().getEnterpriseList().stream().
                    filter(enterprise -> enterprise instanceof SupplierEnterprise).collect(Collectors.toList());
        }
        if (enterpriseList != null) {
            enterpriseList.stream().forEach(enterprise -> enterpriseDropdown.addItem(enterprise.getName()));
        }
    }//GEN-LAST:event_networkDropdownItemStateChanged

    private void networkDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_networkDropdownActionPerformed

    private void enterpriseDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseDropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseDropdownActionPerformed

    private void enterpriseDropdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_enterpriseDropdownItemStateChanged

    }//GEN-LAST:event_enterpriseDropdownItemStateChanged

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JComboBox<String> enterpriseDropdown;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JComboBox<String> networkDropdown;
    // End of variables declaration//GEN-END:variables

}
