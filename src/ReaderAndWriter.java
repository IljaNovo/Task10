import java.io.*;

public class ReaderAndWriter {
    InputStream input;
    Reader reader;
    OutputStream output;
    Writer writer;

    public ReaderAndWriter() {}

    public void openStreamReader(String encoding, String pathReader) {
        try {
            this.input = new FileInputStream(pathReader);
            this.reader = new InputStreamReader(input, encoding);
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }
        catch (IOException e) {
            e.getMessage();
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

    public void openStreamWriter(String encoding, String pathWriter) {
        try {
            output = new FileOutputStream(pathWriter);
            writer = new OutputStreamWriter(output, encoding);
        }
        catch (FileNotFoundException e) {
            e.getMessage();
        }
        catch (IOException e) {
            e.getMessage();
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

    public String read() {
        if (reader == null) {
            return "";
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
            e.getMessage();
        }
        return baos.toString();
    }

    public void write(String str) {
        if (writer == null) {
            throw new WriteDataException();
        }
        try {
            writer.write(str);
            writer.flush();
        }
        catch (IOException e) {
            e.getMessage();
        }
    }
}
