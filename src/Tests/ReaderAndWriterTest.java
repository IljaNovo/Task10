import org.junit.Assert;
import org.junit.Test;

public class ReaderAndWriterTest {

    @Test
    public void testRead() throws Exception {
        ReaderAndWriter raw = new ReaderAndWriter();

        raw.openStreamReader("UTF8", "src\\in.txt");
        String answer = raw.read();

        Assert.assertEquals(answer, "Hello");
    }

    @Test
    public void testReadNonexistentFile() throws Exception {
        ReaderAndWriter raw = new ReaderAndWriter();
        String answer = "";

        try {
            raw.openStreamReader("UTF8", "C:\\Users\\Lenovo\\Desktop");
        }
        catch (Throwable e) {
            answer = raw.read();
            Assert.assertEquals(answer, "");
        }
    }
}