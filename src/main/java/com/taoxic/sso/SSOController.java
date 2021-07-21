package com.taoxic.sso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SSOController {

    @RequestMapping(value = "/taoxic/sso", method = RequestMethod.GET)
    public ModelAndView jumpUrlScheme(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
