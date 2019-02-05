import java.util.Scanner;

public class Application {
    Scanner user = new Scanner(System.in);
    String name;
    String email;
    String school;
    String eligible;
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
        }else if(!bool){
            System.out.println("Sorry, you can not apply. You don not meet our criteria.");
        }else{
            System.out.println("System Error");
        }
    }

    public Boolean eligibility(){
        while (true){
            System.out.println("Do you meet the following requirements:[Y/N]\n-Graduating high school in 2019 \n-In driving distance of Water Valley");
            String input = user.nextLine();
            if (input.equalsIgnoreCase("y")){
                return true;
            }else if(input.equalsIgnoreCase("n")){
                return false;
            }else{System.out.println("Please enter a valid input.");}
        }
    }

    public void applicantInformation(){
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
}
