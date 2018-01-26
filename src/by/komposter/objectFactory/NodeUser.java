package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "nodeuser")
public class NodeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idnodeuser")
    int idNodeUser;
    @Column(name = "surname")
    String surname;
    @Column(name = "name")
    String name;
    @Column(name = "otchestvo")
    String secondName;

    //link: "nodeuser-node"
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "nodeUser")
    private Set<Node> nodeSet = new LinkedHashSet<Node>();

    public int getIdNodeUser() {
        return idNodeUser;
    }

    public void setIdNodeUser(int idNodeUser) {
        this.idNodeUser = idNodeUser;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setOtchestvo(String secondName) {
        this.secondName = secondName;
    }

}
