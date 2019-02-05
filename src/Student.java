public class Student {
    String name;
//    Change to Integer in later development
    String age;
    String school;
    String graduationDate;
    Nomination nomination;
    Application application;

    public Student(String name, String age, String school, String graduationDate){
        this.name = name;
        this.age = age;
        this.school = school;
        this.graduationDate = graduationDate;
    }

    public String toString() {
        return ("Name: " + this.name + "\n" + "Age: " + this.age + "\n" +  "School: " + school + " Graduation Date: " + this.graduationDate + "\nNomination: " + this.isNominationAvailable() + "\nApplication: " + this.isApplicationAvailable());
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setNomination(Nomination nomination) {
        this.nomination = nomination;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String isNominationAvailable(){
        if (nomination != null){
            return "Available";
        }else{
            return "Unavailable";
        }
    }

    public String isApplicationAvailable(){
        if (application != null){
            return "Available";
        }else{
            return "Unavailable";
        }
    }
}
