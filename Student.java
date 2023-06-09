/**
* This file contains the student class.
*
* @author  Navin Balekomebole
* @version 1.0
* @since   2023-06-09
*/
public class Student {
    // In this section of the code,
    // Variables are used
    // for this class.
    private String firstName;
    private String lastName;
    private char midInitial;
    private int grade;
    private boolean iep;
    private String info;

    /**
    * Constructor is used here
    * to set initial values.
    *
    * @param firstName from user.
    * @param lastName from user.
    * @param midInitial from user.
    * @param grade from user.
    * @param iep from user.
    */
    public Student(String firstName, String lastName, char midInitial,
        int grade, boolean iep) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.midInitial = midInitial;
        this.grade = grade;
        this.iep = iep;
    }

    /**
    * Constructor used here
    * to set initial values.
    *
    * @param firstName from user.
    * @param lastName from user.
    * @param grade from user.
    * @param iep from user.
    */
    public Student(String firstName, String lastName, int grade, boolean iep) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.iep = iep;
        this.midInitial = ' ';
    }

    /**
    * Print all information.
    *
    * @return String of information.
    */
    public String print() {
        // The string
        // checks whether there is
        // a middle initial.
        if (this.midInitial == ' ') {
            this.info = this.firstName + " " + this.lastName
                + " and is in this grade: " + this.grade;
        } else {
            this.info = this.firstName + " " + this.midInitial + ". "
                + this.lastName + " and is in this grade: " + this.grade;
        }

        // In this section of the code,
        // it will Verify
        // that iep is true.
        if (this.iep) {
            this.info = this.info + " and has an iep.";
        } else {
            this.info = this.info + " and does not have an iep.";
        }
        return this.info;
    }
}
