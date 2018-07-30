package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "gpu")
public class Gpu extends Part{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gpu_id")
    private int id;

    //link:"gpu-host"
    //@ManyToMany (cascade = CascadeType.ALL)@JoinTable(name = "host_gpu", joinColumns = @JoinColumn(name = "host_id"),inverseJoinColumns = @JoinColumn(name = "gpu_id"))
   // private List<Host> listHosts = new LinkedList<>();

    @Column(name = "model")
    private String model;
    @Column(name = "frequency")
    private int freq;
    @Column(name = "memcapacity")
    private int memCapacity;
    @Column(name = "memtype")
    private String memType;
    @Column(name = "vendor")
    private String vendor;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
/*
    public List<Host> getListHosts() {
        return listHosts;
    }

    public void setListHosts(List<Host> listHosts) {
        this.listHosts = listHosts;
    }
    */

    public void setModel(String model) {
        this.model = model;
    }
}
