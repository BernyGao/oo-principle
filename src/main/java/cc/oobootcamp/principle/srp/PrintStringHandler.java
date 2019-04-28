package cc.oobootcamp.principle.srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

public class PrintStringHandler {

    private static final Logger LOGGER = Logger.getLogger(PrintStringHandler.class.getName());

    private String source;

    private String target;

    public PrintStringHandler(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public void print() {
        String content = "Source = " + source + "; Target = " + target;
        printToConsole(content);
        printToFile(content);
    }

    private void printToConsole(String result) {
        LOGGER.info(result);
    }

    private void printToFile(String result) {

        File file = new File("print");

        OutputStream out = null;

        try {

            out = new FileOutputStream(file);
            out.write(result.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
