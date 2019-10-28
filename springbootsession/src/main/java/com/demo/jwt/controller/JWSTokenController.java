package com.demo.jwt.controller;

import com.demo.jwt.common.JWSTokenUtil;
import com.demo.jwt.JSONTokenInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description:TODO
 *
 * @version 1.0
 * @author: xianbang.yang
 * @date: 2019/10/26 16:21
 */
@RestController
public class JWSTokenController {

    @GetMapping("/testJWS")
    public String testJWS(String uid, HttpServletResponse response){
        JSONTokenInfo jsonTokenInfo = new JSONTokenInfo(uid);
        String token = JWSTokenUtil.getTokenStr(jsonTokenInfo, 3000);
        response.setHeader("Set-Cookie","access-token=" + token + ";PATH=/;HttpOnly");
        System.out.println(token);
        return token;
    }

    @GetMapping("/testToken")
    public JSONTokenInfo testToken(HttpServletRequest request, String token) throws Exception {
        if(token == null){
            for(Cookie cookie : request.getCookies()){
                if("access-token".equals(cookie.getName())){
                    token = cookie.getValue();
                    break;
                }
            }
        }
        if(token == null){
            throw new Exception("token无效！");
        }
        JSONTokenInfo tokenInfo = JWSTokenUtil.getTokenInstance(token);
        return tokenInfo;
    }

}
