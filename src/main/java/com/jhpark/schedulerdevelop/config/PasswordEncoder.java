package com.jhpark.schedulerdevelop.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    /**
     * @apiNote 회원가입 시 입력한 패스워드를 암호화해서 데이터베이스에 저장
     * @param rawPassword
     * @return String
     */
    public String encode(String rawPassword) {
        return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, rawPassword.toCharArray());
    }

    /**
     * @apiNote 입력한 패스워드가 암호화된 패스워드와 일치하는지 체크
     * @param rawPassword
     * @param encodedPassword
     * @return boolean
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword);
        return result.verified;
    }
}
