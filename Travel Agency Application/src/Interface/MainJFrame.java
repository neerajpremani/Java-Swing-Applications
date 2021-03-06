/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.AirlinerDirectory;
import Business.BookingDirectory;
import Business.CustomerDirectory;
import Business.FleetDirectory;
import Business.FlytSchedule;
import Business.FlytScheduleDirectory;
import Interface.AirlineManagers.AirWorkAreaJPanel;
import Interface.Customer.MngFlytSchJPanel;
import Interface.TravelAgency.TravelAgencyPanel;
import java.awt.CardLayout;

/**
 *
 * @author JAINHEMANT
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    
    private AirlinerDirectory airDir;
    private CustomerDirectory cusDir;
    private FleetDirectory fleeDir;
    private FlytScheduleDirectory fschDir;
    private FlytSchedule flsch;
    private BookingDirectory bookDir;
    
    
    public MainJFrame() {
        initComponents();
        airDir = new AirlinerDirectory();
        cusDir = new CustomerDirectory();
        fleeDir = new FleetDirectory();
        fschDir = new FlytScheduleDirectory();
        bookDir = new BookingDirectory();
        flsch = new FlytSchedule();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        leftPanel = new javax.swing.JPanel();
        trvlAgencyBtn = new javax.swing.JButton();
        mngAirlinerBtn = new javax.swing.JButton();
        cstrBtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        trvlAgencyBtn.setText("Travel Agency");
        trvlAgencyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trvlAgencyBtnActionPerformed(evt);
            }
        });

        mngAirlinerBtn.setText("Airline Manager");
        mngAirlinerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngAirlinerBtnActionPerformed(evt);
            }
        });

        cstrBtn.setText("Customer Booking");
        cstrBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cstrBtnActionPerformed(evt);
            }
        });

        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mngAirlinerBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(trvlAgencyBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cstrBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(exitbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(trvlAgencyBtn)
                .addGap(36, 36, 36)
                .addComponent(mngAirlinerBtn)
                .addGap(34, 34, 34)
                .addComponent(cstrBtn)
                .addGap(30, 30, 30)
                .addComponent(exitbtn)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(leftPanel);

        rightPanel.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(rightPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trvlAgencyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trvlAgencyBtnActionPerformed
        // TODO add your handling code here:
        TravelAgencyPanel taPanel = new TravelAgencyPanel(rightPanel,airDir,cusDir,fleeDir, bookDir);
        rightPanel.add("TravelAgencyPanel",taPanel);
        CardLayout layout = (CardLayout)rightPanel.getLayout();
        layout.next(rightPanel); 
    }//GEN-LAST:event_trvlAgencyBtnActionPerformed

    private void mngAirlinerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngAirlinerBtnActionPerformed
        // TODO add your handling code here:
        AirWorkAreaJPanel amPanel = new AirWorkAreaJPanel(rightPanel,airDir,fleeDir,fschDir);
        rightPanel.add("AirWorkAreaJPanel",amPanel);
        CardLayout layout = (CardLayout)rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_mngAirlinerBtnActionPerformed

    private void cstrBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cstrBtnActionPerformed
        // TODO add your handling code here:
        MngFlytSchJPanel mfsPanel = new MngFlytSchJPanel(rightPanel, cusDir, bookDir,fschDir, flsch);
        rightPanel.add("MngFlytSchJPanel",mfsPanel);
        CardLayout layout = (CardLayout)rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_cstrBtnActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cstrBtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton mngAirlinerBtn;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JButton trvlAgencyBtn;
    // End of variables declaration//GEN-END:variables
}
