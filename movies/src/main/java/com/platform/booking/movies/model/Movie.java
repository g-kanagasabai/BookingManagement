package com.platform.booking.movies.model;




//@Entity
//@Table(name = "movies")
public class Movie {
    //@Id
    //@Column(name = "movie_id")
    private int movieId;

    //@Column(name = "movie_title")
    private String movieTitle;

    //@Column(name = "language")
    private String language;

    //@Column(name = "genre")
    private String genre;

    //@Column(name = "cast")
    private String cast;

    public Movie(){}

    public Movie(int movieId, String movieTitle, String language, String genre, String cast) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.language = language;
        this.genre = genre;
        this.cast = cast;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                ", cast='" + cast + '\'' +
                '}';
    }
}
