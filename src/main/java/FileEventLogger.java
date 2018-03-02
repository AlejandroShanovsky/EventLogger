import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    private void init() throws IOException {
        this.file = new File(fileName);
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.getMassage(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
