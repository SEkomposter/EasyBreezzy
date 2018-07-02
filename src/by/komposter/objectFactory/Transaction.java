package by.komposter.objectFactory;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private int id;

    //link: "transaction-devices"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regnum")
    private Devices device;

    //link: "transaction-admins"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private Admins admin;

    //link: "transaction-node (nodeto)"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nodeto_id")
    private Node nodeTo;

    //link: "transaction-node (nodefrom)"
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nodefrom_id")
    private Node nodeFrom;

    @Column(name = "reason")
    private String reason;
    @Column(name = "transactionDate")
    private String transactionDate;
    private Date date;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Admins getAdmin() {
        return admin;
    }

    public void setAdmin(Admins admin) {
        this.admin = admin;
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

    public void setTransactionDate() {
        date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        this.transactionDate = sdf.format(date);
    }
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Devices getDevice() {
        return device;
    }

    public void setDevice(Devices device) {
        this.device = device;
    }

    public Node getNodeTo() {
        return nodeTo;
    }

    public void setNodeTo(Node nodeTo) {
        this.nodeTo = nodeTo;
    }

    public Node getNodeFrom() {
        return nodeFrom;
    }

    public void setNodeFrom(Node nodeFrom) {
        this.nodeFrom = nodeFrom;
    }

    public Date getDate() {
        return date;
    }
}
