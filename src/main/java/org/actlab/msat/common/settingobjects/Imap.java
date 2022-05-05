package org.actlab.msat.common.settingobjects;

import org.actlab.msat.common.settingInfo.ImapInfo;


public class Imap extends Settingbase{
    private ImapInfo info;

    public Imap(
        String host,
        int port,
        boolean ssl,
        String user,
        String password,
        boolean oauth2,
        ImapInfo info
    ) {
        this.host = host;
        this.port = port;
        this.ssl = ssl;
        this.oauth2 = oauth2;
        this.user = user;
        this.password = password;
        this.info = info;
    }

    public ImapInfo getInfo() {
        return info;
    }
}
