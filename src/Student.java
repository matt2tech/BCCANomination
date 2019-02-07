import java.io.Serializable;

public class Student implements Serializable {
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
        return (this.name + "\n\tAge: " + this.age  +  "\n\tSchool: " + school + "\n\tNomination: " + this.isNominationAvailable() + "\n\tApplication: " + this.isApplicationAvailable());
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

    public void showNomination(){
        if (isNominationAvailable().equals("Available")){
            System.out.println(this.nomination);
        }else if(isNominationAvailable().equals("Unavailable")){
            System.out.println("Nomination not available at this time");
        }else{
            System.out.println("Error");
        }
    }

    public void showApplication(){
        if (isApplicationAvailable().equals("Available")){
            System.out.println(this.application);
        }else if(isApplicationAvailable().equals("Unavailable")){
            System.out.println("Application not available at this time");
        }else{
            System.out.println("Error");
        }
    }
}
