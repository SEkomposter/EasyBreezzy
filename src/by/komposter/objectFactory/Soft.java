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
    @Column(name = "idhostsoft")
    int idHostSoft;

    //link:"soft-host"
    @ManyToMany (cascade = CascadeType.ALL)@JoinTable(name = "host_soft", joinColumns = @JoinColumn(name = "idHostSoft"),inverseJoinColumns = @JoinColumn(name = "idhostsoft"))
    List<Host> hostList = new LinkedList<>();

    @Column(name = "softname")
    String softName;
    @Column(name = "version")
    String version;
    @Column(name = "revision")
    String revision;
    @Column(name = "licdateinst")
    String licDateInst;
    @Column(name = "licterm")
    String licTerm;
    @Column(name = "idadmin")
    int idAdmin;
    @Column(name = "lictype")
    String lictype;
    Date date;

    public int getIdHostSoft() {
        return idHostSoft;
    }

    public void setIdHostSoft(int idHostSoft) {
        this.idHostSoft = idHostSoft;
    }

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
}
