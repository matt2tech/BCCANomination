import java.io.Serializable;
import java.util.Scanner;

public class Nomination implements Serializable {
    Student student;
    String nominator;
    String nominatorEmail;
    String schoolDistrict;
    String position;
    String relationship;
    String aptitude;
    String perseverance;
    String dedication;
    String workEthic;
    String notes;
    static final Scanner user = new Scanner(System.in);

    public void go() {
        boolean eligible = eligibility();
        if (eligible) {
            nominatorForm();
            nomineeInfo();
            qualityInfo();
            submission();
        } else {
            System.out.println("Apologies. This nominee is not eligible\n");
        }
    }

    public String toString() {
        return ("Nominator: " + nominator + " | Email: " +nominatorEmail+ " | School: " +schoolDistrict+ " | Position: " +position+ " | Relationship: " +relationship+ "\nAptitude: " +aptitude + "\nPerseverance: "+perseverance + "\nDedication: " + dedication + "\nWork Ethic: " + workEthic + "\nNotes: " + notes);
    }

    private boolean eligibility() {
        while (true) {
            System.out.println("(Question 1 of 14)\nFor a nominee to be eligible, nominee has to be\n*Within driving distance of Water Valley\n*Graduating high school in 2019\n[Y/N]");
            String bool = user.nextLine();
            if (bool.equalsIgnoreCase("y")) {
                return true;
            } else if (bool.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }

    private void nominatorForm() {
        System.out.println("2/14\nYour Name: ");
        nominator = getNonEmptyAnswer();
        System.out.println("3/14\nEmail Address [example@email.com]: ");
        nominatorEmail = getEmailInput();
        System.out.println("4/14\nSchool District: ");
        schoolDistrict = getNonEmptyAnswer();
        System.out.println("5/14\nPosition: ");
        position = getNonEmptyAnswer();
        System.out.println("6/14\nRelationship to Nominee: ");
        relationship = getNonEmptyAnswer();
    }

    private void nomineeInfo(){
        System.out.println("We will now ask you some question about the student you are nominating.");
        System.out.println("7/14\nName:");
        String name = getNonEmptyAnswer();
        String age = ageInput();
        System.out.println("9/14\nGraduation Date [01/01/19]:");
        String date = getDateInput();
        student = new Student(name, age, schoolDistrict, date);
    }

    private String ageInput(){
        while (true) {
            System.out.println("8/14\nAge:");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            try {
                Integer.parseInt(input);
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid input\n");
            }
        }
    }

    private void qualityInfo() {
        System.out.println("10/14\nAptitude: Do you have any experiences when this student has demonstrated a strong ability to think logically and/or strategically?");
        aptitude = getNonEmptyAnswer();
        System.out.println("11/14\nPerseverance: Is there any evidence of the applicant being engaged in something they are passionate about?");
        perseverance = getNonEmptyAnswer();
        System.out.println("12/14\nDedication: Do you think the applicant would be able to reliably attend the program five days a week in Water Valley?");
        dedication = getNonEmptyAnswer();
        System.out.println("13/14\nWork Ethic/Heart: Why does this student deserve a position at Base Camp?");
        workEthic = getNonEmptyAnswer();
        System.out.println("14/14\nAnything else you'd like to share about this nominee?");
        notes = user.nextLine();
    }

    private void submission() {
        while(true) {
            System.out.println("Do you want to submit? [y/n]");
            String bool = user.nextLine();
            if (bool.equalsIgnoreCase("y")) {
                DataBaseHelper.checkForStudentNominee(student, this);
                System.out.println("Submitted\n");
                break;
            } else if (bool.equalsIgnoreCase("n")) {
                System.out.println("Well thank you anyway for your time.\n");
                break;
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }

    private String getNonEmptyAnswer(){
        while (true){
            String input = user.nextLine();
            if (!input.equals("")){
                return input;
            }else{
                System.out.println("Please enter an answer");
            }
        }
    }

    private String getDateInput() {
        while (true) {
            String input = user.nextLine();
            if (input.matches("[0-9]{2}/[0-9]{2}/[0-9]{2}")) {
                return input;
            } else {
                System.out.println("Please enter a valid input\n");
            }
        }
    }

    private String getEmailInput() {
        while (true) {
            String input = user.nextLine();
            if (input.matches("[a-zA-Z0-9$&+,:;=?@#|'<>.-^*()%!]+@[a-z]+.[a-z]{2,3}")) {
                return input;
            } else {
                System.out.println("Please enter a valid input\n");
            }
        }
    }


}