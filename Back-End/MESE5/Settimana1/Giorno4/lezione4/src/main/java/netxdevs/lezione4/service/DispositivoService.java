package netxdevs.lezione4.service;

import netxdevs.lezione4.bean.Computer;
import netxdevs.lezione4.bean.Dispositivo;
import netxdevs.lezione4.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public void inserisciDispositivo(Dispositivo dispositivo) {
        dispositivoRepository.save(dispositivo);
    }

    public Dispositivo getDispositivi(int id) {
        return dispositivoRepository.findById(id).get();
    }


    public List<Dispositivo> getDispositivi(){
        return dispositivoRepository.findAll();
    }

    public void cancellaDispositivo(int id){
        dispositivoRepository.deleteById(id);
    }

    public List<Computer> getComputerByRamLessThan(int ram){
        return dispositivoRepository.findByRamLessThan(ram);
    }

    public List<Dispositivo> getDispositiviOrderByNomeDesc(){
        return dispositivoRepository.findAllOrderByNomeDesc();
    }

}
