package by.komposter.ObjectFactory;

import javax.persistence.*;

@Entity
@Table (name = "cpu")
public class Cpu {
    public Cpu(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcpu")
    int idCpu;
    @Column(name = "idmodel")
    @OneToOne (mappedBy = "cpu")
    Models models;
    int idModel;
    @Column(name = "frequency")
    int frequency;
    @Column(name = "coresNum")
    int coresNum;
    @Column(name = "cashe3lvl")
    int cache3lvl;
}
