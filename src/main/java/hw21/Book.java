package hw21;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book extends Library {
    String author;
    String title;
}
