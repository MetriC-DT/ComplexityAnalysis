package Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerReader extends Reader {

    @Override
    public void read() {
        try (Scanner s = new Scanner(new File(Reader.filename))) {
            while (s.hasNextLine()) {
                s.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readInt() {
        try (Scanner s = new Scanner(new File(Reader.filename))) {
            while (s.hasNextLine()) {
                try {
                    s.nextInt();
                } catch (NoSuchElementException ignore) {
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
