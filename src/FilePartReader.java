import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;


    public FilePartReader() {
        this.fromLine = 2;
        this.toLine = 1;
        this.filePath = "static/textfile.txt";
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (fromLine > toLine || fromLine < 1) throw new IllegalArgumentException("problem here boss");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws IOException {
        //https://www.baeldung.com/java-buffered-reader
        FileReader reader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(reader);

        StringBuilder content = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {

            content.append(line);
            content.append(System.lineSeparator());
        }
        return content.toString();
    }

    public String readLines() throws IOException {
        String content = this.read();
        String lines[] = content.split("\\n");
        StringBuilder result = new StringBuilder();

        int lineNumber = 1;
        for (String line : lines) {

            if (lineNumber >= fromLine) {
                result.append(line);
                lineNumber++;
                if ((lineNumber) == toLine + 1) {
                    break;
                }
            }
        }
        return result.toString();
    }
}
