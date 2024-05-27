package nextdevs.esercizio.repository;


import nextdevs.esercizio.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendeteRepository extends JpaRepository<Dipendente, Integer> {
    public Optional<Dipendente> findByEmail(String email);
}
