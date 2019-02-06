import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBaseHelper {

    public static void writeStudentToFile(Student student){
        Student[] studentList = {};
        ArrayList<Student> students = DataBaseHelper.readFromFile();
        students.add(student);
        try (FileOutputStream fs = new FileOutputStream("studentDB.ser")){
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(studentList);
            os.writeObject(students);
            os.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> readFromFile() {
        ArrayList<Student> students = new ArrayList<Student>();
        try(FileInputStream fi = new FileInputStream("studentDB.ser")){
            ObjectInputStream os = new ObjectInputStream(fi);
            Student[] studentList = (Student[]) os.readObject();
            ArrayList<Student> studentArray = (ArrayList<Student>)os.readObject();
            for(Student s: studentArray){
                students.add(s);
            }
            os.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return students;
    }

    public static void checkForStudentNominee(Student student, Nomination nomination){
        ArrayList<Student> students = DataBaseHelper.readFromFile();
        Student matchingStudent =  new Student("Fake","Fake","Fake","Fake");
        for (Student s: DataBaseHelper.readFromFile()) {
            System.out.println(s.name);
            if (s.name.equalsIgnoreCase(student.name) && s.age.equalsIgnoreCase(student.age) && s.school.equalsIgnoreCase(student.school)) {
                System.out.println("Found Match");
                matchingStudent = s;
                matchingStudent.setNomination(nomination);
                students.remove(s);
//                database method here
            }
        }
//        if (matchingStudent.isNominationAvailable().equals("Unavailable")){
//            matchingStudent = student;
//            matchingStudent.setNomination(nomination);
//            DataBaseHelper.writeStudentToFile(matchingStudent);
//        }
    }

    public static void checkForStudentApplicant(Student student, Application application){
        ArrayList<Student> students = DataBaseHelper.readFromFile();
        Student matchingStudent = new Student("Fake","Fake","Fake","Fake");
        for (Student s: students) {
            if (s.name.equalsIgnoreCase(student.name) && s.age.equalsIgnoreCase(student.age) && s.school.equalsIgnoreCase(student.school)) {
                System.out.println("Found Match");
                matchingStudent = s;
                matchingStudent.setApplication(application);
                students.remove(s);
//                database method here
            }
        }
//        if (matchingStudent.isApplicationAvailable().equals("Unavailable")) {
//            matchingStudent = student;
//            matchingStudent.setApplication(application);
//            DataBaseHelper.writeStudentToFile(matchingStudent);
//        }
    }
}
