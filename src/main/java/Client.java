
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by EgloRoot on 05.03.2016.
 */
public class Client implements ClientInterface{
    String name;
    Animal animal;

    Scanner reader = new Scanner(System.in);
    Menu fromMenu = new Menu();      // класс Menu

    public static final int SIZE_ARRAY = 10;
    public static Client []clientArray = new Client[SIZE_ARRAY];

    Pattern regularNumber = Pattern.compile("\\d+");
    Client(){}

    public Client(String name, Animal animal) {
        this.name = name;
        this.animal = animal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal){
        this.animal = animal;
    }

    /**
     * Добавляем тестовых клиентов.
     * */
    public void testClients(){
        addClient(new Client("Argon", new Dog("Пасть")));
        addClient(new Client("Brik", new Cat("Коготь")));
        addClient(new Client("Caron", new Cat("Печень")));
        System.out.println("Клиенты добавлены.");
    }
    /**
     * Добавление клиентов.
     * */
    public void addClient(Client client){
        for (int i = 0; i < clientArray.length; i++) {
            if (clientArray[i] == null) {
                clientArray[i] = client;
                break;
            }
        }
    }
    /**
     * Выводит список клиентов.
     * Здесь все просто и понятно.
     * */
    public void listClient() {
        for (int i = 0; i < clientArray.length; i++) {
            if(clientArray[i] != null) {
                System.out.println((i + 1) + ". Mr." + clientArray[i].getName() +
                        " and " + clientArray[i].getAnimal().getClass().getSimpleName() +
                        ": '" + clientArray[i].getAnimal().getName() + "'");
            } else {continue;}
        }
    }
    /**
     * Основной метод добавления клиентов с блекджеком и шлюхами
     * @nameMan ввод имени будущего хозяина.
     * @pet выбор вида зверушки Dog или Cat.
     * @namePet кличка зверушки.
     * */
    public void mainAddClient() {
        System.out.println("Имя хозяина зверушки: ");
        String nameMan = reader.next();
        String pet = fromMenu.choosePetMenu(); // Выбираем что за пет.
        System.out.println("Кличка зверушки: ");
        String namePet = reader.next();
        if(pet.equals("1")){
            addClient(new Client(nameMan, new Dog(namePet)));
        }else if(pet.equals("2")){
            addClient(new Client(nameMan, new Cat(namePet)));
        }
    }
    /**
     * Удаление клиентов из базы
     * @choiceClient() выдает нам номер клиента.
     * */
    public void deleteClient(int number) {
       // int number = choiceClient();
        if (clientArray[number] != null) {
                clientArray[number] = null;
            } else {
                System.out.println("Здесь и так пусто!");
            }
        }
    /**
     * Ренейм хозяина или петомца.
     * Через chooseClientOrPet() делаем выбор между хозяином или петом.
     * А после , в зависимости от выбора вызываются, или метод renameClient(number),
     * или renamePet(number)
     * @choiceClient() выдает нам номер клиента.
     * */
    public void renameClientAndPet() {
        int number = choiceClient();
        if (clientArray[number] != null) {
            // Вывод жерты для переименования.
            System.out.println((number + 1) + ". Mr." + clientArray[number].getName() +
                    " and " + clientArray[number].getAnimal().getClass().getSimpleName() +
                    ": '" + clientArray[number].getAnimal().getName() + "'");

            System.out.println("--------------------------");
            System.out.println("-   Переименовать:       -");

            String chooseRename = fromMenu.chooseClientOrPet();
            if(chooseRename.equals("1")){
                renameClient(number);
            }else if (chooseRename.equals("2")){
                renamePet(number);
            }
        } else {
            System.out.println("Позиция пуста!");
        }
    }
    /**
     * Ренейм хозяина.
     * Метод вызывается через renameClientAndPet()
     * */
    public void renameClient(int number) {
        System.out.println("Новое имя клиента: ");
        String NewNameMan = reader.next();
        clientArray[number].setName(NewNameMan);
    }
    /**
     * Ренейм пета.
     * Выбираем на кого меняем, собачку или кошку, после
     * выбор нового имени и замена.
     * Метод вызывается через renameClientAndPet()
     * @choose вернет 1(Dog) или 2(Cat).
     * @namePet кличка животного
     * */
    public void renamePet(int number) {
        System.out.println("Новый пет: ");
        String choose = fromMenu.choosePetMenu(); // метод выбора пета

        if(choose.equals("1")) {
            System.out.println("Кличка собачки: ");
            String namePet = reader.next();
            Dog dog = new Dog(namePet);
            clientArray[number].setAnimal(dog);
        }
        else if(choose.equals("2")){
            System.out.println("Кличка кота: ");
            String namePet = reader.next();
            Cat cat = new Cat(namePet);
            clientArray[number].setAnimal(cat);
        }
    }
    /**
     * Поиск по базе. Метод chooseClientOrPet() возвращает 1(Хозяин) или 2(Пет),
     * по кому ищем. После выбора, вводим имя, происходит поиск, с пробегом
     * по всему массиву, сравнение и вывод результата.
     * @searchClient имя по которому ищем
     * @searchPet кличка животного по которой ищем
     * @throws NullPointerException упадет при str == null.
     * */
    public void searchClient()throws NullPointerException{
        System.out.println("**************************");
        System.out.println("*   Искать по:           *");
        String choose = fromMenu.chooseClientOrPet(); // по кому ищем.
        try{
        if (choose.equals("1")) {
            System.out.println("Введите имя клиента: ");
            String searchClient = reader.next();
            for (int i = 0; i < clientArray.length; i++){
                String str = clientArray[i].getName();
                while (!str.equals(null)) {
                    if (searchClient.equalsIgnoreCase(str)) {
                        System.out.println((i + 1) + ". Mr." + clientArray[i].getName() +
                                " and " + clientArray[i].getAnimal().getClass().getSimpleName() +
                                ": '" + clientArray[i].getAnimal().getName() + "'");
                    }
                    break;
                }
            }
        } else if (choose.equals("2")) {
            System.out.println("Введите имя пета: ");
            String searchPet = reader.next();
            for (int i = 0; i < clientArray.length; i++) {
                String str = clientArray[i].getAnimal().getName();
                while (!str.equals(null)){
                if (searchPet.equalsIgnoreCase(str)) {
                    System.out.println((i + 1) + ". Mr." + clientArray[i].getName() +
                            " and " + clientArray[i].getAnimal().getClass().getSimpleName() +
                            ": '" + clientArray[i].getAnimal().getName() + "'");
                }
                    break;
              }
            }
         }
      } catch (NullPointerException e){}
    }
    /*
    * Метод для выбора клиента. ДЛя методов deleteClient() и renameClient().
    * С валидацией на верность ввода.
    */
    public int choiceClient() {
        System.out.println("Выбор номера жертвы: ");
        String numberDeleteClientString = reader.next();
        int numberDeleteClient;
        Matcher mather = regularNumber.matcher(numberDeleteClientString);
        while (!mather.matches()) {
            System.out.println("Не верное значение, еще попытка.");
            numberDeleteClientString = reader.next();
            mather = regularNumber.matcher(numberDeleteClientString);
        }
        numberDeleteClient = (Integer.valueOf(numberDeleteClientString) - 1);
        while (numberDeleteClient < 0 || numberDeleteClient > clientArray.length){
            System.out.println("Не верное значение, еще попытка.");
            numberDeleteClientString = reader.next();
            numberDeleteClient = (Integer.valueOf(numberDeleteClientString) - 1);
        }
        return numberDeleteClient;
    }
}
