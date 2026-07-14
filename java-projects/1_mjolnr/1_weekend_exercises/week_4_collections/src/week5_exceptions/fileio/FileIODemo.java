package week5_exceptions.fileio;

// Exercise: In main:
// - Write 3 student names (one per line) to a file called students.txt
// - Close the writer
// - Read the file back line by line and print each line
// - Wrap everything in try/catch for IOException

import java.io.File;         // represents a file/directory path on disk (used here to create the output folder)
import java.io.FileWriter;   // writes character data to a file
import java.io.BufferedReader; // reads text efficiently, line by line
import java.io.FileReader;   // reads character data from a file, feeds into BufferedReader
import java.io.IOException;  // checked exception thrown by file read/write operations

public class FileIODemo {
    public static void main(String[] args) {
        // Make sure the target folder exists before writing into it.
        // mkdirs() creates any missing parent directories too, and is a no-op if it already exists.
        File outputFolder = new File("src/week5_exceptions/fileio/output");
        outputFolder.mkdirs();

        String filePath = "src/week5_exceptions/fileio/output/students.txt";

        // File I/O can fail (missing permissions, disk issues, etc.), so both
        // the write and read steps are wrapped in one try/catch for IOException.
        try {
            // FileWriter(filePath) creates the file if it doesn't exist, or
            // overwrites it if it does (since append is not set to true).
            FileWriter writer = new FileWriter(filePath);

            // Write one student name per line ("\n" starts a new line).
            writer.write("Alice\n");
            writer.write("Bob\n");
            writer.write("Charlie\n");
            // Closing flushes any buffered data to disk and releases the file handle.
            writer.close();

            // BufferedReader wraps FileReader to read the file efficiently,
            // one line at a time via readLine().
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            // readLine() returns null once the end of the file is reached.
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the file.");
            e.printStackTrace(); // shows the exact error while learning
        }
    }
}

//O/P
//        Alice
//        Bob
//        Charlie
