package com.spring.session.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangqianlong
 * @create 2019-03-21 21:48
 */
@RestController
public class HelloController {

    @RequestMapping("/testSessionId")
    public Map<String, Object> testSessionId(HttpServletRequest request) {
        Map<String, Object> sessionIdMap = new HashMap<String, Object>();
        String sessionId = request.getSession().getId();
        request.getSession().setAttribute("dada","nihaoya");
        int port = request.getServerPort();
        sessionIdMap.put("服务器端口",port);
        sessionIdMap.put("sessionId",sessionId);
        return sessionIdMap;
    }
}
