package com.taoxic.sso;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

    @RequestMapping(value = "/qwen/translate", method = RequestMethod.GET)
    public ModelAndView translate(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index_translate");
        return mav;
    }
}
