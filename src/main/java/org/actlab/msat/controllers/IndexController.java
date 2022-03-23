package org.actlab.msat.controllers;

import java.util.List;

import org.actlab.msat.common.mailers.Mailerbase;
import org.actlab.msat.controllers.forms.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    List<Mailerbase> mailers;

    @ModelAttribute("mailers")
    public List<Mailerbase> getMailers(){
        return mailers;
    }

    @RequestMapping("/")
    public String index(Form form){
        return "index";
    }

    public String accept(){
        return "accept";
    }
}

