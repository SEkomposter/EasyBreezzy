package by.komposter.objectFactory;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "host")
public class Host implements Serializable {
    public Host(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "idHost")
    int id;
    //link: "host-node"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHost")
    private Node node;

    //link: "host-devices"
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regnum")
    private Devices device;



    //link: "host-cpu"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "idcpu")
    private Cpu cpu;

    //link: "host-memory"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "idmemory")
    private Memory memory;

    //link: "host-gpu"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "idgpu")
    private Gpu gpu;

    //link: "host-hdd"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "idhdd")
    private Hdd hdd;

    //link: "host-soft"
    @ManyToMany(mappedBy = "hostList")
    private List<Soft> soft;

    @Column(name = "hostname")
    String hostName;
    //@Column(name = "idcpu")

    //@Column(name = "idmemory")

    //@Column(name = "idhdd")

    //@Column(name = "idgpu")

   //@Column(name = "idhostsoft")
    //int idHostSoft;
    @Column(name = "screen")
    int screen;
    @Column(name = "sn")
    String serialNumber;
    @Column(name = "pn")
    String partNumber;

    public int getId() {
        return id;
    }

    //public int getRegnum() {
    //    return regnum;
   // }


    public int getScreen() {
        return screen;
    }

    public String getHostName() {
        return hostName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setNode(Node node) {
        this.node = node;
    }

//public void setRegnum(int regnum) {
     //   this.regnum = regnum;
    //}

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public Devices getDevice() {
        return device;
    }

    public void setDevice(Devices device) {
        this.device = device;
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

