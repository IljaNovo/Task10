import java.io.FileNotFoundException;
import java.util.Map;

public class DemoProject {

    public static void main(String[] args) {
        // Task 1 theme: IOStream, read and write

        ParserParams parParams = new ParserParams();
        Map<String, String> namesFiles = null;
        ReaderAndWriter raw = new ReaderAndWriter();

        try {
            namesFiles = parParams.parseWriteRead(args);
            raw.openStreamReader("UTF16", "src\\" + namesFiles.get("Read"));
            raw.openStreamWriter("cp1251", "src\\" + namesFiles.get("Write"));

            raw.write(raw.read());

            raw.closeStreamReader();
            raw.closeStreamWriter();
        }
        catch (ParseCommandLineException e) {
            e.getStackTrace();
        }
        catch (ReadDataException e) {
            e.getStackTrace();
        }
        catch (WriteDataException e) {
            e.getStackTrace();
        }
        catch (OpenFileException e) {
            e.getStackTrace();
        }
        catch (FileNotFoundException e) {
            e.getStackTrace();
        }

        // Task 2 theme: IOStream, read English text

        
    }
}
