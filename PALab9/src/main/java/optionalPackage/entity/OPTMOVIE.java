package optionalPackage.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "OPTMOVIE", schema = "STUDENT", catalog = "")
public class OPTMOVIE {
    private long id;
    private String title;
    private Date releaseDate;
    private long score;
    private long duration;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    @Basic
    @Column(name = "RELEASE_DATE")
    public Date getReleaseDate(){
        return releaseDate;
    }

    public void setReleaseDate(Date date){
        this.releaseDate = date;
    }

    @Basic
    @Column(name = "DURATION")
    public long getDuration(){
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "SCORE")
    public long getScore(){
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OPTMOVIE that = (OPTMOVIE) o;
        return id == that.id &&
                duration == that.duration &&
                score == that.score &&
                releaseDate == that.releaseDate &&
                Objects.equals(title, that.title);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseDate, duration, score);
    }
}
