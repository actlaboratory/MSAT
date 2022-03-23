package org.actlab.msat.core.settingobjects;


abstract class Settingbase {
    protected String host;
    protected int port;
    protected String user;
    protected String password;
    protected boolean ssl;

    /**
     * @return String return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @return int return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @return String return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return boolean return the ssl
     */
    public boolean isSsl() {
        return ssl;
    }

}
