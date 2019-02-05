public class Student {
    String name;
//    Change to Integer in later development
    String age;
    String graduationDate;
    Nomination nomination;

    public Student(String name, String age, String graduationDate){
        this.name = name;
        this.age = age;
        this.graduationDate = graduationDate;
    }

    public String toString() {
        return ("Name: " + this.name + "\n" + "Age: " + this.age + "\n" + "Graduation Date: " + this.graduationDate + "\n" + "Nomination: " + this.isNominationAvaliable());
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

    public String isNominationAvaliable(){
        if (nomination != null){
            return "Avaliable";
        }else{
            return "Unavaliable";
        }
    }
}
