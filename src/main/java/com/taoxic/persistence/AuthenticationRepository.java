package com.taoxic.persistence;

import com.taoxic.models.UserData;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationRepository {

    private static UserData taoxicData =
            new UserData("taoxic", "1234", "sandbox20@zzz.com", "sandbox20");

    public UserData findByUserName(String username) {
        if (taoxicData.getUsername().equals(username)) {
            return taoxicData;
        } else {
            return null;
        }
    }
}
