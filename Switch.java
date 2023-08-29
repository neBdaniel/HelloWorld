import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);

        System.out.println("Enter your Name");

        String name = user.nextLine();
        System.out.print("type minor if you're under 18");
        System.out.print("type legal if you're over 18");
        String legal = user.nextLine();
        System.out.print("");

        switch(legal){
            case "minor":
                System.out.println(name + " You are under 18");
                System.out.println("Therefore, you're not allowed to proceed");
                break;
            case "legal":
                System.out.println(name + " You are over 18");
                System.out.println("You may now proceed!");
                break;
            default:
                System.out.println(name + ", Your input is invalid");               
        }

        user.close();
    }
}
