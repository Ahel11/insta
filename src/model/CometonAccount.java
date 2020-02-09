package model;

import java.math.BigDecimal;

public class CometonAccount {

    private String username;
    private String password;
    private BigDecimal numberOfQueries;
    private String mail;

    @Override
    public String toString() {
        return "CometonAccount{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", numberOfQueries=" + numberOfQueries +
                ", mail='" + mail + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getNumberOfQueries() {
        return numberOfQueries;
    }

    public void setNumberOfQueries(BigDecimal numberOfQueries) {
        this.numberOfQueries = numberOfQueries;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
