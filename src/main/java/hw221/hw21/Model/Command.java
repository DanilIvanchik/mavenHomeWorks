package hw221.hw21.Model;

public enum Command {
    SHOW("Show", " - shows the title of the book in the library;"),
    ADD("Add", " - adds a book to the library;"),
    DELETE("Delete", " - deletes the selected book from the library;"),
    EXIT("Eit", " - exit from the program;");

    String command;
    String description;

    Command (String command, String description){
        this.command = command;
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
