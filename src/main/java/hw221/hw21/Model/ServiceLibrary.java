package hw221.hw21.Model;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class ServiceLibrary implements CheckAble, ConnectDAO{

    private static Map<String, Consumer<Scanner>> mapCommand = new HashMap<>();
    private static CommandService commandService = new CommandService();
    private static final String URL = "jdbc:mysql://localhost:3306/hw";
    private static final String user = "root";
    private static final String password = "1";
    static Connection connect;
    Scanner scanner = new Scanner(System.in);

    static {
        commandInitializer();
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hw";
            Connection conn = DriverManager.getConnection(url, "root", "1");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM library");
            while (rs.next()) {
                // Получаем значения столбцов по их именам
                String title = rs.getString("title");
                String author = rs.getString("author");

                // Выводим значения на экран
                System.out.println("title: " + title + ", author: " + author );
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void commandInitializer() {
        mapCommand.put(Command.SHOW.command, scanner -> commandService.show());
        mapCommand.put(Command.ADD.command, scanner -> commandService.add());
        mapCommand.put(Command.DELETE.command, scanner -> commandService.delete());
        mapCommand.put(Command.EXIT.command, scanner -> commandService.exit());
    }

    @Override
    public boolean check(String line) {
        return line.equals("exit");
    }


    @Override
    public Connection myConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(
                    URL, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return connect;
    }

}
