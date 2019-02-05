import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataBaseHelper {
    public static void writeStudentToFile(Student student){
        try {
            FileOutputStream fs = new FileOutputStream("studentDB.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(student);
            os.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void readFromFile(){
        try {
            FileInputStream fs = new FileInputStream("studentDB.ser");
            ObjectInputStream is = new ObjectInputStream(fs);
            System.out.println(is);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
