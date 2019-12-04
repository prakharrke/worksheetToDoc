package utils;

import command.Commands;

import java.io.IOException;

public class ProcessUtils {

    public static void openFileInEditorMac(String filePath) throws IOException {
        Process p = Runtime.getRuntime().exec(Commands.OPEN_FILE_IN_MAC.displayName() + " " + filePath);
    }

    public static void openFieInWinWord(String filePath) throws IOException {
        System.out.println("Command executing - " + Commands.OPEN_FILE_IN_WINWORD.displayName() + " " + filePath);
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(Commands.OPEN_FILE_IN_WINWORD.displayName() + " " + filePath);
            p.waitFor();
            if (p.exitValue() != 0) {
                p.destroy();
                throw new RuntimeException("Failed to run command" + Commands.OPEN_FILE_IN_WINWORD.displayName());
            }

        } catch (Exception e) {
            if (p != null) {
                p.destroy();
            }
            throw new RuntimeException(e.getMessage());
        }
    }
}
