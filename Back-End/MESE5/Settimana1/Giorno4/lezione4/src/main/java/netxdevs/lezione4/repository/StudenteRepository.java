package netxdevs.lezione4.repository;

import netxdevs.lezione4.bean.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudenteRepository extends JpaRepository<Studente,Integer> {
    public List<Studente> findByNome(String nome);

    public List<Studente> findByNomeLike(String nome);

}
