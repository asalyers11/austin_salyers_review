
package edu.uga.cs4300.objectlayer;


public class Movie {
    
    private int id;
    private String name;
    private int year;
    private float rank;
    
    public Movie() {
        
        id = 0;
        name = "";
        year = 0;
        rank = 0;
    }
    public Movie( String _name , int _year, float _rank )
    {
        id = 0;
        name = _name;
        year = _year;
        rank = _rank;
    }
    public Movie( int _id, String _name , int _year, float _rank )
    {
        id = _id;
        name = _name;
        year = _year;
        rank = _rank;
    }
    
    public void setId ( int _id ) {
        id = _id;
    }
    public int getId () {
        return id;
    }
    public void setName( String _name) {
        name = _name;
    }
    public String getName () {
        return name;
    }
    public void setYear ( int _year ) {
        year = _year;
    }
    public int getYear () {
        return year;
    }
    public void setRank ( float _rank ) {
        rank = _rank;
    }
    public float getRank () {
        return rank;
    }
}
