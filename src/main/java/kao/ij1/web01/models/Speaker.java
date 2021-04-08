package kao.ij1.web01.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speaker_id;
    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] speaker_photo;

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    private List<Session> sessions;

    public Speaker(){
    }

    public List<Session> getSessions() {
        System.out.println("===072===Speaker.java===List<Session> getSessions() ==== " );
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        System.out.println("===072===Speaker.java===setSessions(List<Session> sessions) ==== " );
        this.sessions = sessions;
    }

    public Long getSpeaker_id() {
        System.out.println("===072===Speaker.java===Long getSpeaker_id() ==== " );
        return speaker_id;
    }

    public void setSpeaker_id(Long speaker_id) {
        System.out.println("===072===Speaker.java===setSpeaker_id(Long speaker_id) ==== " );
        this.speaker_id = speaker_id;
    }

    public String getFirst_name() {
        System.out.println("===072===Speaker.java===String getFirst_name() ==== " );
        return first_name;
    }

    public void setFirst_name(String first_name) {
        System.out.println("===072===Speaker.java===setFirst_name(String first_name) ==== " );
        this.first_name = first_name;
    }

    public String getLast_name() {
        System.out.println("===072===Speaker.java===String getLast_name() ==== " );
        return last_name;
    }

    public void setLast_name(String last_name) {
        System.out.println("===072===Speaker.java===setLast_name(String last_name) ==== " );
        this.last_name = last_name;
    }

    public String getTitle() {
        System.out.println("===072===Speaker.java===String getTitle() ==== " );
        return title;
    }

    public void setTitle(String title) {
        System.out.println("===072===Speaker.java===setTitle(String title) ==== " );
        this.title = title;
    }

    public String getCompany() {
        System.out.println("===072===Speaker.java===String getCompany() ==== " );
        return company;
    }

    public void setCompany(String company) {
        System.out.println("===072===Speaker.java===setCompany(String company) ==== " );
        this.company = company;
    }

    public String getSpeaker_bio() {
        System.out.println("===072===Speaker.java===String getSpeaker_bio() ==== " );
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        System.out.println("===072===Speaker.java===setSpeaker_bio(String speaker_bio) ==== " );
        this.speaker_bio = speaker_bio;
    }

    public byte[] getSpeaker_photo() {
        System.out.println("===072===Speaker.java===byte[] getSpeaker_photo() ==== " );
        return speaker_photo;
    }

    public void setSpeaker_photo(byte[] speaker_photo) {
        System.out.println("===072===Speaker.java===setSpeaker_photo(byte[] speaker_photo) ==== " );
        this.speaker_photo = speaker_photo;
    }
}
