package Reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader extends Reader {

    @Override
    public void read() {
        java.io.BufferedReader b = null;
        try {
            b = new java.io.BufferedReader(new FileReader(Reader.filename));
            while (b.readLine() != null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (b != null)
                    b.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void readInt() {
        java.io.BufferedReader b = null;
        try {
            b = new java.io.BufferedReader(new FileReader(Reader.filename));
            String line = "";
            int i;
            while ((line = b.readLine()) != null) {
                i = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (b != null)
                    b.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
