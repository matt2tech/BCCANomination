import java.util.Scanner;

public class Nomination {
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
    Scanner user = new Scanner(System.in);

    public void go() {
        boolean eligible = eligibility();
        if (eligible == true) {
            nominatorForm();
            nomineeInfo();
            qualityInfo();
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
                System.out.println("Please input correct answer");
            }
        }
    }

    private void nominatorForm() {
        System.out.println("Email Address: ");
        nominatorEmail = user.nextLine();
        System.out.println("Your Name: ");
        nominator = user.nextLine();
        System.out.println("School District: ");
        schoolDistrict = user.nextLine();
        System.out.println("Position: ");
        position = user.nextLine();
        System.out.println("Relationship to Nominee: ");
        relationship = user.nextLine();
    }

    private void nomineeInfo(){
        System.out.println("Name:");
        String name = user.nextLine();
        System.out.println("Age:");
        String age = user.nextLine();
        System.out.println("Graduation Date [mm/dd]:");
        String date = user.nextLine() + "/19";
        student = new Student(name, age, date);
    }

    private void qualityInfo() {
        System.out.println("Aptitude: ");
        nominatorEmail = user.nextLine();
        System.out.println("Perseverance: ");
        nominator = user.nextLine();
        System.out.println("Dedication: ");
        schoolDistrict = user.nextLine();
        System.out.println("Work Ethic/Heart: ");
        position = user.nextLine();
        System.out.println("Notes: ");
        relationship = user.nextLine();
    }
}
