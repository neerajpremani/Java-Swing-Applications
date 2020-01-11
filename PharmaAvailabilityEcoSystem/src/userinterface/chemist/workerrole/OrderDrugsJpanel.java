/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.chemist.workerrole;

import business.drug.Drug;
import business.enterprise.ChemistEnterprise;
import business.enterprise.Enterprise;
import business.useraccount.UserAccount;
import business.workqueue.WorkRequest;
import business.workqueue.WorkRequestDrugs;
import commonutils.Constants;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author JAINHEMANT
 */
public class OrderDrugsJpanel extends javax.swing.JPanel {

    /**
     * Creates new form OrderDrugsJpanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private ChemistEnterprise enterprise;
    private static final Logger log = LogManager.getLogger(OrderDrugsJpanel.class);

    public OrderDrugsJpanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise) {
        initComponents();
        this.setSize(1200, 750);
        ((DefaultTableCellRenderer) drugquantity.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise = (ChemistEnterprise) enterprise;
        drugquantity.setSize(300, 64);
        drugquantity.getTableHeader().setFont(new Font("Segoe UI", 1, 20));
        
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
        drugquantity = new javax.swing.JTable();
        addRow = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonCheckInventory = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 750));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(183, 248, 230));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));
        kGradientPanel1.setLayout(null);

        drugquantity.setBackground(new java.awt.Color(153, 255, 255));
        drugquantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        drugquantity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        drugquantity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug", "Quantity"
            }
        ));
        drugquantity.setGridColor(new java.awt.Color(0, 0, 0));
        drugquantity.setSelectionBackground(new java.awt.Color(153, 255, 255));
        drugquantity.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(drugquantity);

        kGradientPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(242, 145, 519, 231);

        addRow.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addRow.setText("Add Row");
        addRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowActionPerformed(evt);
            }
        });
        kGradientPanel1.add(addRow);
        addRow.setBounds(650, 390, 130, 31);

        submit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        kGradientPanel1.add(submit);
        submit.setBounds(220, 390, 120, 31);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setAlignmentX(740.0F);
        jLabel1.setAlignmentY(245.0F);
        kGradientPanel1.add(jLabel1);
        jLabel1.setBounds(1017, 391, 0, 0);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Order Drugs");
        jLabel2.setAlignmentX(740.0F);
        jLabel2.setAlignmentY(245.0F);
        kGradientPanel1.add(jLabel2);
        jLabel2.setBounds(400, 70, 210, 48);

        jButtonCheckInventory.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCheckInventory.setText("Check Inventory");
        jButtonCheckInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckInventoryActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButtonCheckInventory);
        jButtonCheckInventory.setBounds(440, 390, 170, 31);

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/worker.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        kGradientPanel1.add(jLabel5);
        jLabel5.setBounds(-510, -10, 1710, 940);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        List<Drug> orderList = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();
        int nRow = model.getRowCount();
        try {
            for (int i = 0; i < nRow; i++) {
                if (!(model.getValueAt(i, 0).equals("") || model.getValueAt(i, 1).equals(""))) {
                    String drugName = String.valueOf(model.getValueAt(i, 0));
                    if (orderList.stream().noneMatch(d -> d.getName().equalsIgnoreCase(drugName))) {
                        Drug newDrug = new Drug();
                        newDrug.setName(String.valueOf(model.getValueAt(i, 0)));
                        int quantity = Integer.parseInt((String) model.getValueAt(i, 1));
                        if(quantity <= 0){
                        JOptionPane.showMessageDialog(null, "Quantiy should be greater than zero.");
                        return; 
                        }
                        newDrug.setQuantity(quantity);
                        orderList.add(newDrug);
                    } else {
                        JOptionPane.showMessageDialog(null, "Double entries of " + drugName + " is not allowed.");
                        return;
                    }
                } else {
                    if (!(model.getValueAt(i, 0).equals("") && model.getValueAt(i, 1).equals(""))) {
                        if (model.getValueAt(i, 0).equals("")) {
                            JOptionPane.showMessageDialog(null, "Enter drug name");
                            return;
                        } else {
                            JOptionPane.showMessageDialog(null, "Enter quantity of drug");
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter integer value in quantity field.");
            return;
        }
        if (!orderList.isEmpty()) {
            WorkRequestDrugs workRequestDrugs = (WorkRequestDrugs) userAccount.getWorkQueue().addWorkRequest(WorkRequest.workRequestType.Drugs);
            workRequestDrugs.setSender(userAccount);
            workRequestDrugs.setStatus(Constants.chemistCoworkerRequestCreated);
            workRequestDrugs.setDrugsOrderList(orderList);
            log.info("Order Created");
            userProcessContainer.remove(this);
            Component[] componentArray = userProcessContainer.getComponents();
            Component component = componentArray[componentArray.length - 1];
            WorkerWorkAreaJPanel workAreaJPanel = (WorkerWorkAreaJPanel) component;
            workAreaJPanel.populateRequestTable();
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(null, "Order list can't be empty.");
            return;
        }
    }//GEN-LAST:event_submitActionPerformed

    private void addRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowActionPerformed
        DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();
        model.addRow(new Object[]{"", ""});
    }//GEN-LAST:event_addRowActionPerformed

    private void jButtonCheckInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckInventoryActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("viewInventory", new ViewInventoryJpanel(userProcessContainer, enterprise.getInventory()));
        layout.next(userProcessContainer);
        log.info("Checking Inventory");
    }//GEN-LAST:event_jButtonCheckInventoryActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRow;
    private javax.swing.JButton backJButton1;
    private javax.swing.JTable drugquantity;
    private javax.swing.JButton jButtonCheckInventory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
