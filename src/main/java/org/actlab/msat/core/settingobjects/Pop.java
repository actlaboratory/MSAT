package org.actlab.msat.core.settingobjects;

public class Pop extends Settingbase{

    public Pop(
        String host,
        int port,
        boolean ssl,
        String user,
        String password
    ) {
        this.host = host;
        this.port = port;
        this.ssl = ssl;
        this.user = user;
        this.password = password;
    }
}
