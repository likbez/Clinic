
import java.util.Scanner;

/**
 * Построение меню для работы с пользователем.
 */
public class Menu {

    Scanner reader = new Scanner(System.in);

    // Основное меню
    public void mainMenu(){
        System.out.println("---------------------------------------");
        System.out.println("- Клиника для животных 'Кот в собаке' -");
        System.out.println("---------------------------------------");
        System.out.println("-     1. Вывести список клиентов.     -");
        System.out.println("-     2. Добавить клиента в базу.     -");
        System.out.println("-     3. Удаление клиента из базы.    -");
        System.out.println("-     4. Переименование клиента.      -");
        System.out.println("-     5. Поиск по клиенту и пету.     -");
        System.out.println("-                                     -");
        System.out.println("-     9. Добавить тестовых клиентов.  -");
        System.out.println("-     0. Выход из программы.          -");
        System.out.println("---------------------------------------");
    }

    // Меню выбора пета.
    public String choosePetMenu(){
        System.out.println("**************************");
        System.out.println("* Выбор пета[Dog or Cat] *");
        System.out.println("*     1. Dog             *");
        System.out.println("*     2. Cat             *");
        System.out.println("**************************");
        System.out.println(" Введи номер выбора:      ");
        String choose = reader.next();
        while(!choose.equals("1") && !choose.equals("2")){
            System.out.println("1(Dog) или 2(Cat)");
            choose = reader.next();
        }
        return choose;
    }

    // Меню выбора между клиентом и петом.
    public String chooseClientOrPet(){
        System.out.println("**************************");
        System.out.println("*     1. Имя клиента.    *");
        System.out.println("*     2. Кличка пета.    *");
        System.out.println("**************************");
        System.out.println(" Введи цифру выбора:      ");
        String choose = reader.next();
        while(!choose.equals("1") && !choose.equals("2")){
            System.out.println("1(Клиент) или 2(Пет)");
            choose = reader.next();
        }
        return choose;
    }

    // Последствия выбора в основном меню
    public void shooseMainMenu(char chooseNumber){
        Client c = new Client();
        switch (chooseNumber){
            case '0':
                System.out.println("Выход");
                break;
            case '1':
                c.listClient();
                break;
            case '2':
                c.mainAddClient();
                break;
            case '3':
                c.deleteClient(c.choiceClient());
                break;
            case '4':
                c.renameClientAndPet();
                break;
            case '5':
                c.searchClient();
                break;
            case '9':
                c.testClients();
                break;
            default:
                System.out.println("Такого пункта нет в меню.");
                break;
        }
    }
}
