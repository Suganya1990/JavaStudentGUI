package Student;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteObject{


    public void WriteObjectTofile(ArrayList<Student> student)
    {
        try{
            FileOutputStream fileout = new FileOutputStream(UserInterface.filepath);

            ObjectOutputStream objectOut = new ObjectOutputStream(fileout);
            objectOut.writeObject(student);
            objectOut.close();
            System.out.println("The Object was succesfully written to a file");

        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
