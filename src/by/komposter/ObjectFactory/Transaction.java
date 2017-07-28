package by.komposter.ObjectFactory;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idtransaction")
    int idTransaction;
    @Column(name = "regnum")
    int regnum;
    @Column(name = "idNodeFrom")
    int idNodeFrom;
    @Column(name = "idNodeto")
    int idNodeTo;
    @Column(name = "idadmin")
    int idAdmin;
    @Column(name = "reason")
    String reason;
    @Column(name = "transactionDate")
    String transactionDate;
    Date date;

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int  getRegnum() {
        return regnum;
    }

    public void setRegnum(int regnum) {
        this.regnum = regnum;
    }

    public int getIdNodeFrom() {
        return idNodeFrom;
    }

    public void setIdNodeFrom(int idNodeFrom) {
        this.idNodeFrom = idNodeFrom;
    }

    public int getIdNodeTo() {
        return idNodeTo;
    }

    public void setIdNodeTo(int idNodeTo) {
        this.idNodeTo = idNodeTo;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String idReason) {
        this.reason = reason;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTimestamp() {
        date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        this.transactionDate = sdf.format(date);
    }
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
