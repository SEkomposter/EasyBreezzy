package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "devices")
public class Devices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "regnum")
    private int regnum;

    //link "devices-node"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "node_id")
    private Node node;

    //link "devices-transactions"
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    private Set<Transaction> setTransaction = new LinkedHashSet<Transaction>();

    //link "devices-host"
    @OneToOne(mappedBy = "device")
    private Host host;

    @Column(name = "invnum")
    private String invNum;
    @Column(name = "devicetype")
    private String deviceType;

    @Column(name = "state")
    private String state;
    @Column(name = "description")
    private String description;
    @Column(name = "model")
    private String model;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "sn")
    private String serialNumber;
    @Column(name = "pn")
    private String partNumber;

    public void setRegnum(int regnum) {
        this.regnum = regnum;
    }

    public int getRegnum() {
        return regnum;
    }

    public String  getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
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

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Set<Transaction> getSetTransaction() {
        return setTransaction;
    }

    public void setSetTransaction(Set<Transaction> setTransaction) {
        this.setTransaction = setTransaction;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }
}
