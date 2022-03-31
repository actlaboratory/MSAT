package org.actlab.msat.common.dto;


import org.actlab.msat.common.settingobjects.Setting;

public class mailSettingDto {
    private Setting setting;
    private String mailerName;

    public Setting getSetting() {
        return setting;
    }
    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public String getMailerName() {
        return mailerName;
    }
    public void setMailerName(String mailerName) {
        this.mailerName = mailerName;
    }
}
