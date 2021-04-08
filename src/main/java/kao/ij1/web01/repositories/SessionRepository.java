package kao.ij1.web01.repositories;

import kao.ij1.web01.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
