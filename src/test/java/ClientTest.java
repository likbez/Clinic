
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by EgloRoot on 20.03.2016.
 */
public class ClientTest {

     Client client;

    @Before
    public void setUp() throws Exception {
        client = new Client();
    }
    /**
     * Добавляет тестовых клиентов, проверяем, что массив не пуст.
     * Если не пуст, тест пройден.
     * */
    @Test
    public void testTestClients() throws Exception {
        client.testClients();
        assertNotNull(Client.clientArray);
    }
    /**
     * Добавляем клиента, проверяем наличие имени и клички пета.
     * Все есть, значит тест пройден.
     * */
    @Test
    public void testAddClient() throws Exception {
        client.addClient(new Client("Argon", new Dog("Пасть")));
        String nameClient = Client.clientArray[0].getName();
        String namePet = Client.clientArray[0].getAnimal().getName();
        assertEquals(nameClient, "Argon");
        assertEquals(namePet, "Пасть");
    }
    /**
     * Добавляем клиента в массив, проверяем полон ли массив.
     * После удаляем клиента, проверяем пуст ли массив.
     * Тест пройден, если до удалени массив полон, после удаление пуст.
     * */
    @Test
    public void testDeleteClient() throws Exception {
        Client c = new Client("Argon", new Dog("Пасть"));
        Client.clientArray[0] = c;
        assertNotNull(Client.clientArray[0]);
        client.deleteClient(0);
        assertNull(Client.clientArray[0]);
    }
    @Ignore
    @Test
    public void testRenameClient() throws Exception {
        Client c = new Client("Argon", new Dog("Пасть"));
        Client.clientArray[0] = c;
        client.renameClient(0);
        fail("Ожидаем реализации");
    }
    @Ignore
    @Test
    public void testRenamePet() throws Exception {
        fail("Ожидаем реализации");
    }
    @Ignore
    @Test
    public void testSearchClient() throws Exception {
        fail("Ожидаем реализации");
    }
    @Ignore
    @Test
    public void testChoiceClient() throws Exception {
        fail("Ожидаем реализации");
    }
}



