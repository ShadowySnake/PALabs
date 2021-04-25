package optionalPackage.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PEOPLE", schema = "STUDENT", catalog = "")
public class People {
    private long id;
    private String name;
    private String job;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "JOB")
    public String getJob(){
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People that = (People) o;
        return id == that.id &&
                Objects.equals(job, that.job) &&
                Objects.equals(name, that.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, job);
    }
}
