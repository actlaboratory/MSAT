package org.actlab.msat.core.searchsetting;

import org.actlab.msat.core.settingobjects.Imap;
import org.actlab.msat.core.settingobjects.Pop;
import org.actlab.msat.core.settingobjects.Setting;
import org.actlab.msat.core.settingobjects.Smtp;

public class Dummy implements Searchsettinginterface{
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
