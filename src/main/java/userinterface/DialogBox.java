package userinterface;

import javax.swing.*;

public class DialogBox {

    public String getWorksheetIdFromUser() {
        String input = JOptionPane.showInputDialog("Enter Worksheet Id:");
        return input;

    }

    public void showErrorDialogBox(String message) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = optionPane.createDialog("Failure");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
}
