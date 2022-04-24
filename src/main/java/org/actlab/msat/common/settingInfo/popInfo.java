package org.actlab.msat.common.settingInfo;

public class PopInfo extends SettingInfo{
    @Override
    public int calcPoint() {
        int point = 0;
        if(!ssl){
            point--;
        }
        if (!((port == 110)|(port == 995))) {
            point -= 3;
        }
        return point;
    }
}
