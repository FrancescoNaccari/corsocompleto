package nextdevs.esercizio.repository;


import nextdevs.esercizio.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {
}
