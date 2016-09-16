package base.apptrailers.mobile.globant.com.moviesapp.entity;

/**
 * Created by raul.striglio on 02/09/16.
 */
public class Movie {

    private String name;
    private String gender;
    private int year;
    private String director;
    private long id;

    public String getName() {
        return (name.isEmpty() || name == null) ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return (gender.isEmpty() || gender == null) ? "" : gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return (year > 0 ? year : 0);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return (director.isEmpty() || director == null) ? "" : director;
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
