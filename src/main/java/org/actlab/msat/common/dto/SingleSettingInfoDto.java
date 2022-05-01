package org.actlab.msat.common.dto;

import org.actlab.msat.common.settingInfo.ImapInfo;
import org.actlab.msat.common.settingInfo.PopInfo;
import org.actlab.msat.common.settingInfo.SmtpInfo;

public class SingleSettingInfoDto {
    SmtpInfo smtp;
    ImapInfo imap;
    PopInfo pop;

    public SmtpInfo getSmtp() {
        return smtp;
    }
    public void setSmtp(SmtpInfo smtp) {
        this.smtp = smtp;
    }
    public ImapInfo getImap() {
        return imap;
    }
    public void setImap(ImapInfo imap) {
        this.imap = imap;
    }
    public PopInfo getPop() {
        return pop;
    }
    public void setPop(PopInfo pop) {
        this.pop = pop;
    }
}
