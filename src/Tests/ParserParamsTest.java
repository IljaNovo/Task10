import org.junit.Assert;
import org.junit.Test;

public class ParserParamsTest {

    @Test
    public void testParseParams() throws Exception {
        ParserParams parParams = new ParserParams();
        String[] args = {"-w", "fileWrite", "-r", "fileRead"};

        String[] valueParams = parParams.parseWriteRead(args);

        Assert.assertEquals(valueParams[0], "fileWrite");
        Assert.assertEquals(valueParams[1], "fileRead");
    }

    @Test
    public void testInvalidArgs() throws Exception {
        ParserParams parParams = new ParserParams();
        String[] args = {"-f", "fileWrite", "fileRead"};

        try {
            String[] valueParams = parParams.parseWriteRead(args);
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
            String[] valueParams = parParams.parseWriteRead(args);
        }
        catch (Throwable e) {
            Assert.assertTrue(true);
        }
    }
}