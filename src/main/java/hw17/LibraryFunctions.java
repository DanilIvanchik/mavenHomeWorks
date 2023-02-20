package hw17;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibraryFunctions {

    Map<String, Book> list;

    public LibraryFunctions (Map<String, Book> listOfBooks){
        this.list = listOfBooks;
    }

    static Scanner scan = new Scanner(System.in);



    public Map<String, Book> add(Book bookInfo, String book, Map<String,Book> list){
        list.put(book, bookInfo);
        return list;
    }

    public Map<String, Book> delete (String book, Map<String, Book> list){
        list.remove(book);
        return list;
    }

    public void toJson(File path, Map<String, Book> books) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(path, books);
    }

    public Map<String, Book> fromJson(File path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Book> list = objectMapper.readValue(path, HashMap.class);
        return list;
    }

    public Map<String, Book> whichFunction(LibraryFunctions host, Map<String, Book> listOfBooks){
        System.out.println("Choose 1) add or 2) remove 3) Show");

        try {
            int number = scan.nextInt();

            switch (number){
                case 1:
                    System.out.println("Which book do you want to add?");
                    String bookName = scan.next();
                    System.out.println("Author?");
                    String author = scan.next();
                    System.out.println("Genre?");
                    String genre = scan.next();
                    listOfBooks = host.add(new Book(author, genre), bookName, listOfBooks);
                    break;
                case 2:
                    System.out.println("Which book do you want to remove?");
                    String bookRemove = scan.next();
                    listOfBooks = host.delete(bookRemove, listOfBooks);
                    break;
                case 3:
                    System.out.println(listOfBooks);
                    break;
                default:
                    System.out.println("Error, retry");
                    whichFunction(host, listOfBooks);
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error, retry");
            whichFunction(host, listOfBooks);
        }finally {
            try {
                System.out.println("Again? 1 - yes, 2 - no");
                int number = scan.nextInt();

                switch (number){
                    case 1:
                        whichFunction(host, listOfBooks);
                        break;
                    case 2:
                        System.out.println("OK");
                        break;
                }

            }catch (Exception e){
                System.out.println("Error, retry");
                whichFunction(host, listOfBooks);
            }

        }
        return listOfBooks;
    }
}
