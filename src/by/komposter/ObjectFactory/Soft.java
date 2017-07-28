package by.komposter.ObjectFactory;

import java.util.Date;

public  class Soft{
    int idHostSoft, idAdmin;
    String softName, version, revision, lictype, licDateInst;
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
