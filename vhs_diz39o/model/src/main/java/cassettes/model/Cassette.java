package cassettes.model;

import cassettes.exceptions.ArgumentNullException;
import cassettes.exceptions.InvalidLength;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.format.annotation.DateTimeFormat;

public class Cassette {

    private String title;
    private String director;
    private String publisher;
    private int length;
    private Collection<Genre> genre;
    private Collection<Type> type;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate release_date;

    public int getLength() {
        return length;
    }

    public void setLength(int length) throws InvalidLength {
        if (length <= 0) {
            throw new InvalidLength("Length must be > 0!");
        } else {
            this.length = length;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws ArgumentNullException {
        if (title == null) {
            throw new ArgumentNullException("Title cannot be null!");
        } else {
            this.title = title;
        }
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) throws ArgumentNullException {
        if (director == null) {
            throw new ArgumentNullException("Director cannot be null!");
        } else {
            this.director = director;
        }
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) throws ArgumentNullException {
        if (publisher == null) {
            throw new ArgumentNullException("Publisher cannot be null!");
        } else {
            this.publisher = publisher;
        }
    }

    public Collection<Genre> getGenre() {
        return genre;
    }

    public void setGenre(Collection<Genre> genre) throws ArgumentNullException {
        if (genre == null) {
            throw new ArgumentNullException("Genre cannot be null!");
        } else {
            this.genre = genre;
        }
    }

    public Collection<Type> getType() {
        return type;
    }

    public void setType(Collection<Type> type) throws ArgumentNullException {
        if (type == null) {
            throw new ArgumentNullException("Type of cassette cannot be null!");
        } else {
            this.type = type;
        }
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) throws ArgumentNullException {
        if (release_date == null) {
            throw new ArgumentNullException("Release date cannot be null!");
        } else {
            this.release_date = release_date;
        }
    }

    public Cassette() {
    }

    public Cassette(String title, String director, String publisher, LocalDate release_date, Collection<Type> type, Collection<Genre> genre, int length) throws ArgumentNullException, InvalidLength {
        setTitle(title);
        setDirector(director);
        setPublisher(publisher);
        setRelease_date(release_date);
        setGenre(genre);
        setType(type);
        setLength(length);
    }

    @Override
    public String toString() {
        return "Games {" + "Title = " + title + ", Director = " + director + ", Publisher = " + publisher +
                ", Genre = " + genre + ", Type = " + type + ", Length in minute = " + Integer.toString(length)+ ", Release = " + release_date + "}";
    }
}
