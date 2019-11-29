package application;

import communication.Communication;
import entity.Worksheet;
import service.WorksheetService;
import userinterface.DialogBox;
import utils.ProcessUtils;

import java.io.IOException;

public class Application {

    DialogBox dialogBox;
    Communication communication;

    public Application() {
        this.dialogBox = new DialogBox();
        this.communication = new Communication();
    }

    public void run() throws IOException {
        WorksheetService worksheetService = new WorksheetService(communication, dialogBox);
        String filePath = worksheetService.generateWorksheetHtmlFileWithWorksheetId();

        ProcessUtils.openFieInWinWord(filePath);
    }
}
