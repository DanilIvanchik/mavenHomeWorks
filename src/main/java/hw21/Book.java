package hw21;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book extends Library {
    private String author;
    private String title;
}
