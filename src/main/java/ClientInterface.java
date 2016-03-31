
/**
 * Основные методы.
 * */
public interface ClientInterface {
    void addClient(Client client); // Добавление клиента в базу.
    void listClient(); // Показать полный список клиентов.
    void deleteClient(int x); // Удаление клиента из базы.
    void renameClientAndPet(); // Переименованеи клиента и зверушки.
    void searchClient(); // Поиск по базе.
}
