package DB_CRUD;

import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.Scanner;

public class RemoteDB_v02 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Jdbi jdbi = Jdbi.create("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11683129", "sql11683129", "H4C3WSLHWe");
        createTable(jdbi);
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getInputInt("Seçenek: ");

            switch (choice) {
                case 1 -> executeInsert(jdbi);
                case 2 -> executeUpdate(jdbi);
                case 3 -> executeDelete(jdbi);
                case 4 -> listRecords(jdbi);
                case 5 -> {
                    running = false;
                    System.out.println("Programdan çıkılıyor...");
                }
                default -> System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
            }
        }
        scanner.close();
    }

    private static int getInputInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.next();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Lütfen bir tamsayı girin.");
            }
        }
    }

    private static String getInputString(String message) {
        System.out.print(message);
        return scanner.next();
    }

    private static void printMenu() {
        System.out.println("\nLütfen yapmak istediğiniz işlemi seçin:");
        System.out.println("1 - Yeni kayıt ekle");
        System.out.println("2 - Kayıt güncelle");
        System.out.println("3 - Kayıt sil");
        System.out.println("4 - Kayıtları listele");
        System.out.println("5 - Çıkış");
    }

    private static void executeUpdate(Jdbi jdbi) {
        int id = getInputInt("Güncellemek istediğiniz kaydın ID'sini girin:");
        String name = getInputString("Yeni ismi girin:");
        String lastName = getInputString("Yeni soyismi girin:");
        jdbi.useHandle(handle -> {
            handle.createUpdate("UPDATE denizalbayrak SET name = :name, lastName = :lastName WHERE id = :id")
                    .bind("name", name)
                    .bind("lastName", lastName)
                    .bind("id", id)
                    .execute();
            System.out.println("İşlem başarıyla tamamlandı.");
        });
    }

    private static void executeInsert(Jdbi jdbi) {
        String name = getInputString("Lütfen ismi girin:");
        String lastName = getInputString("Lütfen soyisim girin:");
        jdbi.useHandle(handle -> {
            handle.createUpdate("INSERT INTO denizalbayrak (name, lastName) VALUES (:name, :lastName)")
                    .bind("name", name)
                    .bind("lastName", lastName)
                    .execute();
            System.out.println("İşlem başarıyla tamamlandı.");
        });
    }

    private static void executeDelete(Jdbi jdbi) {
        int id = getInputInt("Silmek istediğiniz kaydın ID'sini girin:");
        jdbi.useHandle(handle -> {
            handle.createUpdate("DELETE FROM denizalbayrak WHERE id = :id")
                    .bind("id", id)
                    .execute();
            System.out.println("İşlem başarıyla tamamlandı.");
        });
    }

    private static void createTable(Jdbi jdbi) {
        jdbi.useHandle(handle -> {
            handle.execute("CREATE TABLE IF NOT EXISTS denizalbayrak (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), lastName VARCHAR(50))");
        });
    }

    private static void listRecords(Jdbi jdbi) {
        List<Person> persons = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM denizalbayrak")
                        .mapToBean(Person.class)
                        .list());

        persons.forEach(person ->
                System.out.println("ID: " + person.getId() + ", Name: " + person.getName() + ", Last Name: " + person.getLastName()));
    }

    public static class Person {
        private int id;
        private String name;
        private String lastName;

        // Getter and setter methods
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}

