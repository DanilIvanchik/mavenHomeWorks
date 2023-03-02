package hw221.hw21.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandService extends ServiceLibrary {

    public Book createBook() {
        var bookBuilder = Book.builder();
        System.out.println(Output.NAME.description);
        bookBuilder.title(String.valueOf(scanner.nextLine()));
        System.out.println(Output.AUTHOR.description);
        bookBuilder.author(String.valueOf(scanner.nextLine()));
        Book book = bookBuilder.build();
        return book;
    }

    public void add() {
        Book book = createBook();
        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate("INSERT INTO library(title, author) VALUES ('"
                    + book.getAuthor() + "' , '" + book.getTitle() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(Output.ADD.description);
    }

    public void delete() {
        System.out.println(Output.ID.description);
        int row = scanner.nextInt();
        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate("DELETE FROM library WHERE book_id = " + String.valueOf(row));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(Output.DELETE.description);
    }

    public void exit() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        try {
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select * from library");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  "
                        + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}