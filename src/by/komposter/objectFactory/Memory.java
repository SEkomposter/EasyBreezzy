package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "memory")
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memory_id")
    int id;

    //link:"memory-host"
    @ManyToMany (cascade = CascadeType.ALL)@JoinTable(name = "memory_host", joinColumns = @JoinColumn(name = "host_id"),inverseJoinColumns = @JoinColumn(name = "memory_id"))
    private List<Host> listHosts = new LinkedList<>();

    @Column(name = "model")
    String model;

    @Column(name = "memcapacity")
    int memCapacity;
    @Column(name = "frequency")
    int freq;
    @Column(name = "type")
    String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Host> getListHosts() {
        return listHosts;
    }

    public void setListHosts(List<Host> listHosts) {
        this.listHosts = listHosts;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemCapacity() {
        return memCapacity;
    }

    public void setMemCapacity(int memCapacity) {
        this.memCapacity = memCapacity;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
