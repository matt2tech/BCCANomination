import java.util.Scanner;

public class Nomination {
    String student;
    String nominator;
    String nominatorEmail;
    String schoolDistrict;
    String position;
    String relationship;
    Integer studentAge;
    String studentGraduation;
    String aptitude;
    String perseverance;
    String dedication;
    String workEthic;
    String notes;
    Scanner user = new Scanner(System.in);

    public void go() {
        boolean eligible = eligibility();
        if (eligible == true) {
            nominatorForm();
        } else if (eligible == false) {
            System.out.println("Apologies. This nominee is not eligible");
        } else {
            System.out.println("System Error!");
        }
    }

    public void getNominatorInfo() {
        System.out.printf("Email Address: %s\nName: %s\nSchool District: %s\nPosition: %s\nRelationship to Nominee: %s\n"
                , nominatorEmail, nominator, schoolDistrict, position, relationship);
    }

    public void getNomineeInfo() {
        System.out.printf("Name: %s\nAge: %s\nExpected Graduation Date: %s\n"
                , student, studentAge, studentGraduation);
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
                System.out.println("Please input correct answer");
            }
        }
    }

    private void nominatorForm() {
        System.out.println("Email Address: ");
        nominatorEmail = user.nextLine();
    }
}
