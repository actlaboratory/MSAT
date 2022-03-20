package org.actlab.msat.core.mailers;

import org.actlab.msat.core.settingobjects.Setting;

public abstract class Mailerbase {
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
