import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testIsFromLineNotNull() {
        FilePartReader reader = new FilePartReader();
        assertNotNull(reader.getFromLine());
    }

    @Test
    public void testIsToLineNotNull() {
        FilePartReader reader = new FilePartReader();
        assertNotNull(reader.getToLine());
    }

    @Test
    public void testWrongFromLineAndToLineThrowsException() {
        FilePartReader reader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, ()-> {reader.setup("static/textfile.txt", 2, 1);}
        );
    }

    @Test
    public void testIsFileContentNotNull() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("static/textfile.txt", 1, 2);
        assertNotNull(reader.readLines());
    }

    @Test
    public void testAreLinesFromTheCorrectRange() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("static/textfile.txt", 1, 2);
        assertEquals("first line,second line,", reader.readLines());
    }

}