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

    public void go() {

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
}
