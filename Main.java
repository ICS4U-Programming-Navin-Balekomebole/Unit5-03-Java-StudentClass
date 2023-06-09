import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
* This file contains the main class.
*
* @author  Navin Balekomebole
* @version 1.0
* @since   2023-06-09
*/

public final class Main {
    /**
     * Private constructor to prevent
     * instantiation of the utility class.
     *
     * @throws IllegalStateException "Utility class".
     */
    private Main() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Entry point of the program.
     *
     * @param args The command-line arguments (unused).
     */
    public static void main(String[] args) {
        final ArrayList<Student> studentList = new ArrayList<>();
        boolean iep = false;
        int counter = 0;
        String outputString = "";

        try {
            // Read input from a file.
            final File inputFile = new File("input.txt");
            final Scanner scanInput = new Scanner(inputFile);

            // Prepare an output file.
            final FileWriter outputFile = new FileWriter("output.txt");

            // Process each line of the input file.
            while (scanInput.hasNextLine()) {
                final String[] currentStudentData =
                    scanInput.nextLine().split(" ");

                // Verify that iep is existent.
                if (currentStudentData
                    [currentStudentData.length - 1].equals("y")) {
                    iep = true;
                } else {
                    iep = false;
                }

                // Create student object based on
                // the number of information pieces
                // and add it to the list.
                if (currentStudentData.length == 4) {
                    final Student student = new Student(currentStudentData[0],
                            currentStudentData[1],
                            Integer.parseInt(currentStudentData[2]), iep);
                    studentList.add(student);
                    outputString += studentList.get(counter).print() + "\n";
                } else if (currentStudentData.length == 5) {
                    final Student student = new Student(currentStudentData[0],
                            currentStudentData[2],
                            currentStudentData[1].charAt(0),
                            Integer.parseInt(currentStudentData[3]), iep);
                    studentList.add(student);
                    outputString += studentList.get(counter).print() + "\n";
                } else {
                    // Incorrect input.
                    outputString += "Error." + "\n";
                }
                counter++;
            }

            // Output information,
            // including the number of students.
            final String numStudents = "There are "
                + studentList.size() + " students." + "\n";
            System.out.print(numStudents);
            System.out.println(outputString);
            outputFile.write(numStudents);
            outputFile.write(outputString);

            // Close the output
            // file writer.
            outputFile.close();
        } catch (IOException err) {
            // Handle exceptions
            // when the input file
            // is not found.
            System.err.println("Error: " + err.getMessage());
        }
    }
}
