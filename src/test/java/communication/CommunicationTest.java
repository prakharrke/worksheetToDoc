package communication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

public class CommunicationTest {
    Communication communication;

    @Before
    public  void setUp() {
        communication = new Communication();
    }
    @Test
    public void testWorksheetToHtml() throws IOException {
        Communication.WorksheetResponse worksheetResponse =  communication.getWorksheetHTMLString(1178204l, WorksheetUrl.WITH_ANSWER_SPACE_URL);
        Assert.assertTrue(worksheetResponse.getHtml().contains("<style>"));
    }

}
