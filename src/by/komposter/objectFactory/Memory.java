package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "memory")
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idmemory")
    int idMemory;

    //link:"cpu-host"
    @OneToMany (cascade = CascadeType.ALL,mappedBy = "memory")
    List<Host> hostList = new LinkedList<>();

    @Column(name = "model")
    String model;

    @Column(name = "memcapacity")
    int memCapacity;
    @Column(name = "frequency")
    int freq;
    @Column(name = "type")
    String type;

    public int getIdMemory() {
        return idMemory;
    }

    public void setIdMemory(int idMemory) {
        this.idMemory = idMemory;
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
