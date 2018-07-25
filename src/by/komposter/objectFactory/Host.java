package by.komposter.objectFactory;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "host")
public class Host extends Item implements Serializable {
    public Host(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "host_id")
    private int id;

    //link: "host-node"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "node_id")
    private Node node;

    //link: "host-devices"
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regnum")
    private Devices device;

    //link: "host-cpu"
    @ManyToMany(mappedBy = "listHosts")
    private List<Cpu> listCpu;

    //link: "host-memory"
    @ManyToMany(mappedBy = "listHosts")
    private List<Memory> listMemory;

    //link: "host-gpu"
    @ManyToMany(mappedBy = "listHosts")
    private List<Gpu> listGpu;

    //link: "host-hdd"
    @ManyToMany(mappedBy = "listHosts")
    private List<Hdd> listHdd;

    //link: "host-soft"
    @ManyToMany(mappedBy = "listHosts")
    private List<Soft> listSoft;

    @Column(name = "hostname")
    private String hostName;
    @Column(name = "screen")
    private int screen;
    @Column(name = "sn")
    private String serialNumber;
    @Column(name = "pn")
    private String partNumber;

    public int getId() {
        return id;
    }

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

    public List<Soft> getListSoft() {
        return listSoft;
    }

    public void setListSoft(List<Soft> listSoft) {
        this.listSoft = listSoft;
    }

    public List<Cpu> getListCpu() {
        return listCpu;
    }

    public void setListCpu(List<Cpu> listCpu) {
        this.listCpu = listCpu;
    }

    public void setListGpu(List<Gpu> listGpu) {
        this.listGpu = listGpu;
    }

    public List<Gpu> getListGpu() {
        return listGpu;
    }

    public List<Hdd> getListHdd() {
        return listHdd;
    }

    public void setListHdd(List<Hdd> listHdd) {
        this.listHdd = listHdd;
    }

    public List<Memory> getListMemory() {
        return listMemory;
    }

    public void setListMemory(List<Memory> listMemory) {
        this.listMemory = listMemory;
    }

    public Node getNode() {
        return node;
    }

}

