import java.util.Arrays;

class Movie {
    private String title;
    private double rating;
    private int releaseYear;

    public Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return title + " (" + releaseYear + ") " + rating;
    }
}

public class TrendingMovies {
    public static void main(String[] args) {
        Arrays.asList(
                new Movie("Inception", 8.8, 2010),
                new Movie("The Dark Knight", 9.0, 2008),
                new Movie("Interstellar", 8.6, 2014),
                new Movie("The Matrix", 8.7, 1999),
                new Movie("Parasite", 8.6, 2019)).stream()
                .filter(movie -> movie.getRating() > 8.5)
                .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
                .limit(5)
                .forEach(System.out::println);
    }

}
