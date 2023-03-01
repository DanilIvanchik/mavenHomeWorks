package hw221.hw21.Model;

public enum Output {
    NAME("Enter name of book: "),
    AUTHOR("Enter author of book: "),
    ADD("The book has been added to the library."),
    DELETE("The book has been deleted from the library."),
    START_LIBRARY("Enter command: "),
    REPEAT("Repeat input"),
    ID("Enter id number"),
    CONNECT_SUCCESS("Connect to DB was successful"),
    NO_CONNECT("No connection to DB");

    public String description;

    Output(String description) {
        this.description = description;
    }
}
