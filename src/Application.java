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
        return ("Email: " +email+ " School: " +school+ "Phone Number: " +phoneNumber+  "Plan: " +plan+ "\nAptitude: " +aptitude + "\nDedication / Work Ethic: " + dedicationWorkEthic + "\nPassion: " + passion);
    }

    private Boolean eligibility(){
        while (true){
            System.out.println("(Question 1 of 11)\nDo you meet the following requirements:\n*Graduating high school in 2019 \n*In driving distance of Water Valley\n[Y/N]");
            String input = user.nextLine();
            if (input.equalsIgnoreCase("y")){
                return true;
            }else if(input.equalsIgnoreCase("n")){
                return false;
            }else{System.out.println("Please enter a valid input.");}
        }
    }

    private void applicantInformation(){
        System.out.println("2/11\nYour Name: ");
        name = user.nextLine();
        System.out.println("3/11\nEmail Address [example@email.com: ");
        email = user.nextLine();
        System.out.println("4/11\nSchool District: ");
        school = user.nextLine();
        age = ageInput();
        System.out.println("6/11\nPhone Number [1234567890]: ");
        phoneNumber = user.nextLine();
        System.out.println("7/11\nExpected Graduation Date [mm/dd]: ");
        graduationDate = user.nextLine();
        System.out.println("8/11\nWhat is your plans for next year? (If you didn't get accepted into Base Camp)");
        plan = user.nextLine();
    }

    private void qualityInfo() {
        System.out.println("9/11\nAptitude: Please share a specific example of when you were strong problem solver.");
        aptitude = user.nextLine();
        System.out.println("10/11\nDedication/Work Ethic/Heart: Please share a specific example of your dedication and work ethic.");
        dedicationWorkEthic = user.nextLine();
        System.out.println("11/11\nPassion/Persistence: Please tell us about something you are passionate about and have worked hard to achieve.");
        passion = user.nextLine();
    }

    private void submission() {
        while(true) {
            System.out.println("Do you want to submit? [y/n]");
            String bool = user.nextLine();
            if (bool.equalsIgnoreCase("y")) {
                student = new Student(name, age, school, graduationDate);
                DataBaseHelper.checkForStudentApplicant(student, this);
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

    private String ageInput(){
        while (true) {
            System.out.println("8/11\nAge:");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            try {
                Integer num = Integer.parseInt(input);
                if (Integer.class.isInstance(num)) {
                    return input;
                } else {
                    System.out.println("Please enter a valid input\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid input\n");
            }
        }
    }
}
