package Hw16;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class library {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try(BufferedReader myBuffer = new BufferedReader(new FileReader("src\\main\\resources\\books.txt"))) {;
            List<String> listOfBooks = new ArrayList<>(myBuffer.lines().map(String::trim).toList());

            LibraryFunctions host = new LibraryFunctions((ArrayList<String>) listOfBooks);

            listOfBooks = whichFunction(host, (ArrayList<String>) listOfBooks);
            Set<String> set = new HashSet<>(listOfBooks);
            listOfBooks.clear();
            listOfBooks.addAll(set);

            BufferedWriter myWriter = new BufferedWriter(new FileWriter("src\\main\\resources\\books.txt"));
            for (int i = 0; i <= listOfBooks.size()-1; i++){
                myWriter.write(listOfBooks.get(i) + '\n');
            }
            myWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static ArrayList<String> whichFunction(LibraryFunctions host, ArrayList<String> listOfBooks) {
        System.out.println("Choose 1) add or 2) remove 3) Show");
        try {
            int number = scan.nextInt();

            if (number == 1) {
                System.out.println("Which book do you want to add?");
                String book = scan.next();
                listOfBooks = host.add(book);
            } else if (number == 2) {
                System.out.println("Which book do you want to add?");
                String book = scan.next();
                listOfBooks = host.delete(book);
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
