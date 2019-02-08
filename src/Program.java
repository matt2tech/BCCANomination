import java.util.Scanner;

public class Program {

    public static void main(String [] args) {
        Program app = new Program();
        app.go();
    }

    private void go() {
        System.out.println("Welcome to Base Camp Coding Academy's Nomination/Application app!");
        String user = mainMenu();
        switch (user) {
            case "1":
                Nomination nom = new Nomination();
                nom.go();
                go();
                break;
            case "2":
                Application app = new Application();
                app.go();
                go();
                break;
            case "3":
                System.out.println("Closing...");
                System.exit(0);
            default:
                System.out.println("\nSystem Error\n");
                break;
        }
    }

    private String mainMenu() {
        while (true) {
            System.out.println("Are you nominating a student or applying to Base Camp Coding Academy?\n(1) Nominate\t(2) Apply\t(3) Quit");
            Scanner scan = new Scanner(System.in);
            String user = scan.nextLine();
            switch (user) {
                case "1":
                    return user;
                case "2":
                    return user;
                case "3":
                    return user;
                default:
                    System.out.println("\nInvalid!\n");
                    break;
            }
        }
    }
}
