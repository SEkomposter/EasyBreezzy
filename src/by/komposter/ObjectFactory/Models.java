package by.komposter.ObjectFactory;

import javax.persistence.*;

@Entity
@Table (name = "models")

public class Models {
    @Id
            @Column(name = "idmodel")
    int idModel;
    @Column(name="model",unique = true, nullable = false, length = 45)
    String model;
    @Column(name="vendor",unique = true, nullable = false, length = 45)
    String vendor;
    @JoinTable(name = "CATALOG", joinColumns = @JoinColumn(name = "ID_BOOK"), inverseJoinColumns = @JoinColumn(name = "ID_STUDENT"))
    private Student student;

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
