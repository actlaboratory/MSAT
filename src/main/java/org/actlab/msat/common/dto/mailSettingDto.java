package org.actlab.msat.common.dto;

import org.actlab.msat.common.mailers.Mailerbase;
import org.actlab.msat.common.settingobjects.Setting;

public class mailSettingDto {
    private Setting setting;
    private Mailerbase mailer;

    public Setting getSetting() {
        return setting;
    }
    public void setSetting(Setting setting) {
        this.setting = setting;
    }
    public Mailerbase getMailer() {
        return mailer;
    }
    public void setMailer(Mailerbase mailer) {
        this.mailer = mailer;
    }
}
