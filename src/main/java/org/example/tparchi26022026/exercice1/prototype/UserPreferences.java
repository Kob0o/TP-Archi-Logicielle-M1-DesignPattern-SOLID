package org.example.tparchi26022026.exercice1.prototype;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class UserPreferences implements Cloneable {
    // Getters et Setters
    private String preferredLanguage;
    private String theme;
    private List<String> favoriteGenres;
    private List<String> favoriteAuthors;
    private Integer maxResultsPerPage;
    private Boolean emailNotifications;
    private Boolean smsNotifications;

    public UserPreferences() {
        this.favoriteGenres = new ArrayList<>();
        this.favoriteAuthors = new ArrayList<>();
    }

    public void addFavoriteGenre(String genre) {
        this.favoriteGenres.add(genre);
    }

    public void addFavoriteAuthor(String author) {
        this.favoriteAuthors.add(author);
    }


    @Override
    public UserPreferences clone() {
        try {
            UserPreferences cloned = (UserPreferences) super.clone();
            
            // Deep copy des listes (création de nouvelles listes avec les mêmes éléments)
            cloned.favoriteGenres = new ArrayList<>(this.favoriteGenres);
            cloned.favoriteAuthors = new ArrayList<>(this.favoriteAuthors);
            
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clonage non supporté", e);
        }
    }

    @Override
    public String toString() {
        return "UserPreferences{" +
                "preferredLanguage='" + preferredLanguage + '\'' +
                ", theme='" + theme + '\'' +
                ", favoriteGenres=" + favoriteGenres +
                ", favoriteAuthors=" + favoriteAuthors +
                ", maxResultsPerPage=" + maxResultsPerPage +
                ", emailNotifications=" + emailNotifications +
                ", smsNotifications=" + smsNotifications +
                '}';
    }
}
