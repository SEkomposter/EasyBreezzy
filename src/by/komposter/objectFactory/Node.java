package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "node")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "node_id")
    private int id;

    //link: "node-nodeuser"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nodeuser_id")
    private NodeUser nodeUser;

    //link: "node-devices"
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "node")
    private Set<Devices> setDevices = new LinkedHashSet<Devices>();

    //link: "node-host"
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "node")
    private Set<Host> setHosts = new LinkedHashSet<Host>();

    //link: "node-transaction (nodeto)"
    @OneToMany (cascade = CascadeType.ALL,mappedBy = "nodeTo")
    private List<Transaction> listTransactionTo;

    //link: "node-transaction (nodefrom)"
    @OneToMany (cascade = CascadeType.ALL,mappedBy = "nodeFrom")
    private List<Transaction> listTransactionFrom;

    @Column(name = "nodeName")
    private String nodeName;
    @Column(name = "Sbe")
    private String Sbe;
    @Column(name = "department")
    private String department;
    @Column(name = "location")
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdSbe() {
        return Sbe;
    }

    public void setIdSbe(String Sbe) {
        this.Sbe = Sbe;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String  department) {
        this.department = department;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSbe() {
        return Sbe;
    }

    public void setSbe(String sbe) {
        Sbe = sbe;
    }

    public Set<Devices> getSetDevices() {
        return setDevices;
    }

    public void setSetDevices(Set<Devices> setDevices) {
        this.setDevices = setDevices;
    }

    public Set<Host> getSetHosts() {
        return setHosts;
    }

    public void setSetHosts(Set<Host> setHosts) {
        this.setHosts = setHosts;
    }

    public List<Transaction> getListTransactionFrom() {
        return listTransactionFrom;
    }

    public void setListTransactionFrom(List<Transaction> listTransactionFrom) {
        this.listTransactionFrom = listTransactionFrom;
    }

    public NodeUser getNodeUser() {
        return nodeUser;
    }

    public void setNodeUser(NodeUser nodeUser) {
        this.nodeUser = nodeUser;
    }

    public List<Transaction> getListTransactionTo() {
        return listTransactionTo;
    }

    public void setListTransactionTo(List<Transaction> listTransactionTo) {
        this.listTransactionTo = listTransactionTo;
    }
}
