package com.demo.session.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * description:TODO
 *
 * @version 1.0
 * @author: xianbang.yang
 * @date: 2019/10/25 8:39
 */
@RestController
public class DemoController {

    @GetMapping("/uid")
    public String testUid(HttpSession session){
        UUID uuid = (UUID) session.getAttribute("uuid");
        if(uuid == null){
            uuid = UUID.randomUUID();
            session.setAttribute("uuid", uuid);
        }
        return session.getId() + ":[UUID]" + uuid;
    }

}
