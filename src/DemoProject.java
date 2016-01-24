import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Map;

public class DemoProject {

    public static void main(String[] args) {


        ParserParams parParams = new ParserParams();
        Map<String, String> namesFiles = null;
        ReaderAndWriter raw = new ReaderAndWriter();

        try {
            namesFiles = parParams.parseWriteRead(args);
            raw.openStreamReader("UTF16", "src\\" + namesFiles.get("Read"));
            raw.openStreamWriter("cp1251", "src\\" + namesFiles.get("Write"));

            // Task 1 theme: IOStream, read and write //
                                                      //
            raw.write(raw.read());                    //
            raw.closeStreamReader();                  //
            raw.closeStreamWriter();                  //
                                                      //
            ////////////////////////////////////////////

            // Task 2 theme: IOStream, read English text ////////////////////////////
                                                                                   //
            ReaderAndWriter rawFirst = new ReaderAndWriter();                      //
            rawFirst.openStreamReader("UTF8", "src\\" + namesFiles.get("Read"));   //
                                                                                   //
            EnglishText et = new EnglishText(rawFirst.read());                     //
                                                                                   //
            Map<String, Integer> answer = et.frequency();                          //
            Collection<String> keys = answer.keySet();                             //
                                                                                   //
            for (String key : keys) {                                              //
                System.out.printf("%s - %d%n", key, answer.get(key));              //
            }                                                                      //
            rawFirst.closeStreamReader();                                          //
                                                                                   //
            /////////////////////////////////////////////////////////////////////////
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
    }
}
