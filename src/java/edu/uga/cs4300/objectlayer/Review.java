
package edu.uga.cs4300.objectlayer;

public class Review {
    
    private int id;
    private int movieId;
    private String review;
    
    public Review() {
        id = 0;
        movieId = 0;
        review = "";
    }
    public Review( int _movieId, String _review ) {
        id = 0;
        movieId = _movieId;
        review = _review;
    }
    public Review( int _id, int _movieId, String _review ) {
        id = _id;
        movieId = _movieId;
        review = _review;
    }
    
    public void setId ( int _id ) {
        id = _id;
    }
    public int getId () {
        return id;
    }
    public void setMovieId ( int _movieId ) {
        movieId = _movieId;
    }
    public int getMovieId () {
        return movieId;
    }
    public void setReview ( String _review ) {
        review = _review;
    }
    public String getReview () {
        return review;
    }
}
