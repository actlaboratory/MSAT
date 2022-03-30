package org.actlab.msat.common.dto;

public class UserInputDto {
    private String mail;
    private String password;
    private String mailerName;
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMailerName() {
        return mailerName;
    }
    public void setMailerName(String mailerName) {
        this.mailerName = mailerName;
    }
}
