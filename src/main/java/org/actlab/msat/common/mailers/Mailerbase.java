package org.actlab.msat.common.mailers;

import java.io.Serializable;

import org.actlab.msat.common.settingobjects.Setting;


public abstract class Mailerbase implements Serializable{
    public String getName() {
        return this.getClass().getSimpleName();
    }
    public String getFragmentName() {
        return "";
    }
    public boolean isSupportedGenerateAutoconfig() {
        return false;
    }
    public boolean isSupportedPop() {
        return true;
    }
    public boolean isSupportedImap() {
        return true;
    }

    public String generateAutoConfig(Setting setting){
        return "";
    }
}
