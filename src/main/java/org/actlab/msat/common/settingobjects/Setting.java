package org.actlab.msat.common.settingobjects;

public class Setting {
    private Pop pop = null;
    private Imap imap = null;
    private Smtp smtp = null;
    private String user;
    private String password;

    public Setting(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Pop getPop() {
        return pop;
    }

    public void setPop(Pop pop) {
        this.pop = pop;
    }

    public Imap getImap() {
        return imap;
    }

    public void setImap(Imap imap) {
        this.imap = imap;
    }

    public Smtp getSmtp() {
        return smtp;
    }

    public void setSmtp(Smtp smtp) {
        this.smtp = smtp;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

}
