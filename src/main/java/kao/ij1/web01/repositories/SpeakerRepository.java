package kao.ij1.web01.repositories;

import kao.ij1.web01.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository  extends JpaRepository<Speaker, Long> {
}
