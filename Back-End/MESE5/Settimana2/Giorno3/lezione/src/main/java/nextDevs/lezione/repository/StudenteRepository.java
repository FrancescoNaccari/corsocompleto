package nextDevs.lezione.repository;

import nextDevs.lezione.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {
}
