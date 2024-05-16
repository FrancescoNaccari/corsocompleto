package netxdevs.lezione4.repository;

import netxdevs.lezione4.bean.Computer;
import netxdevs.lezione4.bean.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DispositivoRepository extends JpaRepository<Dispositivo,Integer> {
    public List<Computer> findByRamLessThan(int ram);

    @Query("select d from Dispositivo d order by d.nome desc")
    public List<Dispositivo> findAllOrderByNomeDesc();
}
