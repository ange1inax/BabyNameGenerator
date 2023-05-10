import java.io.*;
import java.util.*;

public class BabyNames {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java BabyNames <filename.csv> <gender>");
            return;
        }

        String fileName = args[0];
        String gender = args[1].toUpperCase();

        if (!fileName.endsWith(".csv")) {
            throw new IncompatibleExtensionException("Only CSV files are accepted.");
        }

        List<String> names = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitLine = line.split(",");

                if (splitLine[1].equals(gender)) {
                    names.add(splitLine[0]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return;
        }

        if (names.size() < 3) {
            System.out.println("Not enough names in file for gender " + gender);
            return;
        }

        Collections.shuffle(names);

        try (PrintWriter writer = new PrintWriter(new File("potential_names.txt"))) {
            for (int i = 0; i < 3; i++) {
                writer.println(names.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

class IncompatibleExtensionException extends RuntimeException {
    public IncompatibleExtensionException(String message) {
        super(message);
    }
}
