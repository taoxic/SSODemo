package com.taoxic.rest;

import com.taoxic.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController {


    @Autowired
    private TranslateService translateService;

    @RequestMapping(value = "/v1/translate", method = RequestMethod.POST)
    public String translate(@RequestParam(name = "address", required = false) String address,
                            @RequestParam(name = "apikey", required = false) String apikey,
                            @RequestParam(name = "targetLanguage", required = false) String targetLanguage,
                            @RequestParam(name = "sourceText", required = false) String sourceText,
                            @RequestParam(name = "prompt", required = false) String prompt) {
        System.out.println("/v1/translate, address: " + address + ", apikey: " + apikey + ", targetLanguage: " +
                targetLanguage + ", sourceText: " + sourceText + ", prompt: " + prompt);
        return translateService.translate(address, apikey, targetLanguage, sourceText, prompt);
    }
}
