package entity;

import javax.swing.*;

public class Worksheet {

    String worksheetId;

    public Worksheet() {
        this.worksheetId = JOptionPane.showInputDialog("Enter worksheet Id");
    }

    public String getWorksheetId() {
        return worksheetId;
    }
}
