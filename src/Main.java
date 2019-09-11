
import PeopleInformation.TextUserInterface;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TextUserInterface ui = new TextUserInterface(scan);

        ui.start();
    }
}
