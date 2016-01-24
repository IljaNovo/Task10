import java.util.Map;

public class DemoProject {

    public static void main(String[] args) {
        ParserParams parParams = new ParserParams();
        Map<String, String> namesFiles;
        ReaderAndWriter raw = new ReaderAndWriter();

        raw.openStreamWriter("cp1251", "ou.txt");
        raw.openStreamReader("UTF16", "in.txt");

        try {
             namesFiles = parParams.parseWriteRead(args);
        }
        catch (ParseCommandLineException e) {
            e.getMessage();
        }

    }
}
