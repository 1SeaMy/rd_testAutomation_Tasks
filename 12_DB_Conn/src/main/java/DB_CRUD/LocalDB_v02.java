package DB_CRUD;


import java.sql.*;
import java.util.Scanner;

public class LocalDB_v02 {
    private static final String URL = "jdbc:mysql://localhost:3306/test_user";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "test123";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createTable();
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getInputInt("Seçenek: ");

            switch (choice) {
                case 1:
                    executeInsert();
                    break;
                case 2:
                    executeUpdate();
                    break;
                case 3:
                    executeDelete();
                    break;
                case 4:
                    listRecords();
                    break;
                case 5:
                    running = false;
                    System.out.println("Programdan çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
            }
        }
        scanner.close();
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
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

    private static void executeUpdate() {
        int id = getInputInt("Güncellemek istediğiniz kaydın ID'sini girin:");
        String name = getInputString("Yeni ismi girin:");
        String lastName = getInputString("Yeni soyismi girin:");
        String sql = "UPDATE myUsers1 SET name = ?, lastName = ? WHERE id = ?";
        executeUpdate(sql, name, lastName, id);
    }

    private static void executeInsert() {
        String name = getInputString("Lütfen ismi girin:");
        String lastName = getInputString("Lütfen soyisim girin:");
        String sql = "INSERT INTO myUsers1 (name, lastName) VALUES (?, ?)";
        executeUpdate(sql, name, lastName);
    }

    private static void executeDelete() {
        int id = getInputInt("Silmek istediğiniz kaydın ID'sini girin:");
        String sql = "DELETE FROM myUsers1 WHERE id = ?";
        executeUpdate(sql, id);
    }

    private static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS myUsers1 (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), lastName VARCHAR(50))";
        executeUpdate(sql);
    }

    private static void executeUpdate(String sql, Object... params) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("İşlem başarıyla tamamlandı.");
            } else {
                System.out.println("İşlem başarısız oldu.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void listRecords() {
        String sql = "SELECT * FROM myUsers1";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                System.out.println("ID: " + id + ", Name: " + name + ", Last Name: " + lastName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
