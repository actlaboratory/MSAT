package org.actlab.msat.common.settingobjects;

import java.io.Serializable;

public class Setting implements Serializable{
    private Pop pop = null;
    private Imap imap = null;
    private Smtp smtp = null;
    private String address;
    private String user;
    private String password;
    private boolean guessedImap;
    private boolean guessedPop;

    public Setting(String user, String password) {
        this.address = user;
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

    public String getAddress(){
        return address;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public boolean isGuessedImap(){
        return guessedImap;
    }

    public void setGuessedImap(boolean guessedImap){
        this.guessedImap = guessedImap;
    }

    public boolean isGuessedPop(){
        return guessedPop;
    }

    public void setGuessedPop(boolean guessedPop){
        this.guessedPop = guessedPop;
    }
}
