package kao.ij1.web01.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name="sessions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long session_id;
    private String session_name;
    private String session_description;
    private Integer session_length;

    @ManyToMany
    @JoinTable(
            name = "session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers;


    public Session(){
    }

    public List<Speaker> getSpeakers() {
        System.out.println("===071===Session.java===List<Speaker> getSpeakers()====save " );
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        System.out.println("===071===Session.java===setSpeakers(List<Speaker> speakers)==== " );
        this.speakers = speakers;
    }

    public Long getSession_id() {
        System.out.println("===071===Session.java===Long getSession_id() ==== " );
        return session_id;
    }

    public void setSession_id(Long session_id) {
        System.out.println("===071===Session.java===setSession_id(Long session_id) ==== " );
        this.session_id = session_id;
    }

    public String getSession_name() {
        System.out.println("===071===Session.java===String getSession_name() ==== " );
        return session_name;
    }

    public void setSession_name(String session_name) {
        System.out.println("===071===Session.java===setSession_name(String session_name) ==== " );
        this.session_name = session_name;
    }

    public String getSession_description() {
        System.out.println("===071===Session.java===String getSession_description() ==== " );
        return session_description;
    }

    public void setSession_description(String session_description) {
        System.out.println("===071===Session.java===setSession_description(String session_description) ==== " );
        this.session_description = session_description;
    }

    public Integer getSession_length() {
        System.out.println("===071===Session.java===Integer getSession_length() ==== " );
        return session_length;
    }

    public void setSession_length(Integer session_length) {
        System.out.println("===071===Session.java===setSession_length(Integer session_length) ==== " );
        this.session_length = session_length;
    }
}
