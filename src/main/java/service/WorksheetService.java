package service;

import communication.Communication;
import communication.WorksheetUrl;
import userinterface.DialogBox;
import utils.FilesUtils;

public class WorksheetService {

    Communication communication;
    DialogBox dialogBox;

    public WorksheetService(Communication communication, DialogBox dialogBox) {
        this.communication = communication;
        this.dialogBox = dialogBox;
    }

    public String generateWorksheetHtmlWithoutAnswerSpaceFileWithWorksheetId(Long worksheetId) {
        try {
            Communication.WorksheetResponse worksheetResponse = communication.getWorksheetHTMLString(worksheetId, WorksheetUrl.WITHOUT_ANSWER_SPACE_URL);
            String filePath = FilesUtils.writeStringToFile(worksheetResponse.getHtml(), String.format("%s_withoutAnswerSpace", worksheetResponse.getSkuName()));
            return filePath;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String generateWorksheetHtmlWithAnswerSpaceFileWithWorksheetId(Long worksheetId) {

        try {
            Communication.WorksheetResponse worksheetResponse =  communication.getWorksheetHTMLString(worksheetId, WorksheetUrl.WITH_ANSWER_SPACE_URL);
            String filePath = FilesUtils.writeStringToFile(worksheetResponse.getHtml(), String.format("%s_withAnswerSpace", worksheetResponse.getSkuName()));
            return filePath;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
