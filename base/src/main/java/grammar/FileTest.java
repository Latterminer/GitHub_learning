package grammar;

import java.io.File;
import java.util.ArrayList;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("C:\\Program Files\\Redis");
        if (file == null || !file.exists()){
            return;
        }

        Thread t = new Thread();

    }
}
