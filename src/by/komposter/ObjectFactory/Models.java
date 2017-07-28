package by.komposter.ObjectFactory;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "models")

public class Models implements Serializable{
    public Models(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idmodel")
    int idModel;
    @OneToOne (mappedBy = "models")
    Cpu cpu;
    @OneToOne (mappedBy = "models")
    Hdd hdd;

    @Column(name="model",unique = true, nullable = false, length = 45)
    String model;
    @Column(name="vendor",unique = true, nullable = false, length = 45)
    String vendor;
   //@JoinTable(name = "CATALOG", joinColumns = @JoinColumn(name = "ID_BOOK"), inverseJoinColumns = @JoinColumn(name = "ID_STUDENT"))


    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
