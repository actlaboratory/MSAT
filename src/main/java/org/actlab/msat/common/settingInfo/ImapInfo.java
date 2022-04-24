package org.actlab.msat.common.settingInfo;

public class ImapInfo extends SettingInfo{

    @Override
    public int calcPoint() {
        int point = 0;
        if(!ssl){
            point--;
        }
        if(!((port == 143)|(port == 993))){
            point -= 2;
        }
        return point;
    }
}