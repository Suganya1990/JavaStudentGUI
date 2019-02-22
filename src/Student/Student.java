package Student;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Student implements Serializable
{
    private static final long serialVersionUID = 1L;
    private long stID;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses;


    //Constructor
    public Student(long ID, String fName, String lName, ArrayList<String> courses) {
        this.stID = ID;
        this.firstName = fName;
        this.lastName = lName;
        this.courses = courses;
    }

    public String toString(){  String courseString = "";

    for (String course : courses) {
        courseString += course + "\n";
    }

    return this.stID + "\n" + this.firstName + "\n" + this.lastName + "\n" + courseString;

    }

    //diplays the student id, first name, last name, and all courses
    public void display() {
        System.out.println("----------------------------------Student----------------------------------");
        System.out.println("\n");
        System.out.println("Student ID:    " + this.stID);
        System.out.println("First Name:    " + this.firstName);
        System.out.println("Last Name:     " + this.lastName);
        System.out.println("Courses:       " + courses.get(0));
        for (int i = 1; i < courses.size(); i++) {

            System.out.println("               " + courses.get(i));
        }
    }


    //a static function called by Student console to add a student.
    // Checks if input is valid(by calling isValid function) and creates and returns a student object

    public static Student addStudent()
    {
        String tempFName, tempLName;
        int flag = 0;
        String course;
        long tempStudentID;
        ArrayList<String> courseContainer = new ArrayList<String>();
        Scanner reader = new Scanner(System.in);
        Scanner string = new Scanner(System.in);

        do {
            System.out.print("Please Enter Student ID: ");
            tempStudentID = reader.nextLong();
        } while (isStudentIDValid(tempStudentID) == false);
        do {
            System.out.print("Please enter your first name: ");
            tempFName = string.nextLine();
        } while (isNameValid(tempFName) == false);
        do {
            System.out.print("Please enter Last name: ");
            tempLName = string.nextLine();
        } while (isNameValid(tempLName) == false) ;
            do {
                System.out.print("Enter your course (0 to Exit): ");
                course = string.nextLine();
                if (!course.equals("0")) {
                    courseContainer.add(course);
                }
            } while (!course.equals("0"));

            Student temp = new Student(tempStudentID, tempFName, tempLName, courseContainer);
            return temp;
    }


        public static boolean isStudentIDValid ( long ID)
        {
            String tempID = String.valueOf(ID);
            if (tempID.length() != 9) {
                System.out.println("Must be 9 digits long");
                return false;
            }
            if (ID < 0 && ID > 999999999) {

                System.out.println("Incorrect Student ID");
                return false;
            }
            return true;
        }

        public static boolean isNameValid (String name)
        {
            if (name.isEmpty() || name==null)
                {
                System.out.println("No Name Entered. Please enter a correct FIRST name!");
                return false;
            }

            else return true;
        }

    }

