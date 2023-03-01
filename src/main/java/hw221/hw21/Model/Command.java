package hw221.hw21.Model;

public enum Command {
    SHOW("Show", "\t Shows the title of the book in the library"),
    ADD("Add", "\t Adds a book to the library"),
    DELETE("Delete", "\t Deletes the selected book from the library"),
    EXIT("Exit", "\t Exit");

    String command;
    String description;

    Command (String function, String description){
        this.command = function;
        this.description = description;
    }

    public static void printDescription() {
        System.out.println(Output.START_LIBRARY.description);
        System.out.println(SHOW.command + SHOW.description);
        System.out.println(DELETE.command + DELETE.description);
        System.out.println(ADD.command + ADD.description);
        System.out.println(EXIT.command + EXIT.description);
    }
}
