package org.actlab.msat.service;

import java.util.List;
import java.util.Map;

import org.actlab.msat.common.dto.UserInputDto;
import org.actlab.msat.common.dto.mailSettingDto;
import org.actlab.msat.common.mailers.Mailerbase;
import org.actlab.msat.common.settingobjects.Setting;
import org.actlab.msat.common.settingsearchengines.SettingSearchEngineInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SettingSearchService {
    @Autowired
    Map<String, Mailerbase> mailers;
    @Autowired
    List<SettingSearchEngineInterface> searchEngines;

    public mailSettingDto search(UserInputDto inputDto){
        String mailerName = inputDto.getMailerName();
        if(!mailers.containsKey(mailerName)){ //指定された名前を持つmailerが見つからない
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Setting setting = new Setting(inputDto.getMail(), inputDto.getPassword());
        for(SettingSearchEngineInterface engine : searchEngines){
            engine.search(setting);
        }
        mailSettingDto settingDto = new mailSettingDto();
        settingDto.setMailerName(mailerName);
        settingDto.setSetting(setting);
        return settingDto;
    }

}