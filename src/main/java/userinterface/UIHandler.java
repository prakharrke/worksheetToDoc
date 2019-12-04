package userinterface;

import service.WorksheetService;
import utils.ProcessUtils;

import javax.swing.*;
import java.io.IOException;

public class UIHandler {

    JFrame frame;
    JButton questionPaperWithoutHeader;
    JButton questionPaperWithHeader;
    JLabel worksheetIdLabel;
    JTextField worksheetIdTextField;
    WorksheetService worksheetService;

    public UIHandler(WorksheetService worksheetService) {
        this.worksheetService = worksheetService;
        frame = new JFrame("Worksheet To Doc Converter");
        addQuestionPaperWithHeaderButton();
        addQuestionPaperWithoutHeaderButton();
        addLabel();
        addTextField();

    }

    public void renderFrame() {
        frame.setSize(600, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addQuestionPaperWithHeaderButton() {
        questionPaperWithHeader = new JButton("With Answer Space");
        questionPaperWithHeader.setBounds(100, 100, 140, 40);

        questionPaperWithHeader.addActionListener(e -> {
                    try {
                        Long worksheetId = Long.parseLong(worksheetIdTextField.getText());
                        String filePath = worksheetService.generateWorksheetHtmlWithAnswerSpaceFileWithWorksheetId(worksheetId);
                        openHtmlToDocx(filePath);
                    } catch (Exception ex) {
                        showErrorDialogBox(ex.getMessage());
                    }
                }
        );

        frame.add(questionPaperWithHeader);
    }

    private void addQuestionPaperWithoutHeaderButton() {
        questionPaperWithoutHeader = new JButton("Without Answer Space");
        questionPaperWithoutHeader.setBounds(400, 100, 140, 40);

        questionPaperWithoutHeader.addActionListener(e -> {
                    try {
                        Long worksheetId = Long.parseLong(worksheetIdTextField.getText());
                        String filePath = worksheetService.generateWorksheetHtmlWithoutAnswerSpaceFileWithWorksheetId(worksheetId);
                        openHtmlToDocx(filePath);
                    } catch (Exception ex) {
                        showErrorDialogBox(ex.getMessage());
                    }
                }
        );
        frame.add(questionPaperWithoutHeader);
    }

    private void addLabel() {
        worksheetIdLabel = new JLabel("Enter Worksheet Id:");
        worksheetIdLabel.setBounds(100, 50, 200, 40);
        frame.add(worksheetIdLabel);
    }

    private void addTextField() {
        worksheetIdTextField = new JTextField();
        worksheetIdTextField.setBounds(300, 50, 200, 40);
        frame.add(worksheetIdTextField);
    }

    public void showErrorDialogBox(String message) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        JDialog dialog = optionPane.createDialog("Failure");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    private void openHtmlToDocx(String filePath) {
        try {
            ProcessUtils.openFieInWinWord(filePath);
        } catch (IOException e) {
            showErrorDialogBox(e.getMessage());
        }
    }

}
