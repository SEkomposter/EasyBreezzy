package by.komposter.ObjectFactory;

public class NodeUser {
    int idNodeUser, isAdmin;
    String login, password, surname, name, otchestvo;

    public int getIdNodeUser() {
        return idNodeUser;
    }

    public void setIdNodeUser(int idNodeUser) {
        this.idNodeUser = idNodeUser;
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

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public boolean getIsAdmin() {
        return (isAdmin==1?true:false);
    }

    public void setIsAdmin(boolean adm) {
        if (adm) this.isAdmin = 1;
    }
}
