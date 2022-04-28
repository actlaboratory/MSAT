package org.actlab.msat.common.settingobjects;


import java.util.Optional;

import org.actlab.msat.common.settingInfo.ImapInfo;
import org.actlab.msat.common.settingInfo.PopInfo;
import org.actlab.msat.common.settingInfo.SettingInfos;
import org.actlab.msat.common.settingInfo.SmtpInfo;
import org.actlab.msat.common.utils.mailAddressUtil;


public class SettingMapper {
    public static void mappingSettings(SettingInfos info, Setting setting){
        //todo: 冗長になっているので、共通化できそうなところを探す。
        Optional<SmtpInfo> smtpInfo = info.getBestSmtpInfo();
        smtpInfo.ifPresent((settingInfo) -> {
            String host = settingInfo.getHost()
            .replace(
                "%MX_DOMAIN", 
                setting.getMxRecords().firstEntry().getValue()
            );
            int port = settingInfo.getPort();
            boolean ssl = settingInfo.isSsl();
            String user = settingInfo.getUserName()
            .replace("%EMAILADDRESS%", setting.getAddress())
            .replace("%EMAILDOMAIN%", mailAddressUtil.getDomainFromAddress(setting.getAddress()))
            .replace("%EMAILLOCALPART%", mailAddressUtil.getMailAddressLocalPart(setting.getAddress()));
            Smtp smtp = new Smtp(host, port, ssl, user, setting.getPassword(), settingInfo);
            setting.setSmtp(smtp);
        });
        Optional<ImapInfo> imapInfo = info.getBestImapInfo();
        imapInfo.ifPresent((settingInfo) -> {
            String host = settingInfo.getHost()
            .replace(
                "%MX_DOMAIN", 
                setting.getMxRecords().firstEntry().getValue()
            );
            int port = settingInfo.getPort();
            boolean ssl = settingInfo.isSsl();
            String user = settingInfo.getUserName()
            .replace("%EMAILADDRESS%", setting.getAddress())
            .replace("%EMAILDOMAIN%", mailAddressUtil.getDomainFromAddress(setting.getAddress()))
            .replace("%EMAILLOCALPART%", mailAddressUtil.getMailAddressLocalPart(setting.getAddress()));
            Imap imap = new Imap(host, port, ssl, user, setting.getPassword(), settingInfo);
            setting.setImap(imap);
        });
        Optional<PopInfo> popInfo = info.getBestPopInfo();
        popInfo.ifPresent((settingInfo) -> {
            String host = settingInfo.getHost()
            .replace(
                "%MX_DOMAIN", 
                setting.getMxRecords().firstEntry().getValue()
            );
            int port = settingInfo.getPort();
            boolean ssl = settingInfo.isSsl();
            String user = settingInfo.getUserName()
            .replace("%EMAILADDRESS%", setting.getAddress())
            .replace("%EMAILDOMAIN%", mailAddressUtil.getDomainFromAddress(setting.getAddress()))
            .replace("%EMAILLOCALPART%", mailAddressUtil.getMailAddressLocalPart(setting.getAddress()));
            Pop pop = new Pop(host, port, ssl, user, setting.getPassword(), settingInfo);
            setting.setPop(pop);
        });
    }
}