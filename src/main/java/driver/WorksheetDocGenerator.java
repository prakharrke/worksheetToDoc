package driver;

import application.Application;
import entity.Worksheet;

import java.awt.event.*;
import java.io.IOException;

public class WorksheetDocGenerator extends WindowAdapter{

    public static void main(String[] args) throws IOException {
        Application application = new Application();
        application.run();
    }
}
