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
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "idmodel")
    Models models;
    int idModel;
    @Column(name = "frequency")
    int frequency;
    @Column(name = "coresNum")
    int coresNum;
    @Column(name = "cashe3lvl")
    int cache3lvl;
    @Column(name = "vendor")
    int vendor;

    public int getIdCpu() {
        return idCpu;
    }

    public void setIdCpu(int idCpu) {
        this.idCpu = idCpu;
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public int getCoresNum() {
        return coresNum;
    }

    public void setCoresNum(int coresNum) {
        this.coresNum = coresNum;
    }

    public int getFreq() {
        return frequency;
    }

    public void setFreq(int frequency) {
        this.frequency = frequency;
    }

    public int getCache3lvl() {
        return cache3lvl;
    }

    public void setCache3lvl(int cache3lvl) {this.cache3lvl = cache3lvl;}

    public int getVendor() {
        return vendor;
    }

    public void setVendor(int vendor) {
        this.vendor = vendor;
    }
}
