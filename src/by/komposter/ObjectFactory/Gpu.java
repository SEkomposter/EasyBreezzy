package by.komposter.ObjectFactory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "gpu")
public class Gpu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idgpu")
    int idGpu;

    //link:"cpu-host"
    @OneToMany (cascade = CascadeType.ALL,mappedBy = "gpu")
    List<Host> hostList = new LinkedList<>();

    @Column(name = "model")
    String model;
    @Column(name = "frequency")
    int freq;
    @Column(name = "memcapacity")
    int memCapacity;
    @Column(name = "memtype")
    String memType;
    @Column(name = "vendor")
    String vendor;

    public int getIdGpu() {
        return idGpu;
    }

    public void setIdGpu(int idGpu) {
        this.idGpu = idGpu;
    }

    public String getModel() {
        return model;
    }

    public void setIdModel(String model) {
        this.model = model;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public int getMemCapacity() {
        return memCapacity;
    }

    public void setMemCapacity(int memCapacity) {
        this.memCapacity = memCapacity;
    }

    public String getMemType() {
        return memType;
    }

    public void setMemType(String memType) {
        this.memType = memType;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
