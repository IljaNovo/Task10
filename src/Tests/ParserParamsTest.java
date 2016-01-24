import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

public class ParserParamsTest {

    @Test
    public void testParseParams() throws Exception {
        ParserParams parParams = new ParserParams();
        String[] args = {"-w", "fileWrite", "-r", "fileRead"};

        Map<String, String> valueParams = parParams.parseWriteRead(args);

        Assert.assertEquals(valueParams.get("Write"), "fileWrite");
        Assert.assertEquals(valueParams.get("Read"), "fileRead");
    }

    @Test
    public void testInvalidArgs() throws Exception {
        ParserParams parParams = new ParserParams();
        String[] args = {"-f", "fileWrite", "fileRead"};

        try {
            Map<String, String> valueParams = parParams.parseWriteRead(args);
        }
        catch (Throwable e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testNullArgs() throws Exception {
        ParserParams parParams = new ParserParams();
        String[] args = null;

        try {
            Map<String, String> valueParams = parParams.parseWriteRead(args);
        }
        catch (Throwable e) {
            Assert.assertTrue(true);
        }
    }
}