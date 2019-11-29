package service;

import communication.Communication;
import org.apache.commons.io.FileUtils;
import userinterface.DialogBox;
import utils.FilesUtils;

import java.io.File;

public class WorksheetService {

    Communication communication;
    DialogBox dialogBox;

    public WorksheetService(Communication communication, DialogBox dialogBox) {
        this.communication = communication;
        this.dialogBox = dialogBox;
    }

    public String generateWorksheetHtmlFileWithWorksheetId() {
        String userInput = dialogBox.getWorksheetIdFromUser();
        Long worksheetId = Long.parseLong(userInput);

        String htmlContent = communication.getWorksheetHTMLString(worksheetId);
        String filePath = FilesUtils.writeStringToFile(htmlContent, String.format("worksheet_%s.html", userInput));
       return filePath;
    }
}
