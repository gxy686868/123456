package com.jk.Cotroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class testController {
    @Value("server.port")
    private String serverPore;
    @Value("config.info")
    private String ConfigInfo;

    public String ConfigInfo(){
        return "serverPore:"+serverPore+"ConfigInfo:"+ConfigInfo;
    }
}
