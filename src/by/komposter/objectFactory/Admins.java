package by.komposter.objectFactory;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "admins")
public class Admins {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idadmin")
    int idAdmin;

    //link "admins-transactions"
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
    Set<Transaction> transactionSet = new LinkedHashSet<Transaction>();

    @Column(name = "surname")
    String surname;
    @Column(name = "name")
    String name;
    @Column(name = "otchestvo")
    String secondName;
    @Column(name = "isadmin")
    int isAdmin;
    @Column(name = "login")
    String login;
    @Column(name = "password")
    String password;

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
