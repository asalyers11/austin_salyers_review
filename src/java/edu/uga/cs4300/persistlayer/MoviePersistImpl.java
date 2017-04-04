
package edu.uga.cs4300.persistlayer;

import edu.uga.cs4300.objectlayer.Movie;
import edu.uga.cs4300.objectlayer.Review;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;


public class MoviePersistImpl {
    
    public static ArrayList retrieveGenres() 
    {
        Connection conn = DbAccessImpl.connect();
        ResultSet rs;
        String query =  "select distinct genre " 
                        +   "from movies_genres";
        conn = DbAccessImpl.connect();
        rs = DbAccessImpl.retrieve( conn, query );

        ArrayList<String> genres = new ArrayList<String>();

        try {
            while( rs.next() ) {
                genres.add( rs.getString( 1 ) );         
            }
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        DbAccessImpl.disconnect(conn);
        return genres;
    }
    
    public static LinkedList<Movie> retrieveMoviesByGenre( String genre )
    {
        ResultSet rs;
        LinkedList<Movie> movies;
        Connection conn = DbAccessImpl.connect();
        String query = "SELECT movies.id, name, year, rank  FROM movies\n" 
                       +     "JOIN movies_genres ON movies.id = movies_genres.movie_id\n"
                       +     "WHERE genre = '" + genre +"'";
        rs = DbAccessImpl.retrieve( conn, query );
        movies = new LinkedList<Movie>();

        try {
            while( rs.next() ) {
                int id = rs.getInt( 1 );
                String name = rs.getString(2);
                int year = rs.getInt(3);
                float rank = rs.getFloat(4);

                Movie movie = new Movie( id, name, year, rank);
                movies.add( movie );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        DbAccessImpl.disconnect(conn);
        return movies;
    }
    
    public static LinkedList<Movie> retrieveMovies()
    {
        ResultSet           rs;
        LinkedList<Movie>   movies = new LinkedList<Movie>();
        int                 id;
        String              name;
        int                 year;
        float               rank;
        
        Connection conn = DbAccessImpl.connect();
        String query = "SELECT id, name, year, rank  FROM movies";

        rs = DbAccessImpl.retrieve( conn, query );

        try {
            while( rs.next() ) {
                id = rs.getInt( 1 );
                name = rs.getString(2);
                year = rs.getInt(3);
                rank = rs.getFloat(4);

                Movie movie = new Movie( id, name, year, rank);
                movies.add( movie );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        
        DbAccessImpl.disconnect(conn);
        return movies;
    }
    public static Movie retrieveMovieByTitle( String title )
    {
        ResultSet           rs;
        Movie               movie = null;
        int                 id;
        String              name;
        int                 year;
        float               rank;
        
        Connection conn = DbAccessImpl.connect();
        String query = "SELECT id, name, year, rank  FROM movies\n"
                        +   "WHERE name = '" + title + "'";

        rs = DbAccessImpl.retrieve( conn, query );
        System.out.println("++" + title + "++");
        try {
                if( rs.next() ) { 
                    id = rs.getInt( 1 );
                    name = rs.getString(2);
                    year = rs.getInt(3);
                    rank = rs.getFloat(4);

                    movie = new Movie( id, name, year, rank);
                }
                else
                    System.out.println("MoviePersistImpl.retrieveMovieByTitle: No movie was retrieved");
            
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        
        DbAccessImpl.disconnect(conn);
        return movie;
    }
    public static LinkedList<Review> retrieveReviewsByMovie( Movie movie )
    {
        ResultSet           rs;
        LinkedList<Review>  reviews = new LinkedList<>();
        int                 id;
        String              reviewString;
        Review              review;
        
        Connection conn = DbAccessImpl.connect();
        String query = "SELECT reviews.id, review FROM reviews\n"
                        +   "JOIN movies ON movies.id = movie_id\n"
                        +   "WHERE movies.id = " + movie.getId();

        rs = DbAccessImpl.retrieve( conn, query );
        
        try {
            while( rs.next() ) {
                // get values from result set
                id = rs.getInt( 1 );
                reviewString = rs.getString( 2 );
 
                // make review with values
                review = new Review();
                review.setId( id );
                review.setReview( reviewString );
                
                reviews.add( review );
            }
        } catch ( SQLException e)
        {
            e.printStackTrace();
        }
        
        DbAccessImpl.disconnect(conn);
        return reviews;
    }
    public static int storeMovie( Movie movie )
    {
        Connection conn = DbAccessImpl.connect();
        
        String title    = movie.getName();
        int year        = movie.getYear();
        float rank      = movie.getRank();
        
        String query = "INSERT INTO movies ( name, year, rank )"
                        +   " VALUES ( '" + title + "', " + year + ", " + rank + " )";
        
        int rowCount = DbAccessImpl.create( conn, query );
        
        DbAccessImpl.disconnect( conn );
        return rowCount;
    }
    public static int storeReview( Movie movie, String review )
    {
        Connection conn = DbAccessImpl.connect();
        int id = movie.getId();
        String query = "INSERT INTO reviews ( movie_id, review )" + "\n"
                        +   "VALUES ( " + id + ", '" + review + "' )";
        int rowCount = DbAccessImpl.create( conn, query );
        
        DbAccessImpl.disconnect( conn );
        return rowCount;
    }
    public static int deleteMovie( Movie movie )
    {
        Connection conn = DbAccessImpl.connect();
        int id = movie.getId();
        
        String query =  "DELETE" + "\n" +
                        "FROM movies" + "\n" +
                        "WHERE id = " + id;
        
        int rowCount = DbAccessImpl.delete( conn, query );
        
        DbAccessImpl.disconnect( conn );
        return rowCount;                
    }
    public static Review retrieveReviewById( int _id )
    {
        ResultSet           rs;
        Review              review = null;
        int                 id;
        int                 movieId;
        String              reviewString;
        
        Connection conn = DbAccessImpl.connect();
        String query = "SELECT id, movie_id, review\n"
                        +   "FROM reviews\n"
                        +   "WHERE id = " + _id;

        rs = DbAccessImpl.retrieve( conn, query );

        try {
                if( rs.next() ) { 
                    // get values from result set
                    id = rs.getInt( 1 );
                    movieId = rs.getInt(2);
                    reviewString = rs.getString(3);                   

                    review = new Review( id, movieId, reviewString );
                }
            
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        
        DbAccessImpl.disconnect(conn);
        return review;
    }
    public static int deleteReview( Review review )
    {
        Connection conn = DbAccessImpl.connect();
        int id = review.getId();
        
        String query =  "DELETE" + "\n" +
                        "FROM reviews" + "\n" +
                        "WHERE id = " + id;
        
        int rowCount = DbAccessImpl.delete( conn, query );
        
        DbAccessImpl.disconnect( conn );
        return rowCount;
    }
}
