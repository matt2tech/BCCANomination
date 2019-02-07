import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    final Scanner user = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<Student>();

    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.go();
    }

    private void go() {
        System.out.println("Welcome Sean Anthony");
        chooseFilter();
    }

    private void chooseFilter(){
        while (true) {
            System.out.println("1)Show all applicants 2)Show ready applicants 3)Quit");
            String choice = user.nextLine();
            switch (choice) {
                case "1":
                    getStudents();
                    askForSelection();
                    break;
                case "2":
                    getReadyStudents();
                    askForSelection();
                    break;
                case "3":
                    System.out.println("Closing...");
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid input");
                    break;
            }
        }
    }

    private void getStudents(){
        students.clear();
        students.addAll(DataBaseHelper.readFromFile());
    }

    private void getReadyStudents(){
        students.clear();
        for (Student s: DataBaseHelper.readFromFile()){
            if (s.isApplicationAvailable().equals("Available") && s.isNominationAvailable().equals("Available")){
                students.add(s);
            }
        }
    }

    private void showStudents(){
        int counter = 1;
        for(Student s: students){
            System.out.println(counter +") " + s);
            counter ++;
        }
    }

    private void askForSelection(){
        while (true){
            showStudents();
            System.out.println("\nPlease select a number that corresponds to a student(or enter 0 to go back to the main menu):");
            Scanner scan = new Scanner(System.in);
            String selection = scan.nextLine();
            try {
                Integer num = Integer.parseInt(selection);
                if (num - 1 >= 0 && num <= students.size()){
                    showStudentDetails(students.get(num - 1));
                    break;
                }else if(num == 0){
                    chooseFilter();
                }
                else {
                    System.out.println("Please enter a valid input\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid input\n");
            }
        }
    }

    private void showStudentDetails(Student student){
        System.out.println("\n" + student);
        label:
        while (true) {
            System.out.println("\n---Please select a choice---\n1)Nomination 2)Application 3)Back");
            String choice = user.nextLine();
            switch (choice) {
                case "1":
                    student.showNomination();
                    break;
                case "2":
                    student.showApplication();
                    break;
                case "3":
                    askForSelection();
                    break label;
                default:
                    System.out.println("Please enter a valid input");
                    break;
            }
        }
    }
}
