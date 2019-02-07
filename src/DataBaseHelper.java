import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

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
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return students;
    }

    public static void checkForStudentNominee(Student student, Nomination nomination){
        ArrayList<Student> students = DataBaseHelper.readFromFile();
        Student matchingStudent =  student;
        Iterator<Student> iter = students.iterator();
        while (iter.hasNext()){
            Student s = iter.next();

            if (s.name.equalsIgnoreCase(student.name) && s.school.equalsIgnoreCase(student.school)){
                System.out.println("Found Match");
                matchingStudent = s;
                iter.remove();
                DataBaseHelper.rewriteFile(students);
            }
        }
            matchingStudent.setNomination(nomination);
            DataBaseHelper.writeStudentToFile(matchingStudent);
    }

    public static void checkForStudentApplicant(Student student, Application application){
        ArrayList<Student> students = DataBaseHelper.readFromFile();
        Student matchingStudent = student;
        Iterator<Student> iter = students.iterator();
        while (iter.hasNext()){
            Student s = iter.next();

            if (s.name.equalsIgnoreCase(student.name) && s.school.equalsIgnoreCase(student.school)){
                System.out.println("Found Match");
                matchingStudent = s;
                iter.remove();
                DataBaseHelper.rewriteFile(students);
            }
        }
        matchingStudent.setApplication(application);
        DataBaseHelper.writeStudentToFile(matchingStudent);
    }

    public static void rewriteFile(ArrayList<Student> students){
        Student[] studentList = {};
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
}
