/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jaysh
 */
public class CloseListener implements ActionListener {

//    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
//    private EcoSystem system;
    @Override
    public void actionPerformed(ActionEvent e) {

        int selectionButton = JOptionPane.YES_NO_OPTION;
        int selectionResult = JOptionPane.showConfirmDialog(null, "Do you want to exit? You will loose all session data.", "Warning", selectionButton);

        if (selectionResult == JOptionPane.YES_OPTION) {
            //Saving to file and then exiting
            //system = EcoSystem.getInstance();
            // dB4OUtil.storeSystem(system);
            System.exit(0);
        }

    }
}
