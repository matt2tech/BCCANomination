import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class DataBaseHelper {

    private static void writeStudentToFile(Student student){
        Student[] studentList = {};
        ArrayList<Student> students = DataBaseHelper.readFromFile();
        students.add(student);
        try (FileOutputStream fs = new FileOutputStream("studentDB.ser")){
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(studentList);
            os.writeObject(students);
            os.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> readFromFile() {
        ArrayList<Student> students = new ArrayList<Student>();
        try(FileInputStream fi = new FileInputStream("studentDB.ser")){
            ObjectInputStream os = new ObjectInputStream(fi);
            @SuppressWarnings("unused") Student[] studentList = (Student[]) os.readObject();
            @SuppressWarnings("unchecked") ArrayList<Student> studentArray = (ArrayList<Student>)os.readObject();
            students.addAll(studentArray);
            os.close();
        }catch (FileNotFoundException | ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException ignored){
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

    private static void rewriteFile(ArrayList<Student> students){
        Student[] studentList = {};
        try (FileOutputStream fs = new FileOutputStream("studentDB.ser")){
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(studentList);
            os.writeObject(students);
            os.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> searchStudentsByName(String searchInput){
        ArrayList<Student> matchingStudents = new ArrayList<Student>();
        for(Student s: DataBaseHelper.readFromFile()){
            if (s.name.contains(searchInput)){
                matchingStudents.add(s);
            }
        }
        return matchingStudents;
    }

    public static ArrayList<Student> searchStudentsBySchool(String searchInput){
        ArrayList<Student> matchingStudents = new ArrayList<Student>();
        for(Student s: DataBaseHelper.readFromFile()){
            if (s.school.contains(searchInput)){
                matchingStudents.add(s);
            }
        }
        return matchingStudents;
    }
}
