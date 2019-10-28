package com.demo.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * description:TODO
 *
 * @version 1.0
 * @author: xianbang.yang
 * @date: 2019/10/23 9:02
 */

@RestController
public class DemoController {


    @RequestMapping("/uid")
    String testUid(HttpSession session){
        UUID uuid = (UUID) session.getAttribute("uid");
        if(uuid == null){
            uuid = UUID.randomUUID();
        }
        session.setAttribute("uid", uuid);
        return session.getId();
    }



}
