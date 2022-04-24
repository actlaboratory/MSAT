package org.actlab.msat.common.settingInfo;



public class SmtpInfo extends SettingInfo{

    @Override
    public int calcPoint() {
        int point = 0;
        if(!ssl){
            point--;
        }
        if(port == 25){
            point -= 5;
        }
        else if(!((port == 587)|(port == 465))){
            point -= 2;
        }
        return point;
    }
}