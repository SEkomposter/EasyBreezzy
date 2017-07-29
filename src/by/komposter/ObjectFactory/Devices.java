package by.komposter.ObjectFactory;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "devices")
public class Devices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "regnum")
    int regnum;

    //link "devices-nodes"
    @ManyToOne
    @JoinColumn(name = "idnode")
    private Node node;

    //link "devices-transactions"
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    Set<Transaction> transactionSet = new LinkedHashSet<Transaction>();

    //link "devices-host"
    @OneToOne(mappedBy = "device")
    private Host host;

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
    @Column(name = "sn")
    String serialNumber;
    @Column(name = "pn")
    String partNumber;

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

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Set<Transaction> getTransactionSet() {
        return transactionSet;
    }

    public void setTransactionSet(Set<Transaction> transactionSet) {
        this.transactionSet = transactionSet;
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
