package org.actlab.msat.common.settingobjects;

import org.actlab.msat.common.settingInfo.PopInfo;

public class Pop extends Settingbase{
    private PopInfo info;

    public Pop(
        String host,
        int port,
        boolean ssl,
        String user,
        String password,
        boolean oauth2,
        PopInfo info
    ) {
        this.host = host;
        this.port = port;
        this.ssl = ssl;
        this.user = user;
        this.password = password;
        this.oauth2 = oauth2;
        this.info = info;
    }

    public PopInfo getInfo() {
        return info;
    }

}

