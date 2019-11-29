package service;

import communication.Communication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import userinterface.DialogBox;

import java.io.File;
import java.io.IOException;

public class WorksheetServiceTest {

    WorksheetService worksheetService;

    @Before
    public void setUp() {
        worksheetService = new WorksheetService(new Communication(),new DialogBox());
    }

    @Test
    public void worksheetTohtmlFileTest () throws IOException {
        String filePath = worksheetService.generateWorksheetHtmlFileWithWorksheetId();
        File file = new File(filePath);
        Assert.assertTrue(file.exists());
        System.out.println(file.getAbsolutePath());
    }
}
