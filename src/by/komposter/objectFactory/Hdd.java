package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "hdd")
public class Hdd {
    public Hdd(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hdd_id")
    private int id;

    //link:"hdd-host"
    @ManyToMany (cascade = CascadeType.ALL)@JoinTable(name = "host_hdd", joinColumns = @JoinColumn(name = "host_id"),inverseJoinColumns = @JoinColumn(name = "hdd_id"))
    private List<Host> listHosts = new LinkedList<>();

    @Column(name = "vendor")
    private String vendor;
    @Column(name = "model")
    private String model;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "rpm")
    private int rpm;

    public String getModel() {
        return model;
    }

    public void setModel(int idModel) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
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

    public List<Host> getListHosts() {
        return listHosts;
    }

    public void setListHosts(List<Host> listHosts) {
        this.listHosts = listHosts;
    }
}
