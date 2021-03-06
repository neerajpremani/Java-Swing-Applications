/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.AirlineManagers;

import Business.Airliner;
import Business.Fleet;
import Business.FlytSchedule;
import Business.FlytScheduleDirectory;
import java.awt.CardLayout;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAINHEMANT
 */
public class FlytSchJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FlytSchJPanel
     */
    private JPanel rightPanel;
    private Airliner airliner;
    private Fleet fleet;
    private FlytScheduleDirectory fschDir;
    public FlytSchJPanel(JPanel rightPanel,Airliner airliner, Fleet fleet, FlytScheduleDirectory fschDir) {
        initComponents();
        this.rightPanel = rightPanel; 
        this.airliner = airliner;
        this.fleet = fleet;
        this.fschDir = fschDir;
        populate();
    }
   public void populate(){
        DefaultTableModel dtm = (DefaultTableModel)tblDirectory.getModel();
        dtm.setRowCount(0);
        Collections.sort(fschDir.getFlytscheduleDirectory());
        for(FlytSchedule a : fschDir.getFlytscheduleDirectory()){
            if(airliner.getAirlinerName().equalsIgnoreCase(a.getFlytAirline()))
            {
            Object[] row = new Object[dtm.getColumnCount()];
            row[0]=a;
            row[1]=a.getFlytAirline();
            row[2]=a.getFlytFleet();
            row[3]=a.getFlytFrom();
            row[4]=a.getFlytTo();
            row[5]=a.getFlytAvlSeats();
            row[6]=a.getFlytDate();
            row[7]=a.getFlytTime();
            row[8]=a.getFlyPrice();
            dtm.addRow(row);
            }
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDirectory = new javax.swing.JTable();
        newSchbtn = new javax.swing.JButton();
        viewSchBtn = new javax.swing.JButton();
        dropSchBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Flight Schedule");

        tblDirectory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight No.", "Airliner", "Fleet", "From", "To", "Available Seats", "Flight Date", "Flight Time", "Flight Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDirectory);

        newSchbtn.setText("New Schedule");
        newSchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSchbtnActionPerformed(evt);
            }
        });

        viewSchBtn.setText("View Schedule");
        viewSchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSchBtnActionPerformed(evt);
            }
        });

        dropSchBtn.setText("Drop Schedule");
        dropSchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropSchBtnActionPerformed(evt);
            }
        });

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dropSchBtn, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(473, 473, 473)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newSchbtn)
                            .addComponent(viewSchBtn)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropSchBtn)
                    .addComponent(newSchbtn))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(viewSchBtn))
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newSchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSchbtnActionPerformed
        // TODO add your handling code here:
        NewSchJPanel nsPanel = new NewSchJPanel(rightPanel, airliner, fleet,fschDir);
        rightPanel.add("NewSchJPanel",nsPanel);
        CardLayout layout = (CardLayout)rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_newSchbtnActionPerformed

    private void viewSchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSchBtnActionPerformed
        // TODO add your handling code here:

        int selectRow = tblDirectory.getSelectedRow();
        if(selectRow<0){
            JOptionPane.showMessageDialog(null,"Please select a row");
        }
        else{
            FlytSchedule fsch = (FlytSchedule) tblDirectory.getValueAt(selectRow, 0);
            ViewSchJPanel vsPanel = new ViewSchJPanel(rightPanel, fsch ,fschDir);
            rightPanel.add("ViewSchJPanel",vsPanel);
            CardLayout layout = (CardLayout)rightPanel.getLayout();
            layout.next(rightPanel);
        }
    }//GEN-LAST:event_viewSchBtnActionPerformed

    private void dropSchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropSchBtnActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblDirectory.getSelectedRow();
        if(selectedRow>=0){
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete??","Warning",selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                FlytSchedule fsch = (FlytSchedule)tblDirectory.getValueAt(selectedRow, 0);
                fschDir.deleteFlytSchedule(fsch);
                populate();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_dropSchBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        rightPanel.remove(this);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.previous(rightPanel);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton dropSchBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newSchbtn;
    private javax.swing.JTable tblDirectory;
    private javax.swing.JButton viewSchBtn;
    // End of variables declaration//GEN-END:variables
}
