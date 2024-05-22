package nextDevs.esercizio.repository;

import nextDevs.esercizio.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreRepository extends JpaRepository<Autore, Integer> {
}
