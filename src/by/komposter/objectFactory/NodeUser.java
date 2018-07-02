package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "nodeuser")
public class NodeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nodeuser_id")
    private int id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;

    //link: "nodeuser-node"
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "nodeUser")
    private Set<Node> setNodes = new LinkedHashSet<Node>();


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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Node> getSetNodes() {
        return setNodes;
    }

    public void setSetNodes(Set<Node> setNodes) {
        this.setNodes = setNodes;
    }

}
