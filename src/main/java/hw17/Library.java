package hw17;
import java.io.*;
import java.util.*;

public class Library {
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        File path = new File("books.json");
        Map<String, String> listOfBooks = new HashMap<>();
        LibraryFunctions host = new LibraryFunctions(listOfBooks);

        try {
            if (path.length() != 0){
                listOfBooks = host.fromJson(path);
                listOfBooks = host.whichFunction(host,listOfBooks);
                try {
                    host.toJson(path, listOfBooks);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                listOfBooks = host.whichFunction(host,listOfBooks);
                try {
                    host.toJson(path, listOfBooks);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
