import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
  String name();
}

@Author(name = "Shravan")
class Book {
}

public class AuthorAnnotationDemo {
  public static void main(String[] args) {
    Class<?> bookClass = Book.class;
    if (bookClass.isAnnotationPresent(Author.class)) {
      Author author = bookClass.getAnnotation(Author.class);
      System.out.println("Author: " + author.name());
    } else {
      System.out.println("Author annotation not found.");
    }
  }
}
