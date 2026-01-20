import java.util.ArrayList;
import java.util.List;

class InvalidTimeFormatException extends Exception {
  public InvalidTimeFormatException(String message) {
    super(message);
  }
}

public class CinemaTime {

  private List<String> movies = new ArrayList<>();
  private List<String> showTimes = new ArrayList<>();

  private void validateTimeFormat(String time) throws InvalidTimeFormatException {
    if (!time.matches("\\d{2}:\\d{2}")) {
      throw new InvalidTimeFormatException("Invalid time format: " + time);
    }
    int hours = Integer.parseInt(time.substring(0, 2));
    int minutes = Integer.parseInt(time.substring(3, 5));
    if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
      throw new InvalidTimeFormatException("Invalid time value: " + time);
    }
  }

  public void addMovie(String movieName, String time) throws InvalidTimeFormatException {

    validateTimeFormat(time);
    movies.add(movieName);
    showTimes.add(time);
    System.out.println("Movie '" + movieName + "' added at " + time);
  }

  public void searchMovie(String movieName) {
    try {
      boolean found = false;
      for (int i = 0; i < movies.size(); i++) {
        if (movies.get(i).contains(movieName)) {
          System.out.println(String.format("Found: %s at %s", movies.get(i), showTimes.get(i)));
          found = true;
        }
      }
      if (!found) {
        System.out.println("No movie found with keyword: " + movieName);
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Search error: Invalid index access");
    }
  }

  public void displayAllMovies() {
    System.out.println("All Movies and Show Times:");
    for (int i = 0; i < movies.size(); i++) {
      System.out.println("Movie: " + movies.get(i) + ", Time: " + showTimes.get(i));
    }
  }

  public static void main(String[] args) {
    CinemaTime cinema = new CinemaTime();
    try {
      cinema.addMovie("Inception", "14:30");
      cinema.addMovie("The Matrix", "16:00");
      cinema.addMovie("Interstellar", "18:45");
      cinema.addMovie("Invalid Movie", "25:00");
    } catch (InvalidTimeFormatException e) {
      System.out.println(e.getMessage());
    }

    cinema.displayAllMovies();
    cinema.searchMovie("Matrix");
    cinema.searchMovie("Avatar");
  }

}
