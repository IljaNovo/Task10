import java.util.Map;

public class DemoProject {

    public static void main(String[] args) {
        ParserParams parParams = new ParserParams();
        Map<String, String> namesFiles;
        ReaderAndWriter raw = new ReaderAndWriter();

        try {
            namesFiles = parParams.parseWriteRead(args);
            raw.openStreamReader("UTF16", namesFiles.get("Read"));
            raw.openStreamWriter("cp1251", namesFiles.get("Write"));

            String temp = raw.read();


        }
        catch (ParseCommandLineException e) {
            e.getMessage();
        }

    }
}
