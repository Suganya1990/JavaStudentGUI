package Student;
import java.util.Scanner;
import java.util.ArrayList;

//this is the main console that interacts with user.

public class StudentConsole {

    //container to hold all students added by user
    private static ArrayList<Student> studentContainer = new ArrayList<Student>();




    public static void main (String[] args){


        WriteObject writeObject = new WriteObject();
        ReadObject readObject = new ReadObject();
        int flag = 1;
        Scanner reader = new Scanner(System.in);


        System.out.print("Would you like to add a student? (1 to add or 0 to exit): ");
        flag = reader.nextInt();
        do {
            studentContainer.add(Student.addStudent());
            System.out.print("Would you like to add a student? (0 to exit): ");
            flag = reader.nextInt();
        } while (flag != 0);


        writeObject.WriteObjectTofile(studentContainer);
        ArrayList<Student> temp = new ArrayList<Student>();
        temp = (ArrayList<Student>) readObject.ReadObjectFromFile();
        for(int i = 0; i < temp.size(); i++)
        {
            temp.get(i).display();
        }


    }
}
