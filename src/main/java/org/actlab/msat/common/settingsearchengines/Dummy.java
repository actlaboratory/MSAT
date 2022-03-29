package org.actlab.msat.common.settingsearchengines;

import org.actlab.msat.common.settingobjects.Imap;
import org.actlab.msat.common.settingobjects.Pop;
import org.actlab.msat.common.settingobjects.Setting;
import org.actlab.msat.common.settingobjects.Smtp;
import org.springframework.stereotype.Component;

@Component
public class Dummy implements SettingSearchEngineInterface{
    @Override
    public boolean search(Setting setting) {
        Pop pop = new Pop("actlab.org", 995, true, "test@actlab.org", "at113");
        Imap imap = new Imap("actlab.org", 993, true, "test@actlab.org", "atta2112");
        Smtp smtp = new Smtp("actlab.org", 465, true, true, "test@actlab.org", "attag2112");
        setting.setPop(pop);
        setting.setImap(imap);
        setting.setSmtp(smtp);
        return true;
    }
    
    
}
