package base.apptrailers.mobile.globant.com.moviesapp.model;

/**
 * Created by raul.striglio on 02/09/16.
 */
public class Movie implements Entity {

    private String name;
    private String gender;
    private int year;
    private String director;
    private long id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
