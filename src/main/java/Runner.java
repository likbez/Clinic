
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by EgloRoot on 05.03.2016.
 */
public class Runner {
    public static void main(String[] args) throws IOException {

        Menu fromMenu = new Menu();      // класс Menu
        char exit = 1;
        Scanner reader = new Scanner(System.in);
        while (exit != '0') {

            fromMenu.mainMenu(); // Главное меню

            // Выбор в главном меню
            String chooseNumberString = reader.next();
            char chooseNumber = chooseNumberString.charAt(0);

            fromMenu.shooseMainMenu(chooseNumber);
            exit = chooseNumber;
        }
    }
}
