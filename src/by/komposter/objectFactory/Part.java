package by.komposter.objectFactory;


import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity
    @Table(name = "parts")
    public class Part{
        public Part(){}
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "part_id")
        private int id;

        //link:"part-host"
         @ManyToMany (cascade = CascadeType.ALL)@JoinTable(name = "host_part", joinColumns = @JoinColumn(name = "part_id"),inverseJoinColumns = @JoinColumn(name = "part_id"))
         private List<Host> listHosts = new LinkedList<>();

        @Column(name = "type")
        private String type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    public List<Host> getListHosts() {
        return listHosts;
    }

    public void setListHosts(List<Host> listHosts) {
        this.listHosts = listHosts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
