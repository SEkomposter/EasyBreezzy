package by.komposter.ObjectFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    int idTransaction, regnum, idNodeFrom, idNodeTo, idAdmin, idReason;
    String transactionDate;
    Date date;

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public int getRegnum() {
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

    public int getIdReason() {
        return idReason;
    }

    public void setIdReason(int idReason) {
        this.idReason = idReason;
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
