package by.komposter.ObjectFactory;

import javax.persistence.*;

@Entity
@Table(name = "node")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idnode")
    int idNode;
    @Column(name = "nodeName")
    String nodeName;
    @Column(name = "idnodeuser")
    int idNodeUser;
    @Column(name = "idhost")
    int idHost;
    @Column(name = "Sbe")
    String Sbe;
    @Column(name = "department")
    String department;
    @Column(name = "location")
    String location;

    public int getIdNode() {
        return idNode;
    }

    public void setIdNode(int idNode) {
        this.idNode = idNode;
    }

    public int getIdNodeUser() {
        return idNodeUser;
    }

    public void setIdNodeUser(int idNodeUser) {
        this.idNodeUser = idNodeUser;
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
