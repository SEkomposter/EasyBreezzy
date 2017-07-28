package by.komposter.ObjectFactory;

import javax.persistence.*;

@Entity
@Table(name = "hdd")
public class Hdd {
    public Hdd(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idhdd")
    int idHdd;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "idmodel")
    Models models;
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
}
