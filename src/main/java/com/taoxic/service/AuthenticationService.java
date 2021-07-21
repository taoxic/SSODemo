package com.taoxic.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.taoxic.persistence.AuthenticationRepository;
import com.taoxic.models.LoginCommand;
import com.taoxic.models.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthenticationService {

    @Value("${easemob.sso.jwt.secret}")
    private String easemobJwtSecret;

    @Autowired
    private AuthenticationRepository authenticationRepository;

    public Map<String, String> login(LoginCommand command) {
        UserData userData = authenticationRepository.findByUserName(command.getUsername());
        Map<String, String> result = new HashMap<>();
        if (userData != null && userData.getPassword().equals(command.getPassword())) {
            String jwt = generateJwtToken(userData.getEasemobEmail(), userData.getEasemobName());
            result.put("result", "success");
            result.put("jwt", jwt);
        } else {
            result.put("result", "fail");
        }
        return result;
    }

    private String generateJwtToken(String easemobEmail, String easemobName) {
        return JWT.create()
                .withIssuedAt(new Date())
                .withJWTId(UUID.randomUUID().toString())
                .withClaim("email", easemobEmail)
                .withClaim("name", easemobName)
                .withClaim("state", "Online")
                .sign(Algorithm.HMAC256(easemobJwtSecret));
    }
}
