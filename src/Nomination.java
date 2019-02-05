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
    static Scanner user = new Scanner(System.in);

    public void go() {
        boolean eligible = eligibility();
        if (eligible) {
            nominatorForm();
            nomineeInfo();
            qualityInfo();
            submission();
        } else if (!eligible) {
            System.out.println("Apologies. This nominee is not eligible");
        } else {
            System.out.println("System Error!");
        }
    }

    public String toString() {
        return ("Nominator: " + nominator + " Email: " +nominatorEmail+ " School: " +schoolDistrict+ " Position: " +position+ " Relationship: " +relationship+ "\nAptitude: " +aptitude + "\nPerseverance: "+perseverance + "\nDedication: " + dedication + "\nWork Ethic: " + workEthic + "\nNotes: " + notes);
    }

    public void getNominatorInfo() {
        System.out.printf("Email Address: %s\nName: %s\nSchool District: %s\nPosition: %s\nRelationship to Nominee: %s\n"
                , nominatorEmail, nominator, schoolDistrict, position, relationship);
    }

    public void getNomineeInfo() {
        System.out.println(student);
    }

    public void getNomineeQuality() {
        System.out.printf("Aptitude: %s\nPerseverance: %s\nDedication: %s\nWork Ethic/Heart: %s\nNotes: %s\n"
                , aptitude, perseverance, dedication, workEthic, notes);
    }

    private boolean eligibility() {
        while (true) {
            System.out.println("For a nominee to be eligible, nominee has to be\n*Within driving distance of Water Valley\n*Graduating high school in 2019\n[Y/N]");
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
        System.out.println("Your Name: ");
        nominator = user.nextLine();
        System.out.println("Email Address: ");
        nominatorEmail = user.nextLine();
        System.out.println("School District: ");
        schoolDistrict = user.nextLine();
        System.out.println("Position: ");
        position = user.nextLine();
        System.out.println("Relationship to Nominee: ");
        relationship = user.nextLine();
    }

    private void nomineeInfo(){
        System.out.println("We will now ask you some question about the student you are nominating.");
        System.out.println("Name:");
        String name = user.nextLine();
        System.out.println("Age:");
        String age = user.nextLine();
        System.out.println("Graduation Date [mm/dd]:");
        String date = user.nextLine() + "/19";
        student = new Student(name, age, schoolDistrict, date);
    }

    private void qualityInfo() {
        System.out.println("Aptitude: Do you have any experiences when this student has demonstrated a strong ability to think logically and/or strategically?");
        aptitude = user.nextLine();
        System.out.println("Perseverance: Is there any evidence of the applicant being engaged in something they are passionate about?");
        perseverance = user.nextLine();
        System.out.println("Dedication: Do you think the applicant would be able to reliably attend the program five days a week in Water Valley?");
        dedication = user.nextLine();
        System.out.println("Work Ethic/Heart: Why does this student deserve a position at Base Camp?");
        workEthic = user.nextLine();
        System.out.println("Anything else you'd like to share about this nominee?");
        notes = user.nextLine();
    }

    private void submission() {
        while(true) {
            System.out.println("Do you want to submit? [y/n]");
            String bool = user.nextLine();
            if (bool.equalsIgnoreCase("y")) {
                student.setNomination(this);
                DataBaseHelper.writeStudentToFile(student);
                System.out.println("Submitted");
                break;
            } else if (bool.equalsIgnoreCase("n")) {
                System.out.println("Well thank you anyway for your time.");
                break;
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }
}