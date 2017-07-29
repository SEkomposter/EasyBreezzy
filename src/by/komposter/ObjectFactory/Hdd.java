package by.komposter.ObjectFactory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "hdd")
public class Hdd {
    public Hdd(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idhdd")
    int idHdd;

    //link:"hdd-host"
    @OneToMany (cascade = CascadeType.ALL)
    List<Host> hostList = new LinkedList<>();

    @Column(name = "vendor")
    String vendor;
    String model;
    int capacity,rpm;

    public String getModel() {
        return model;
    }

    public void setModel(int idModel) {
        this.model = model;
    }

    public int getIdHdd() {
        return idHdd;
    }

    public void setIdHdd(int idHdd) {
        this.idHdd = idHdd;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public List<Host> getHostList() {
        return hostList;
    }

    public void setHostList(List<Host> hostList) {
        this.hostList = hostList;
    }
}
