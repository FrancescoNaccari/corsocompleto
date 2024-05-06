package entity.mezzi;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mezzi")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Mezzo {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "in_servizio")
    private Boolean inServizio;

    private int capienza;

    @OneToMany(mappedBy = "mezzo")
    private List<Viaggio> viaggi;


    @OneToMany(mappedBy = "mezzo")
    private List<Manutenzione> manutenzioni;
}
