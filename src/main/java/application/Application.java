package application;

import communication.Communication;
import entity.Worksheet;
import service.WorksheetService;
import userinterface.DialogBox;
import userinterface.UIHandler;
import utils.ProcessUtils;

import java.io.IOException;

public class Application {

    DialogBox dialogBox;
    Communication communication;
    UIHandler uiHandler;

    public Application() {
        this.dialogBox = new DialogBox();
        this.communication = new Communication();

    }

    public void run() throws IOException {
        try {
            WorksheetService worksheetService = new WorksheetService(communication, dialogBox);
            uiHandler = new UIHandler(worksheetService);
            uiHandler.renderFrame();
        }catch (Exception e) {
            e.printStackTrace();
            dialogBox.showErrorDialogBox(e.getMessage());
            System.exit(1);
        }
    }
}
