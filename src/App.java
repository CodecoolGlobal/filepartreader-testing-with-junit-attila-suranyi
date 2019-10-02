import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("static/textfile.txt", 1, 2);
        System.out.println(reader.readLines());
    }
}
