package by.komposter.ObjectFactory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table (name = "cpu")
public class Cpu {
    public Cpu(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcpu")
    int idCpu;

    //link:"cpu-host"
    @OneToMany (cascade = CascadeType.ALL)
    List<Host> hostList = new LinkedList<>();

    String model;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public List<Host> getHostList() {
        return hostList;
    }

    public void setHostList(List<Host> hostList) {
        this.hostList = hostList;
    }
}
