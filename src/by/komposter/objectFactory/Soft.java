package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "soft")
public  class Soft{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hostsoft_id")
    private int id;

    //link:"soft-host"
    @ManyToMany (cascade = CascadeType.ALL)@JoinTable(name = "host_soft", joinColumns = @JoinColumn(name = "host_id"),inverseJoinColumns = @JoinColumn(name = "hostsoft_id"))
    private List<Host> listHosts = new LinkedList<>();

    @Column(name = "softname")
    private String softName;
    @Column(name = "version")
    private String version;
    @Column(name = "revision")
    private String revision;
    @Column(name = "licdateinst")
    private String licDateInst;
    @Column(name = "licterm")
    private String licTerm;
    @Column(name = "idadmin")
    private int idAdmin;
    @Column(name = "lictype")
    private String lictype;
    private Date date;


    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getLictype() {
        return lictype;
    }

    public void setLictype(String lictype) {
        this.lictype = lictype;
    }

    public String getSoftName() {
        return softName;
    }

    public void setSoftName(String softName) {
        this.softName = softName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getLicDateInst() {
        return licDateInst;
    }

    public void setLicDateInst(String licDateInst) {
        this.licDateInst = licDateInst;
    }

    public int getId() {
        return id;
    }

    public List<Host> getListHosts() {
        return listHosts;
    }

    public void setListHosts(List<Host> listHosts) {
        this.listHosts = listHosts;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLicTerm() {
        return licTerm;
    }

    public void setLicTerm(String licTerm) {
        this.licTerm = licTerm;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

}
