package com.demo.jwt.common;

import com.demo.jwt.JSONTokenInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

/**
 * description:TODO
 *
 * @version 1.0
 * @author: xianbang.yang
 * @date: 2019/10/26 16:10
 */

public class JWSTokenUtil {

    private static String jwt_token_user_id = "uid";
    /**
     * generate a secret key
     * @return
     */
    public static Key getKey(){
        SignatureAlgorithm es256 = SignatureAlgorithm.HS256;
        byte[] bytes = DatatypeConverter.parseBase64Binary("secret key");
        SecretKeySpec keySpec = new SecretKeySpec(bytes, es256.getJcaName());
        return keySpec;
    }

    /**
     * generate token String
     * @param tokenInfo
     * @param expire
     * @return
     */
    public static String getTokenStr(JSONTokenInfo tokenInfo, int expire){

        String token = Jwts.builder().claim(jwt_token_user_id, tokenInfo)
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.HS256, getKey()).compact();
        return token;
    }

    /**
     *  get token instance by parsing token string
     * @param token
     * @return
     */
    public static JSONTokenInfo getTokenInstance(String token){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getKey()).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        JSONTokenInfo jsonTokenInfo = new JSONTokenInfo(body.get(jwt_token_user_id).toString());
        return jsonTokenInfo;
    }


}
