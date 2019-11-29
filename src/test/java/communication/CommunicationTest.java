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
        String response = communication.getWorksheetHTMLString(1178204l);
        Assert.assertTrue(response.contains("<style>"));
    }

}
