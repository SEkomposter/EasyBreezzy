package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "node")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "idnode")
    int idNode;

    //link: "node-nodeuser"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idnodeuser")
    private NodeUser nodeUser;

    //link: "node-devices"
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "node")
    private Set<Devices> device = new LinkedHashSet<Devices>();

    //link: "node-host"
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "node")
    Set<Host> hostSet = new LinkedHashSet<Host>();

    //link: "node-transaction (nodeto)"
    @OneToOne (mappedBy = "nodeTo")
    Transaction transactionTo;

    //link: "node-transaction (nodefrom)"
    @OneToOne (mappedBy = "nodeFrom")
    Transaction transactionFrom;

    @Column(name = "nodeName")
    String nodeName;
    //@Column(name = "idnodeuser")

    @Column(name = "idHost",nullable = false)
    int idHost;
    @Column(name = "Sbe")
    String Sbe;
    @Column(name = "department")
    String department;
    @Column(name = "location")
    String location;
    //int idNodeUser;

    public int getIdNode() {
        return idNode;
    }

    public void setIdNode(int idNode) {
        this.idNode = idNode;
    }

   // public int getIdNodeUser() {
     //   return idNodeUser;
    //}

//    public void setIdNodeUser(int idNodeUser) {
        //this.idNodeUser = idNodeUser;
   // }


    public Set<Host> getHostSet() {
        return hostSet;
    }

    public void setHostSet(Set<Host> hostSet) {
        this.hostSet = hostSet;
    }

    public int getIdHost() {
        return idHost;
    }

    public void setIdHost(int idHost) {
        this.idHost = idHost;
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
}
