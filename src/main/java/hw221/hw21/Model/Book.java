package hw221.hw21.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book extends Library {
    String author;
    String title;
}
