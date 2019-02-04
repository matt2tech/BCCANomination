import java.util.Scanner;

public class Program {

    public static void main(String [] args) {
        Program app = new Program();
        app.go();
    }

    public void go() {
        String user = mainMenu();
    }

    public String mainMenu() {
        System.out.println("(1) Nominator\t(2) Applicant");
        while (true) {
            Scanner scan = new Scanner(System.in);
            String user = scan.nextLine();
            if(user.equals("1")) {
                return user;
            } else if (user.equals("2")) {
                return user;
            } else {
                System.out.println("Invalid!\n(1) Nominator\t(2) Applicant");
            }
        }
    }
}
