import java.io.Serializable;
import java.util.Scanner;

public class Application implements Serializable {
    static Scanner user = new Scanner(System.in);
    Student student;
    String name;
    String email;
    String school;
    String age;
    String phoneNumber;
    String graduationDate;
    String plan;
    String aptitude;
    String dedicationWorkEthic;
    String passion;

    public void go(){
        boolean bool = eligibility();
        if (bool){
            applicantInformation();
            qualityInfo();
            submission();
        }else if(!bool){
            System.out.println("Sorry, you can not apply. You don not meet our criteria.");
        }else{
            System.out.println("System Error");
        }
    }

    public String toString() {
        return (" Email: " +email+ " School: " +school+ "Phone Number: " +phoneNumber+  "Plan: " +plan+ "\nAptitude: " +aptitude + "\nDedication / Work Ethic: " + dedicationWorkEthic + "\nPassion: " + passion);
    }

    private Boolean eligibility(){
        while (true){
            System.out.println("Do you meet the following requirements:\n*Graduating high school in 2019 \n*In driving distance of Water Valley\n[Y/N]");
            String input = user.nextLine();
            if (input.equalsIgnoreCase("y")){
                return true;
            }else if(input.equalsIgnoreCase("n")){
                return false;
            }else{System.out.println("Please enter a valid input.");}
        }
    }

    private void applicantInformation(){
        System.out.println("Your Name: ");
        name = user.nextLine();
        System.out.println("Email Address: ");
        email = user.nextLine();
        System.out.println("School District: ");
        school = user.nextLine();
        System.out.println("Age: ");
        age = user.nextLine();
        System.out.println("Phone Number: ");
        phoneNumber = user.nextLine();
        System.out.println("Expected Graduation Date: ");
        graduationDate = user.nextLine();
        System.out.println("What is your plans for next year? (If you didn't get accepted into Base Camp)");
        plan = user.nextLine();
    }

    private void qualityInfo() {
        System.out.println("Aptitude: Please share a specific example of when you were strong problem solver.");
        aptitude = user.nextLine();
        System.out.println("Dedication/Work Ethic/Heart: Please share a specific example of your dedication and work ethic.");
        dedicationWorkEthic = user.nextLine();
        System.out.println("Passion/Persistence: Please tell us about something you are passionate about and have worked hard to achieve.");
        passion = user.nextLine();
    }

    private void submission() {
        while(true) {
            System.out.println("Do you want to submit? [y/n]");
            String bool = user.nextLine();
            if (bool.equalsIgnoreCase("y")) {
                student = new Student(name, age, school, graduationDate);
                student.setApplication(this);
                System.out.println("Submitted");
                break;
            } else if (bool.equalsIgnoreCase("n")) {
                System.out.println("Well thank you anyways for your time.");
                break;
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }
}
