package org.actlab.msat.common.settingobjects;

import java.io.Serializable;
import java.util.TreeMap;

import org.actlab.msat.common.settingInfo.ImapInfo;
import org.actlab.msat.common.settingInfo.PopInfo;
import org.actlab.msat.common.settingInfo.SettingInfo;
import org.actlab.msat.common.settingInfo.SettingInfos;
import org.actlab.msat.common.settingInfo.SmtpInfo;
import org.actlab.msat.common.utils.mailAddressUtil;
import java.util.Optional;

public class Setting implements Serializable{
    private Pop pop = null;
    private Imap imap = null;
    private Smtp smtp = null;
    private String address;
    private String user;
    private String password;
    private TreeMap<Integer, String> mxRecords;
    private boolean guessedImap = false;
    private boolean guessedPop = false;

    public Setting(String user, String password) {
        this.address = user;
        this.user = user;
        this.password = password;
        String domain = mailAddressUtil.getDomainFromAddress(user);
        Optional<TreeMap<Integer, String>> mx = mailAddressUtil.mxLookup(domain);
        mx.ifPresent((records) -> {
            this.mxRecords = records;
        });
    }

    public static Setting generateSettingFromInfo(SettingInfos info, String mailaddress, String password){
        Setting setting = new Setting(mailaddress, password);
        SettingMapper.mappingSettings(info, setting);
        return setting;
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

    public TreeMap<Integer, String> getMxRecords(){
        return mxRecords;
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
