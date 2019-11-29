package userinterface;

import javax.swing.*;

public class DialogBox {

    public String getWorksheetIdFromUser() {
        String input = JOptionPane.showInputDialog("Enter Input:");
        return input;
    }
}
