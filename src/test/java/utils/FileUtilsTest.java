package utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class FileUtilsTest {

    @Test
    public void testWriteToTempFile(){
        String filePath = FilesUtils.writeStringToFile("Test Content", "testFile.txt");
        File file = new File(filePath);
        Assert.assertTrue(file.exists());
    }
}
