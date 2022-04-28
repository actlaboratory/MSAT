package org.actlab.msat.common.settingsearchengines;

import java.util.TreeMap;

import org.actlab.msat.common.settingInfo.SettingInfos;


public interface SettingSearchEngineInterface {
    public boolean searchSetting(SettingInfos infos, String mailAddress, TreeMap<Integer, String> mxRecords);
}
