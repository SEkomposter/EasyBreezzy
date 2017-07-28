package by.komposter.ObjectFactory;

import javax.persistence.*;

@Entity
@Table(name = "devices")
public class Devices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "regnum")
    int regnum;
    @Column(name = "invnum")
    String invNum;
    @Column(name = "devicetype")
    String deviceType;
    @Column(name = "idnode")
    int idNode;
    @Column(name = "state")
    String state;
    @Column(name = "description")
    String description;
    @Column(name = "model")
    String model;
    @Column(name = "vendor")
    String vendor;

    public int getRegnum() {
        return regnum;
    }

    public void setRegnum(int regnum) {
        this.regnum = regnum;
    }

    public String  getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public int getIdNode() {
        return idNode;
    }

    public void setIdNode(int idNode) {
        this.idNode = idNode;
    }

    public String getInvNum() {
        return invNum;
    }

    public void setInvNum(String invNum) {
        this.invNum = invNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
