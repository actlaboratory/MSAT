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
        PopInfo info
    ) {
        this.host = host;
        this.port = port;
        this.ssl = ssl;
        this.user = user;
        this.password = password;
        this.info = info;
    }

    public PopInfo getInfo() {
        return info;
    }

}

