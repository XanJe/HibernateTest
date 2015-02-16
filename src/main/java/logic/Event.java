package logic;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Eventz")
@javax.persistence.SequenceGenerator( // define a generator
        name="SEQ_STORE",
        sequenceName="my_sequence"
)
public class Event {
    @Id
    @Column(name="Event_id")
    @GeneratedValue(strategy= GenerationType.AUTO, generator="SEQ_STORE") // identity, sequence
    private Long id;

    @Column(name="titulum",nullable=false,length=50,updatable=false)
    private String title;

    private Date date;

    @Transient  // doesn't store this field
    private String titleAllCaps;

    // this object is embedded in Event object while ORM'd
    @Embedded
/*    @AttributeOverrides({
            @AttributeOverride(name="evnt_pl_addr", column = @Column(name="event_PA")),
            @AttributeOverride(name="evnt_star_addr", column = @Column(name="event_SA"))})*/
    PlanetAddress planetAddress;

    public Event() {}

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }
    public String getTitleAllCaps(){
        return title.toUpperCase();
    }
    public void setTitleAllCaps(String s){
        // do nothing
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
