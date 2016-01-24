import java.io.*;

public class main {

    public static void main(String[] args) {


        InputStream input = null;
        Reader reader = null;
        OutputStream output = null;
        Writer writer = null;

        try {
            input = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Stream\\in.txt");
            reader = new InputStreamReader(input, "UTF16");

            output = new FileOutputStream("C:\\Users\\Lenovo\\Desktop\\Stream\\ou.txt");
            writer = new BufferedWriter(new OutputStreamWriter(output, "Cp1251"));

            int readBuffer = reader.read();

            while (readBuffer != -1) {
                System.out.println((char)readBuffer);
                writer.write((char)readBuffer);
                readBuffer = reader.read();
            }
            writer.flush();
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }
        catch (IOException e) {
            e.getMessage();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
                if (writer != null) {
                    writer.close();
                }
            }
            catch (IOException e) { }
        }
    }
}