package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FilesUtils {

    public static String writeStringToFile(String content, String fileName) {
        fileName = escapeFileName(fileName);
        File tempDir = com.google.common.io.Files.createTempDir();
        try {
            String filePath = String.format("%s/%s", tempDir.getPath(), fileName);
            File targetFile = new File(filePath);
            writeToFile(targetFile, content);
            return filePath;
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
            finally {
            tempDir.delete();
        }
    }

    public static String escapeFileName(String fileName) {
        return fileName.replaceAll("[<>\"/:?* _]", "_");
    }

    private static void writeToFile(File file, String content) throws IOException {
        org.apache.commons.io.FileUtils.writeStringToFile(file, content);
    }
}
