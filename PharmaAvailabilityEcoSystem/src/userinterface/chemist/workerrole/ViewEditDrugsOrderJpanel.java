/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.chemist.workerrole;

import business.drug.Drug;
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
public class ViewEditDrugsOrderJpanel extends javax.swing.JPanel {

    /**
     * Creates new form OrderDrugsJpanel
     */
    private JPanel userProcessContainer;
    private WorkRequestDrugs workRequestDrugs;
    private static final Logger log = LogManager.getLogger(ViewEditDrugsOrderJpanel.class);

    public ViewEditDrugsOrderJpanel(JPanel userProcessContainer, WorkRequestDrugs workRequestDrugs, boolean orderPros) {
        initComponents();
        //drugquantity.setEnabled(false);
        //drugquantity.setOpaque(false);
        ((DefaultTableCellRenderer) drugquantity.getDefaultRenderer(Object.class)).setOpaque(false);
        //((DefaultTableCellRenderer) drugquantity.getDefaultRenderer(Object.class)).setBackground(Color.red);
        //headerRenderer
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        save.setEnabled(false);
        addRow.setEnabled(false);
        update.setEnabled(false);
        drugquantity.setEnabled(false);
        drugquantity.setSize(300, 64);
        this.userProcessContainer = userProcessContainer;
        this.workRequestDrugs = workRequestDrugs;
        if (workRequestDrugs.getStatus().equals(Constants.ManagerReject) || workRequestDrugs.getStatus().equals(Constants.chemistCoworkerRequestCreated)
                || workRequestDrugs.getStatus().equals(Constants.rejectedByLegal) || workRequestDrugs.getStatus().equals(Constants.orderCannotBeFullfilled)) {
            update.setEnabled(true);
        }
        drugquantity.setShowGrid(true);
        //drugquantity.getTableHeader().setOpaque(false);
        // drugquantity.getTableHeader().setBackground(Color.BLUE);
        //drugquantity.getTableHeader().setForeground(Color.BLACK);

        //JTableHeader tableHeader = drugquantity.getTableHeader();
        //tableHeader.setBackground(Color.red);
        this.setSize(1200, 750);
        this.userProcessContainer = userProcessContainer;
        this.workRequestDrugs = workRequestDrugs;
        if (orderPros == true) {
            update.setEnabled(false);
        }
        populateRequestTable();
    }

    public void populateRequestTable() {
        drugquantity.getTableHeader().setFont(new Font("Segoe UI", 1, 20));
        DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();

        model.setRowCount(0);
        for (Drug drug : workRequestDrugs.getDrugsOrderList()) {
            Object[] row = new Object[2];
            row[0] = drug;
            row[1] = Integer.toString(drug.getQuantity());
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        drugquantity = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        addRow = new javax.swing.JButton();
        save = new javax.swing.JButton();
        backJButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 750));

        kGradientPanel1.setkEndColor(new java.awt.Color(102, 204, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(183, 248, 230));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));
        kGradientPanel1.setLayout(null);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        jScrollPane1.setBounds(92, 171, 700, 230);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("View and Update Order Details");
        jLabel1.setAlignmentX(740.0F);
        jLabel1.setAlignmentY(245.0F);
        kGradientPanel1.add(jLabel1);
        jLabel1.setBounds(230, 90, 560, 48);

        update.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        kGradientPanel1.add(update);
        update.setBounds(70, 420, 130, 31);

        addRow.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addRow.setText("Add Row");
        addRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRowActionPerformed(evt);
            }
        });
        kGradientPanel1.add(addRow);
        addRow.setBounds(360, 420, 140, 31);

        save.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        kGradientPanel1.add(save);
        save.setBounds(710, 420, 120, 31);

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
        jLabel5.setBounds(-490, -40, 1710, 940);

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

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        drugquantity.setEnabled(true);
        addRow.setEnabled(true);
        save.setEnabled(true);
        update.setEnabled(false);
    }//GEN-LAST:event_updateActionPerformed

    private void addRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRowActionPerformed
        DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();
        model.addRow(new Object[]{"", ""});
    }//GEN-LAST:event_addRowActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        List<Drug> orderList = new ArrayList<>();
        try {
            DefaultTableModel model = (DefaultTableModel) drugquantity.getModel();
            int nRow = model.getRowCount();
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
            workRequestDrugs.setDrugsOrderList(orderList);
            drugquantity.setEnabled(false);
            addRow.setEnabled(false);
            save.setEnabled(false);
            update.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Order list updated.");
            log.info("Order Updated");
        } else {
            JOptionPane.showMessageDialog(null, "Order list can't be empty.");
            return;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRow;
    private javax.swing.JButton backJButton1;
    private javax.swing.JTable drugquantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
