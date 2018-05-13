package mining.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Example {

    @Id
    private int id;
    private long from;
    private long to;

    public Example(int id, long from, long to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }

    public long getTo() {
        return to;
    }

    public void setTo(long to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
