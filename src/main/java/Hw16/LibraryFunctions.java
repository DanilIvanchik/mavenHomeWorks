package Hw16;

import java.util.ArrayList;

public class LibraryFunctions {

    ArrayList<String> list;

    public LibraryFunctions (ArrayList<String> listOfBooks){
        this.list = listOfBooks;
    }

    public ArrayList<String> add(String book){
        list.add(book);
        return list;
    }

    public ArrayList<String> delete (String book){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(book)){
                list.remove(i);
            }
        }
        return list;
    }
}
