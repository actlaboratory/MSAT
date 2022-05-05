package org.actlab.msat.common.settingobjects;

import org.actlab.msat.common.settingInfo.SmtpInfo;

public class Smtp extends Settingbase{
    private SmtpInfo info;
    public Smtp(
        String host,
        int port,
        boolean ssl,
        String user,
        String password,
        boolean oauth2,
        SmtpInfo info
    ) {
        this.host = host;
        this.port = port;
        this.ssl = ssl;
        this.user = user;
        this.password = password;
        this.oauth2 = oauth2;
        this.info = info;
    }

    public SmtpInfo getInfo() {
        return info;
    }
}
