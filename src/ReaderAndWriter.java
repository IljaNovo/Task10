import java.io.*;

public class ReaderAndWriter {
    private InputStream input;
    private Reader reader;
    private OutputStream output;
    private Writer writer;

    public ReaderAndWriter() {}

    public void openStreamReader(String encoding, String pathReader) throws FileNotFoundException, IOException{
        try {
            this.input = new FileInputStream(pathReader);
            this.reader = new InputStreamReader(input, encoding);
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        catch (IOException e) {
            throw new IOException();
        }
    }

    public void closeStreamReader() {
        try {
            if (reader != null) {
                reader.close();
            }
            if (input != null) {
                input.close();
            }
        }
        catch (IOException e) {
            e.getMessage();
        }
    }

    public void openStreamWriter(String encoding, String pathWriter) throws FileNotFoundException, IOException{
        try {
            output = new FileOutputStream(pathWriter);
            writer = new OutputStreamWriter(output, encoding);
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        catch (IOException e) {
            throw new IOException();
        }
    }

    public void closeStreamWriter() {
        try {
            if (output != null) {
                output.close();
            }
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public String read() throws ReadDataException{
        if (reader == null) {
            throw new ReadDataException();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int readBuffer = 0;

        try {
            readBuffer = reader.read();

            while (readBuffer != -1) {
                baos.write(readBuffer);
                readBuffer = reader.read();
            }
        }
        catch (IOException e) {
            throw new ReadDataException();
        }
        return baos.toString();
    }

    public void write(String str) throws WriteDataException{
        if (writer == null) {
            throw new WriteDataException();
        }
        try {
            writer.write(str);
            writer.flush();
        }
        catch (IOException e) {
            throw new WriteDataException();
        }
    }
}
