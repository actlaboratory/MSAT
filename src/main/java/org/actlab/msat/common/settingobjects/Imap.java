package org.actlab.msat.common.settingobjects;


public class Imap extends Settingbase{
    public Imap(
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