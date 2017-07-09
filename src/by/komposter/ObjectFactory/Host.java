package by.komposter.ObjectFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Host {
    int idHost, regnum, idDomain, idMemory, idHdd, idGpu, idHostSoft, screen;
    String hostName, domainName;

    public int getIdHost() {
        return idHost;
    }

    public int getRegnum() {
        return regnum;
    }

    public int getIdDomain() {
        return idDomain;
    }

    public int getIdMemory() {
        return idMemory;
    }

    public int getIdHdd() {
        return idHdd;
    }

    public int getIdGpu() {
        return idGpu;
    }

    public int getIdHostSoft() {
        return idHostSoft;
    }

    public int getScreen() {
        return screen;
    }

    public String getHostName() {
        return hostName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setIdHost(int idHost) {
        this.idHost = idHost;
    }


    class Cpu {
        int idCpu, idModel, freq, coresNum, cache3lvl;

        public int getIdCpu() {
            return idCpu;
        }

        public void setIdCpu(int idCpu) {
            this.idCpu = idCpu;
        }

        public int getIdModel() {
            return idModel;
        }

        public void setIdModel(int idModel) {
            this.idModel = idModel;
        }

        public int getCoresNum() {
            return coresNum;
        }

        public void setCoresNum(int coresNum) {
            this.coresNum = coresNum;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public int getCache3lvl() {
            return cache3lvl;
        }

        public void setCache3lvl(int cache3lvl) {
            this.cache3lvl = cache3lvl;
        }
    }


    class Gpu {
        int idGpu, idModel, freq, coresNum, cache3lvl;

        public int getIdGpu() {
            return idGpu;
        }

        public void setIdGpu(int idGpu) {
            this.idGpu = idGpu;
        }

        public int getIdModel() {
            return idModel;
        }

        public void setIdModel(int idModel) {
            this.idModel = idModel;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public int getCoresNum() {
            return coresNum;
        }

        public void setCoresNum(int coresNum) {
            this.coresNum = coresNum;
        }

        public int getCache3lvl() {
            return cache3lvl;
        }

        public void setCache3lvl(int cache3lvl) {
            this.cache3lvl = cache3lvl;
        }
    }


    class Memory {
        int idMemory, idModel, memCapacity, freq;
        String type;

        public int getIdMemory() {
            return idMemory;
        }

        public void setIdMemory(int idMemory) {
            this.idMemory = idMemory;
        }

        public int getIdModel() {
            return idModel;
        }

        public void setIdModel(int idModel) {
            this.idModel = idModel;
        }

        public int getMemCapacity() {
            return memCapacity;
        }

        public void setMemCapacity(int memCapacity) {
            this.memCapacity = memCapacity;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }


    class Hdd {
        int idHdd, idModel,capacity,rpm;

        public int getIdModel() {
            return idModel;
        }

        public void setIdModel(int idModel) {
            this.idModel = idModel;
        }

        public int getIdHdd() {
            return idHdd;
        }

        public void setIdHdd(int idHdd) {
            this.idHdd = idHdd;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public int getRpm() {
            return rpm;
        }

        public void setRpm(int rpm) {
            this.rpm = rpm;
        }
    }


    class Soft{
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
}

