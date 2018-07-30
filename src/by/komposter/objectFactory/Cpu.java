package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table (name = "cpu")
public class Cpu extends Part{
    public Cpu(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cpu_id")
    private int id;

    //link:"cpu-host"
  //  @ManyToMany (cascade = CascadeType.ALL)@JoinTable(name = "host_cpu", joinColumns = @JoinColumn(name = "host_id"),inverseJoinColumns = @JoinColumn(name = "cpu_id"))
   // private List<Host> listHosts = new LinkedList<>();
    @Column(name = "model")
    private String model;
    @Column(name = "frequency")
    private int frequency;
    @Column(name = "coresNum")
    private int coresNum;
    @Column(name = "cashe3lvl")
    private int cache3lvl;
    @Column(name = "vendor")
    private int vendor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public List<Host> getListHosts() {
        return listHosts;
    }

    public void setListHosts(List<Host> listHosts) {
        this.listHosts = listHosts;
    }*/

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
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

}
