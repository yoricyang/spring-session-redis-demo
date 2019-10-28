package com.demo.jwt;

import lombok.Data;

/**
 * description:TODO
 *
 * @version 1.0
 * @author: xianbang.yang
 * @date: 2019/10/26 16:04
 */
@Data
public class JSONTokenInfo {
    //用户uuid
    private String uuid;
    //过期时间
    private int expire;

    public JSONTokenInfo(String uuid){
        this.uuid = uuid;
    }

}
