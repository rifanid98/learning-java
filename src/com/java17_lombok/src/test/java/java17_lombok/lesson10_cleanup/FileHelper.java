package java17_lombok.lesson10_cleanup;

import lombok.Cleanup;

import java.io.FileReader;
import java.util.Scanner;

public class FileHelper {

    public static String loadFile(String file) throws Exception {
        @Cleanup FileReader fileReader = new FileReader(file);
        @Cleanup Scanner scanner = new Scanner(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine()).append("\n");
        }

        return stringBuilder.toString();
    }
}
