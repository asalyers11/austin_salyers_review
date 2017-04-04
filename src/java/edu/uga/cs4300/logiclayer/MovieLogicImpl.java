/*
Austin Salyers
 */
package edu.uga.cs4300.logiclayer;


import edu.uga.cs4300.objectlayer.Movie;
import edu.uga.cs4300.objectlayer.Review;
import edu.uga.cs4300.persistlayer.MoviePersistImpl;

import java.util.ArrayList;
import java.util.LinkedList;


public class MovieLogicImpl {
    
    public static ArrayList<String> discoverGenres() {
        
        ArrayList<String> genres = MoviePersistImpl.retrieveGenres();
        return genres;
    }
    public static ArrayList<String> findMovieTitlesByGenre( String genre )
    {
        ArrayList<String> titles = new ArrayList<>();
        LinkedList<Movie> movies = MoviePersistImpl.retrieveMoviesByGenre( genre );
        movies.forEach((movie) -> {
            titles.add( movie.getName() );
        });
        
        return titles;
    }
    public static ArrayList<String> findMovieTitles()
    {
        ArrayList<String> movieTitles = new ArrayList<>();
        LinkedList<Movie> movies = MoviePersistImpl.retrieveMovies();
        for( Movie movie : movies) {
            movieTitles.add( movie.getName() );
        }
        
        return movieTitles;        
    }
    public static Movie findMovieByTitle( String title )
    {
        Movie movie = MoviePersistImpl.retrieveMovieByTitle( title );
        return movie;
    }
    public static LinkedList<Review> findReviewsByMovie( Movie movie )
    {
        LinkedList<Review> reviews = MoviePersistImpl.retrieveReviewsByMovie( movie );
        return reviews;
    }
    public static int saveMovie( String title, int year, float rank )
    {
        Movie movie = new Movie( title, year, rank );
        int rowCount = MoviePersistImpl.storeMovie( movie );
        return rowCount;
    }
    public static int saveReview( String title, String review )
    {
        Movie movie = MoviePersistImpl.retrieveMovieByTitle( title );
        int rowCount = MoviePersistImpl.storeReview( movie, review );
        return rowCount;
    }
    public static int deleteMovie( String title )
    {
        Movie movie = MoviePersistImpl.retrieveMovieByTitle( title );
        LinkedList<Review> reviews = MovieLogicImpl.findReviewsByMovie( movie );
        for( Review r : reviews ) {
            int unUsed = MoviePersistImpl.deleteReview( r );
        }
        int rowCount = MoviePersistImpl.deleteMovie( movie );
        return rowCount;
    }
    public static int deleteReview( int id )
    {
        Review review = MoviePersistImpl.retrieveReviewById( id );
        int rowCount = MoviePersistImpl.deleteReview( review );
        return rowCount;
    }
}
