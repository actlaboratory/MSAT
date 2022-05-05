package org.actlab.msat.common.settingInfo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public abstract class SettingInfo implements Serializable, Comparable<SettingInfo>{
    @NotNull
    protected String providerName;

    @NotNull
    protected String host;

    @NotNull
    @Max(65535)
    protected Integer port;

    @NotNull
    protected String userName;

    @NotNull
    protected Boolean ssl;

    protected boolean oauth2 = false;

    protected String description;

    protected String helpUrl;

    @NotNull
    protected String source;

    protected String sourceUrl;

    @NotNull
    @Past
    protected Date updatedDate;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean isSsl() {
        return ssl;
    }

    public boolean isOauth2() {
        return oauth2;
    }

    public void setOauth2(boolean oauth2) {
        this.oauth2 = oauth2;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHelpUrl() {
        return helpUrl;
    }

    public void setHelpUrl(String helpUrl) {
        this.helpUrl = helpUrl;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public int compareTo(SettingInfo target) {
        return Integer.valueOf(calcPoint()).compareTo(target.calcPoint());
    }

    abstract public int calcPoint();
}