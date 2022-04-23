package org.actlab.msat.common.settingInfo;


import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

public class SettingInfos {
    @Autowired
    private Validator validator;

    private TreeSet<ImapInfo> imapSettingList;
    private TreeSet<PopInfo> popSettingList;
    private TreeSet<SmtpInfo> smtpSettingList;

    {
        imapSettingList = new TreeSet<>();
        popSettingList = new TreeSet<>();
        smtpSettingList = new TreeSet<>();
    }

    public Optional<SmtpInfo> getBestSmtpInfo(){
        if(smtpSettingList.isEmpty()){
            return Optional.empty();
        }
        return Optional.ofNullable(smtpSettingList.last());
    }

    public boolean addSmtpInfo(SmtpInfo info){
        Set<ConstraintViolation<SmtpInfo>> result = validator.validate(info);
        if(!result.isEmpty()){
            return false;
        }
        smtpSettingList.add(info);
        return true;
    }

    public TreeSet<SmtpInfo> getSmtpSettingList() {
        return smtpSettingList;
    }

    public boolean addImapInfo(ImapInfo info){
        Set<ConstraintViolation<ImapInfo>> result = validator.validate(info);
        if(!result.isEmpty()){
            return false;
        }
        imapSettingList.add(info);
        return true;
    }

    public Optional<ImapInfo> getBestImapInfo(){
        if(imapSettingList.isEmpty()){
            return Optional.empty();
        }
        return Optional.ofNullable(imapSettingList.last());
    }

    public TreeSet<ImapInfo> getImapSettingList() {
        return imapSettingList;
    }

    public boolean addPopInfo(PopInfo info){
        Set<ConstraintViolation<PopInfo>> result = validator.validate(info);
        if(!result.isEmpty()){
            return false;
        }
        popSettingList.add(info);
        return true;
    }

    public  Optional<PopInfo> getBestPopInfo(){
        if(popSettingList.isEmpty()){
            return Optional.empty();
        }
        return Optional.ofNullable(popSettingList.last());
    }

    public TreeSet<PopInfo> getPopSettingList() {
        return popSettingList;
    }
}
