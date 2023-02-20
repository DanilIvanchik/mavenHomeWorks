package hw17;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibraryFunctions {

    Map<String, String> list;

    public LibraryFunctions (Map<String, String> listOfBooks){
        this.list = listOfBooks;
    }

    static Scanner scan = new Scanner(System.in);



    public Map<String, String> add(String book, String author, Map<String, String> list){
        list.put(book, author);
        return list;
    }

    public Map<String, String> delete (String book, Map<String, String> list){
        list.remove(book);
        return list;
    }

    public void toJson(File path, Map<String, String> books) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(path, books);
    }

    public Map<String, String> fromJson(File path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> list = objectMapper.readValue(path, HashMap.class);
        return list;
    }

    public Map<String, String> whichFunction(LibraryFunctions host, Map<String, String> listOfBooks){
        System.out.println("Choose 1) add or 2) remove 3) Show");

        try {
            int number = scan.nextInt();

            if (number == 1) {
                System.out.println("Which book do you want to add?");
                String bookName = scan.next();
                System.out.println("Author?");
                String author = scan.next();
                listOfBooks = host.add(bookName, author, listOfBooks);
            } else if (number == 2) {
                System.out.println("Which book do you want to remove?");
                String book = scan.next();
                listOfBooks = host.delete(book, listOfBooks);
            } else if (number == 3) {
                System.out.println(listOfBooks);
            } else {
                System.out.println("Error, retry");
                whichFunction(host, listOfBooks);
            }

        } catch (Exception e) {
            System.out.println("Error, retry");
            whichFunction(host, listOfBooks);
        }finally {
            try {
                System.out.println("Again? 1 - yes, 2 - no");
                int number = scan.nextInt();

                if (number == 1){
                    whichFunction(host, listOfBooks);
                }else {
                    System.out.println("OK");
                }
            }catch (Exception e){
                System.out.println("Error, retry");
                whichFunction(host, listOfBooks);
            }

        }
        return listOfBooks;
    }
}
