package com.taoxic.rest;

import com.taoxic.models.LoginCommand;
import com.taoxic.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final String RETURN_TO = "https://taoxic.kefu.easemob.com/v1/access/jwt";

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/v1/sso/login", method = RequestMethod.POST)
    @ResponseBody
    public void login(HttpServletResponse response, LoginCommand loginCommand) throws IOException {
        Map<String, String> result = authenticationService.login(loginCommand);
        if ("success".equals(result.get("result"))) {
            response.sendRedirect(RETURN_TO + "?jwt=" + result.get("jwt") + "&returnTo=https://taoxic.kefu.easemob.com/mo/agent/webapp/chat");
        }
    }
}
