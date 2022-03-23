package org.actlab.msat.common.settingobjects;

public class Smtp extends Settingbase{
    private boolean auth;

    public Smtp(
        String host,
        int port,
        boolean ssl,
        boolean auth,
        String user,
        String password
    ) {
        this.host = host;
        this.port = port;
        this.ssl = ssl;
        this.auth = auth;
        this.user = user;
        this.password = password;
    }    

    public boolean isAuth(){
        return this.auth;
    }
}
