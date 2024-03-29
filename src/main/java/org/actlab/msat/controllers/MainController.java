package org.actlab.msat.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.actlab.msat.common.dto.UserInputDto;
import org.actlab.msat.common.dto.mailSettingDto;
import org.actlab.msat.common.mailers.Mailerbase;
import org.actlab.msat.common.settingobjects.Setting;
import org.actlab.msat.common.utils.mailAddressUtil;
import org.actlab.msat.controllers.forms.Form;
import org.actlab.msat.service.SettingSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MainController {
    @Autowired
    Map<String, Mailerbase> mailers;

    @Autowired
    SettingSearchService searchService;

    @Autowired
    HttpSession session;



    @ModelAttribute("mailers")
    public Map<String, Mailerbase> getMailers(){
        return mailers;
    }

    @RequestMapping("/")
    public String index(Form form){
        return "index";
    }

    @PostMapping("/start")
    public String start(@Validated Form form, BindingResult result){
        if(!result.hasFieldErrors("mail")){
            String domain = mailAddressUtil.getDomainFromAddress(form.getMail());
            if(mailAddressUtil.mxLookup(domain).isEmpty()){
                result.rejectValue("mail", "invalid.form.mail", "invalid mail address");
            }
        }
        if(result.hasErrors()){
            return "index";
        }
        UserInputDto inputDto = new UserInputDto();
        inputDto.setMail(form.getMail());
        inputDto.setPassword(form.getPassword());
        inputDto.setMailerName(form.getMailer());
        mailSettingDto settingDto = searchService.search(inputDto);
        session.setAttribute("mailSetting", settingDto.getSetting());
        session.setAttribute("mailerName", settingDto.getMailerName());
        return "redirect:/disp";
    }

    @RequestMapping("/disp")
    public String dispSetting(@SessionAttribute("mailSetting") Setting setting, @SessionAttribute("mailerName") String mailerName, Model model){
        model.addAttribute("mailSetting", setting);
        model.addAttribute("usingMailer", mailers.get(mailerName));
        return "displaySettingInfo";
    }

}
