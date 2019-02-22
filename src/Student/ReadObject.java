package Student;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class ReadObject {


    public Object ReadObjectFromFile() {

        try {

            FileInputStream fileIn = new FileInputStream(UserInterface.filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
